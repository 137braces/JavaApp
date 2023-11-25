package test;

import java.util.Random;

import pakage.userbean.UserBean;

public class UserVisit_doGet {

    public static void main(String[] args) {

        //表示させたい他のユーザーid
        Random random = new Random();
        final String other_id = String.valueOf(random.nextInt(7) + 2);

        //自分の性別
        final String gender = "男性";//今回は自分の性別。

        UserBean userBean = new UserBean();
        userBean.setId(other_id);

        //下記メソッドは自分を含めた同性検索をフィルターするため。
        userBean.ifGender(gender);

        //DAOインスタンスを作成
        UserVisitDAO userVisitDAO = new UserVisitDAO(userBean);


        if(userBean.getResNext()){

            System.out.println(userBean.getId() + " " + userBean.getName() + " " + userBean.getAge() + "歳" + " " + userBean.getAddress() + " " + userBean.getJob());

            String view = "/WEB-INF/views/other_user.jsp";
            System.out.println("遷移先は：" + view);

        }else if(userBean.getResNext() == false ){

            String view = "お探しのページは見つかりません。";//遷移先はいずれ設定する。
            System.out.println(view);

        }

    }
      
}

    


