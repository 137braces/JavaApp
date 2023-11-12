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
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        
        
        // Beanを生成
        UserBean userBean = new UserBean();

        // getterを使ってプロパティを代入
        userBean.setName(name);
        userBean.setEmail(email);
        userBean.setPassword(password);

        if(userBean.getRes() != 0){
            UserRegisterDAO dbRegister = new UserRegisterDAO(userBean);
            HttpSession session = request.getSession();
            session.setAttribute("users", userBean);
        } else {

        }

        
        String path = "/WEB-INF/views/AccountRegisterResult.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);
        
        
    }
        
        
        

}

//INSERT INTO users (name, email, password, gender, address, age ) VALUES ("星野さん", "ho@gmail.com", "mikan0713", "男性", "兵庫県", 29)