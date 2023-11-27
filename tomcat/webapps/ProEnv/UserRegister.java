import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class UserRegister extends HttpServlet {

    //空のコンストラクタ
    public UserRegister(){
        super();
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //テストを実行したら下記DELETE文でデータを削除。
        //Delete from users where id = (select is from users order by id desc limit1);
        String error_message = "";

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Beanを生成
        UserBean userBean = new UserBean();

        if((name == null || email == null) || (userBean.validatePassword(password))){

            // getterを使ってプロパティを代入
            userBean.setName(name);
            userBean.setEmail(email);
            userBean.setHash(password);

            UserRegisterDAO dbRegister = new UserRegisterDAO(userBean);
            
            if(userBean.getRes() != 0){
                if(userBean.getResNext()){
                    //ユーザー登録(INSERT)に成功した場合の処理
                    HttpSession session = request.getSession();
                    session.setAttribute("name", userBean.getId());
                    session.setAttribute("name", userBean.getName());

                    String path = "/WEB-INF/views/userRegisterResult.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);

                }else{

                }

            }else if(userBean.getRes() == 0){
                String path = "/WEB-INF/views/login.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);
            }
        
        }else{
            error_message = "入力された内容に不備があります。";
            request.setAttribute("error_message",error_message);

            String path = "/WEB-INF/views/login.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }
        
    }
        
        
        

}

//INSERT INTO users (name, email, password, gender, address, age ) VALUES ("星野さん", "ho@gmail.com", "mikan0713", "男性", "兵庫県", 29)