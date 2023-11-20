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
        
        //遷移先
        String path = "";

        String success_message = "";
        String error_message = "";

        //↓　パスワードを元に戻すSQL文
        //UPDATE users SET password='0HZCrZa+RN65MUlirxhEZ4nsWHKpxFep3QvspuMQL8s=' where id = 1;

        //UserBeanインスタンスを作成
        UserBean userBean = new UserBean();

        HttpSession session = request.getSession();
        //自分のユーザーID
        String id = (String)session.getAttribute("id");

        //今回はテスト用アカウントのid = 1を使用
        userBean.setId(id);

        //セッションに保存していた元のパスワード(ハッシュ化は既にされている)
        final String origin_password = (String)session.getAttribute("password");

        //ユーザーが入力した元のパスワード
        //final String password = "mikan0713";
        final String password = request.getParameter("password");
        String hash = "";

        //上記password変数をハッシュ化
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);

            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            }


        //ユーザーが変更したいパスワード
        final String alter_password1 = request.getParameter("alter_password1"); //成功例
        //final String alter_password1 = "ringo0713"; //・小文字と数字はあるが、大文字と記号がないパターン。
        //final String alter_password1 = "ringo0713@"; //・小文字と数字はあるが、記号がないパターン。

        //ユーザーが再入力するパスワード
        final String alter_password2 = request.getParameter("alter_password2"); //成功例
        //final String alter_password2 = "ringo0713";・小文字と数字はあるが、大文字と記号がないパターン。
        //final String alter_password2 = "ringo0713@";・小文字と数字はあるが、記号がないパターン。
        //final String alter_password2 = "Ringo0919@";・間違ったパスワードを再入力したパターン。

        //セッションに保存された元のパスワードと入力された現在のパスワードを文字列で比較
        if(origin_password.equals(hash)){

            //新しいパスワードの入力段階(パターンの一致、再入力パスワードの一致、)
            if(userBean.validatePassword(alter_password1) && (alter_password1.equals(alter_password2))){
    
                //パスワードをハッシュ化
                userBean.setPassword(alter_password1);
                userBean.setHash(userBean.getPassword());

                //セッションに保存されている元のパスワードと変更する予定のハッシュ化したパスワードの比較、
                //文字列が同じでなければ、変更処理を実施。
                if(origin_password.equals(userBean.getHash()) == false){

                    AlterPasswordDAO dbAlterPassword = new AlterPasswordDAO(userBean);
                    final int res = userBean.getRes();

                    if(res != 0){
                        success_message = "1.パスワードの変更が完了しました。";
                        
                        //セッションに再度パスワードを格納
                        session.setAttribute("password", userBean.getHash());

                        request.setAttribute("success_message",success_message);

                        path = "/WEB-INF/views/alter_password.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(path);
                        rd.forward(request, response);

                    }else if(res == 0){
                        error_message = "1.パスワードの変更に失敗しました。";
                        
                        request.setAttribute("error_message",error_message);
                        path = "/WEB-INF/views/setting.jsp";
                        RequestDispatcher rd = request.getRequestDispatcher(path);
                        rd.forward(request, response);
                    }

                }else if(origin_password.equals(userBean.getHash())){
                    error_message = "新しいパスワードに設定してください。";
                    request.setAttribute("error_message",error_message);

                    path = "/WEB-INF/views/setting.jsp";
                    RequestDispatcher rd = request.getRequestDispatcher(path);
                    rd.forward(request, response);
                }
                
            
            //パスワードがパターンとマッチしなかった場合の処理
            }else if((userBean.validatePassword(alter_password1) == false) || (alter_password1.equals(alter_password2)) == false) {
            
                error_message = "パスワードが間違っているか、入力内容に不備があります。";
                request.setAttribute("error_message",error_message);

                path = "/WEB-INF/views/setting.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);

            }
            
        //現在のパスワードが間違っていた際の処理
        }else if(origin_password.equals(hash) == false){
            error_message = "入力された現在のパスワードが間違っています。";
            request.setAttribute("error_message",error_message);

            path = "/WEB-INF/views/setting.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }
        
    
               
    }

}