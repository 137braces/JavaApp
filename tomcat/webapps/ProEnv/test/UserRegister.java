package test;

import pakage.userbean.UserBean;

public class UserRegister {
    public static void main(String[] args) {
        //getParameter()から取り出した値
        String name = "22222";
        String email = "aokitaddwro0713@gmail.com";
        String password = "mikan0713";

        // Beanを生成
        UserBean userBean = new UserBean();

        // getterを使ってプロパティを代入
        userBean.setName(name);
        userBean.setEmail(email);

        //setPasswordメソッドはパスワードをハッシュ化。
        userBean.setPassword(password);

        //パスワードがハッシュ化されているかの確認。
        System.out.println(userBean.getPassword());

        UserRegisterDAO dbRegister = new UserRegisterDAO(userBean);


        if(userBean.getRes() != 0){
            System.out.println("登録成功");
        } else if(userBean.getRes() == 0) {
            System.out.println("登録失敗");
        }

        //↓↓テストが終わったら登録した1行のデータを削除
        //DELETE FROM users ORDER BY column_name id LIMIT 1;
    
    }
}
