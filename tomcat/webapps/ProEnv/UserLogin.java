import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;



public class UserLogin extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
        rd.forward(request, response);
        

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String error_message;

        //getParameterメソッドで入力された値を取得。
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //ゲストユーザーがログインボタンを押したとき、文字列・"ゲストユーザーでログイン"が送られる。
        final String gestParam = request.getParameter("gest");

        //ゲストユーザー以外がログインを試みた際は以下try構文は実施しない。
        if(gestParam != null){
            try{
                if("ゲストユーザーでログイン".equals(request.getParameter("gest"))){
                    email = "gest_user@gmail.com";
                    password = "mikan0713";
                }
            }catch(NullPointerException n){
                error_message = "ログインに失敗しました。";
                request.setAttribute("error_message",error_message);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
                rd.forward(request, response);
            }
        }

        //インスタンス化
        UserBean userBean = new UserBean();

        //email、passwordのプロパティをセット
        userBean.setEmail(email);
        userBean.setPassword(password);

        //passwordハッシュ化
        userBean.setHash(userBean.getPassword());
        
        UserLoginDAO dbDao = new UserLoginDAO(userBean);

        //真偽値で画面の遷移先を決める
        boolean resNext = userBean.getResNext();

        //下記で遷移先を決定
        if(resNext == true){
            //セッションにUserBeanプロパティで必要な情報のみを格納。
            HttpSession session = request.getSession();
            
            //セッション変数にユーザープロパティをセット。
            session.setAttribute("id", userBean.getId());
            session.setAttribute("name", userBean.getName());
            session.setAttribute("gender", userBean.getGender());
            session.setAttribute("age", userBean.getAge());
            session.setAttribute("address", userBean.getAddress());
            session.setAttribute("job", userBean.getJob());
            session.setAttribute("image", userBean.getImage());

            //遷移先
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
            rd.forward(request, response);

        }else if(resNext == false){
            error_message = "メールアドレス、もしくはパスワードが間違っています。";
            request.setAttribute("error_message",error_message);

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            rd.forward(request, response);
        }   
                    
    }

}