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

        String success_message = "";
        String error_message = "";
        String path = "";

        //↓　パスワードを元に戻すSQL文
        //UPDATE users SET password='0HZCrZa+RN65MUlirxhEZ4nsWHKpxFep3QvspuMQL8s=' where id = 1;

        //AlterPasswordDAOインスタンスを作成
        AlterPasswordDAO alterPasswordDAO = new AlterPasswordDAO();

        //セッションに保存していたidを取得。
        HttpSession session = request.getSession(false);
        String id = (String)session.getAttribute("id");

        //ユーザーが入力した元のパスワード
        final String password = request.getParameter("password");
        //ユーザーが変更したいパスワード
        final String alter_password1 = request.getParameter("alter_password1");
        final String alter_password2 = request.getParameter("alter_password2");

        String hash = "";

        try{
            //例外が発生する可能性がある箇所。
            //NullPointerExceptionを検知したら、settingページへ飛ぶ。

            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(password.getBytes());
                byte[] hashBytes = md.digest();
                hash = Base64.getEncoder().encodeToString(hashBytes);

                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            
            //idとハッシュ化されたパスワードをもとにDB検索を実行後、ユーザーのパスワードを取得
            alterPasswordDAO.searchPassword(id,hash);
            
            
            //DB検索して取得した元のパスワードを取得。
            final String origin_password = alterPasswordDAO.getOriginPassword();

            //UserBeanインスタンスを作成
            UserBean userBean = new UserBean();
            
                //DBに保存された元のパスワードと入力された現在のパスワードを文字列で比較
                if(hash.equals(origin_password)){

                    //新しいパスワードの入力段階(パターンの一致、再入力パスワードの一致、)
                    if(userBean.validatePassword(alter_password1) && (alter_password1.equals(alter_password2))){
            
                        //パスワードをハッシュ化
                        userBean.setHash(alter_password1);
                        userBean.setId(id);

                        //セッションに保存されている元のパスワードと変更する予定のハッシュ化したパスワードの比較、
                        //文字列が同じでなければ、変更処理を実施。
                        if(origin_password.equals(userBean.getHash()) == false){

                            alterPasswordDAO.alterPassword(userBean); 
                            final int res = userBean.getRes();


                            if(res != 0){
                                success_message = "パスワードの変更が完了しました。";
                                
                                request.setAttribute("success_message",success_message);

                                path = "/WEB-INF/views/alter_password.jsp";
                                RequestDispatcher rd = request.getRequestDispatcher(path);
                                rd.forward(request, response);

                            }else if(res == 0){
                                error_message = "パスワードの変更に失敗しました。";
                                
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

            }catch(NullPointerException n){
                error_message = "パスワードを入力してください。";
                            
                request.setAttribute("error_message",error_message);
                path = "/WEB-INF/views/setting.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);

                n.printStackTrace();
            }   

    }

}