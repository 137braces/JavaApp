package test;

import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import pakage.userbean.UserBean;



public class AlterPassword {

    public static void main(String[] args) {

        String success_message = "";
        String error_message = "";

        //↓　パスワードを元に戻すSQL文
        //UPDATE users SET password='0HZCrZa+RN65MUlirxhEZ4nsWHKpxFep3QvspuMQL8s=' where id = 1;

        //AlterPasswordDAOインスタンスを作成
        AlterPasswordDAO alterPasswordDAO = new AlterPasswordDAO();

        //セッションに保存していたidを取得。
        //今回はテスト用アカウントのid = 1を使用
        String id = "1";

        //ユーザーが入力した元のパスワード
        final String password = "mikan0713";
        //final String password = "mikan0000";
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
        
        //idとハッシュ化されたパスワードをもとにDB検索を実行後、ユーザーのパスワードを取得
        alterPasswordDAO.searchPassword(id,hash);
        
        
        //DB検索して取得した元のパスワードを取得。
        final String origin_password = alterPasswordDAO.getOriginPassword();


        //ユーザーが変更したいパスワード
        final String alter_password1 = "Ringo0713@"; //成功例
        //final String alter_password1 = "ringo0713"; //・小文字と数字はあるが、大文字と記号がないパターン。
        //final String alter_password1 = "ringo0713@"; //・小文字と数字はあるが、記号がないパターン。

        //ユーザーが再入力するパスワード
        final String alter_password2 = "Ringo0713@"; //成功例
        //final String alter_password2 = "ringo0713";・小文字と数字はあるが、大文字と記号がないパターン。
        //final String alter_password2 = "ringo0713@";・小文字と数字はあるが、記号がないパターン。
        //final String alter_password2 = "Ringo0919@";・間違ったパスワードを再入力したパターン。
        
        //UserBeanインスタンスを作成
        UserBean userBean = new UserBean();

        //セッションに保存された元のパスワードと入力された現在のパスワードを文字列で比較
        if(hash.equals(origin_password)){

            //新しいパスワードの入力段階(パターンの一致、再入力パスワードの一致、)
            if(userBean.validatePassword(alter_password1) && (alter_password1.equals(alter_password2))){
    
                //パスワードをハッシュ化
                userBean.setHash(alter_password1);
                userBean.setId(id);

                //文字列が同じでなければ、変更処理を実施。
                if(origin_password.equals(userBean.getHash()) == false){

                    alterPasswordDAO.alterPassword(userBean);                    

                    final int res = userBean.getRes();

                    if(res != 0){
                        success_message = "1.パスワードの変更が完了しました。";
                        System.out.println(success_message);

                    }else if(res == 0){
                        error_message = "1.パスワードの変更に失敗しました。";
                        System.out.println(error_message);
                    }

                }else if(origin_password.equals(userBean.getHash())){
                    error_message = "2.新しいパスワードに設定してください。";
                    System.out.println(error_message);
                }
                
            
            //パスワードがパターンとマッチしなかった場合の処理
            }else if((userBean.validatePassword(alter_password1) == false) || (alter_password1.equals(alter_password2)) == false) {
            
                error_message = "3.パスワードが間違っているか、入力内容に不備があります。";
                System.out.println(error_message);
                System.out.println("対象パスワード：" + alter_password1);

            }
            
        //現在のパスワードが間違っていた際の処理
        }else if(origin_password.equals(hash) == false){
            System.out.println("4.入力された現在のパスワードが間違っています。");
            System.out.println("セッションのパスワード" + origin_password);
            System.out.println("入力されたパスワード" + hash);
        }
        
    

    }

   
    

}