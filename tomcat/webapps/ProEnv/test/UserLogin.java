package test;

import pakage.userbean.UserBean;

public class UserLogin {

    public static void main(String[] args) {

        //実際はリクエストされた値をgetParameterメソッドで取得。
        String email = "test_taro@gmail.com";
        String password = "mikan0713";

        System.out.println(password);

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
        if(resNext){
            //実際はここでセッションにUserBean情報を格納する。
            System.out.println(userBean.getId() + " " + userBean.getName() + " " + userBean.getAge() + "歳" + " " + userBean.getAddress() + " " + userBean.getJob());
            System.out.println("ログイン成功:遷移先は:user.jsp");

        }else{
            System.out.println("ログイン失敗:遷移先はlogin.jsp");
            
        }
    }

}