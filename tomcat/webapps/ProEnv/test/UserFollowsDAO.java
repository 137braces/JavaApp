package test;

import java.sql.*;

import pakage.follwbean.FollowBean;

public class UserFollowsDAO {

    public UserFollowsDAO(FollowBean followBean){

         //データベース接続情報
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";
    
        //データベースに接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        final String InsertSql = "INSERT INTO follows (followee_id,follower_id) VALUES (?, ?)";

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(InsertSql)) {
        
        ps.setString(1, followBean.getFollowee()); //自分のユーザーid
        ps.setString(2, followBean.getFollower()); //相手のユーザーid

        int res = ps.executeUpdate();
        followBean.setRes(res);

        
        }catch (SQLException e) {
            e.printStackTrace();          
        }


        if(followBean.getRes() != 0){

            final String SelectSql = "SELECT * from follows where followee_id =(?) and follower_id =(?)";
    
            //いいね処理を実行した後、お互いが相互フォロー(いいね！)状態であるか検索する。
            try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
            PreparedStatement ps = con.prepareStatement(SelectSql)) {
            
            ps.setString(1, followBean.getFollower()); //相手のユーザーid
            ps.setString(2, followBean.getFollowee()); //自分のユーザーid
            //上記は逆転させただけなので分かりづらいかもしれない
            //要は相手も自分をフォローしているか検索したい。

            ResultSet res = ps.executeQuery();
            
            //SELECT文の結果を格納する変数
            boolean resNext;
            
            //相互フォロー状態(マッチング)になったときの処理。
            if(resNext = res.next()){
                //メッセージルームを作る処理を実装。

            }else if(resNext == false){

            }

            followBean.setResNext(resNext);
            

            }catch (SQLException e) {
                e.printStackTrace();          
            }

        }else{
            
        }

        
    }
    
}
