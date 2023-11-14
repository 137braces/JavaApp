import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;



public class AlterPassword extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = "";

        final String success_message = "パスワードの変更が完了しました";
        String error_message = "";

        //UserBeanインスタンスを作成
        UserBean userBean = new UserBean();
        
        HttpSession session = request.getSession();

        //セッションに保存していた元のパスワード(ハッシュ化は既にされている)
        final String origin_password = (String)session.getAttribute("password");

        //ユーザーが入力した元のパスワード
        final String password = request.getParameter("password");
        userBean.setHash(password);

        final String alter_password1 = request.getParameter("alter_password1");
        final String alter_password2 = request.getParameter("alter_password2");
        


        //現在のパスワード同士を文字列で比較
        if(origin_password.equals(userBean.getHash())){

            if(userBean.validatePassword(password) && (alter_password1.equals(alter_password2))){
    
            //パスワードをハッシュ化
            userBean.setPassword(password);
            userBean.setHash(userBean.getPassword());

            AlterPasswordDAO dbAlterPassword = new AlterPasswordDAO(userBean);
            final int res = userBean.getRes();

                if(res != 0){
                    path = "/WEB-INF/views/alter_password.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);
                }else if(res == 0){

                }
            
            //パスワードがパターンとマッチしなかった場合の処理
            } else if((userBean.validatePassword(password) == false) || (alter_password1.equals(alter_password2)) == false) {
            
            error_message = "パスワードが間違っているか、入力内容に不備があります。";
            request.setAttribute("message",error_message);

            path = "/WEB-INF/views/alter_password.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);

        }
            
        //現在のパスワードが間違っていた際の処理
        }else if(origin_password.equals(userBean.getHash()) == false){

        }
        
        
       
    
               
    }

}