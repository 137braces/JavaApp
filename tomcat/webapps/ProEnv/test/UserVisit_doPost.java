package test;

import java.util.Random;

import pakage.follwbean.FollowBean;

public class UserVisit_doPost {
    //INSERT INTO follows (followee_id,follower_id) VALUES (1, 2);
    //INSERT INTO follows (followee_id,follower_id) VALUES (2, 1);
    //truncate table follows;

    public static void main(String[] args){
        //doPostはユーザーのいいね処理を実装します。

        //下記ユーザーidフォロー機能に利用します。
        //相手のユーザーid
        final String other_id = "2";
         
        //自分のユーザーid
        final String self_id = "1";

        //インスタンスを作成。
        FollowBean followBean = new FollowBean();
        //相手と自分のユーザーidをプロパティに格納。
        followBean.setFollows(self_id, other_id);

        //DAOにfollowBeanプロパティを渡す。
        UserFollowsDAO followsDAO = new UserFollowsDAO(followBean);

        //INSERT文の結果を取得
        int res = followBean.getRes();


        //INSERT文の処理が成功すればSELECT文が実行される。
        if(res != 0){   
            //SELECT文の処理結果
            boolean resNext = followBean.getResNext();

            //マッチング(相互フォロー)になったときの処理。(ajax通信)
            if(resNext){
                //JavaScriptで値取得をトリガーに画面に「マッチングしました！」と表示する。
                System.out.println("マッチングしました！");
                //マッチング後、メッセージルームを取得。
            
            }else if(resNext == false){
                //相互フォローではないときは何もしない。
                
            }

        }else{
            //INSERT文が失敗したときの処理。
        }
    }
}
