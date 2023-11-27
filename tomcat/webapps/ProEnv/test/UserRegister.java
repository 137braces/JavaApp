package test;

import pakage.userbean.UserBean;

public class UserRegister{

    public static void main(String[] args) {
        
        //テストを実行したら下記DELETE文でデータを削除。
        //delete from users where name = 'カミキヒカル';
        String error_message = "";

        String name = "カミキヒカル";
        //String name = null;

        String email = "hikaru@gmail.com";
        //String email = null;

        String password = "Ringo0713@";
        //String password = null;
        //String password = ringo0713;


        // Beanを生成
        UserBean userBean = new UserBean();

        if((name == null || email == null) || (password == null || userBean.validatePassword(password))){

            // getterを使ってプロパティを代入
            userBean.setName(name);
            userBean.setEmail(email);
            userBean.setHash(password);

            UserRegisterDAO dbRegister = new UserRegisterDAO(userBean);
            
            if(userBean.getRes() != 0){
                if(userBean.getResNext()){
                    //ユーザー登録(INSERT)に成功した場合の処理
                    System.out.println("登録内容：" + userBean.getName() + 
                    userBean.getEmail() + userBean.getHash());

                    String path = "/WEB-INF/views/userRegisterResult.jsp";
                    System.out.println("遷移先："+ path);
                }else{
                    System.out.println("テスト失敗");
                }

            }else if(userBean.getRes() == 0){
                error_message = "入力内容に不備があります。";
                System.out.println(error_message);

                String path = "/WEB-INF/views/login.jsp";
                System.out.println("遷移先："+ path);
            }
        
        }else{
            error_message = "入力された内容に不備があります。";
            System.out.println(error_message);

            String path = "/WEB-INF/views/login.jsp";
            System.out.println("遷移先："+ path);
        }
    }        

}

//INSERT INTO users (name, email, password, gender, address, age ) VALUES ("星野さん", "ho@gmail.com", "mikan0713", "男性", "兵庫県", 29)