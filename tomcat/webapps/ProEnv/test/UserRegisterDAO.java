package test;

import pakage.userbean.UserBean;
import java.sql.*;

public class UserRegisterDAO {

    
        //名前、Eメール、パスワード、性別、アドレスを取得
        
    public UserRegisterDAO(UserBean userBean) {

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
        
        final String insertSql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";


        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(insertSql)) {

        
        ps.setString(1, userBean.getName());
        ps.setString(2, userBean.getEmail());
        ps.setString(3, userBean.getHash());
        
        
        int res = ps.executeUpdate();

        userBean.setRes(res);
        
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }


        if(userBean.getRes() != 0){
            //セッションにユーザーidを格納するため、SELECT文を実行しidを取得。
            final String selectSql = "SELECT * FROM users WHERE email=? AND password=?";

            try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
            PreparedStatement ps = con.prepareStatement(selectSql)) {

        
            ps.setString(1, userBean.getEmail());
            ps.setString(2, userBean.getHash());
            
            
            ResultSet res = ps.executeQuery();

            //SELECT文の結果をUserRegister.javaへ真偽値を渡すための変数。
            boolean resNext;
                
                if(resNext = res.next()){
                    userBean.setId(res.getString("id"));
                    userBean.setName(res.getString("name"));
                    
                } else {
                
                }
                userBean.setResNext(resNext);

            }catch (SQLException e) {
                e.printStackTrace();          
            }

        }else if(userBean.getRes() == 0){
            //もし、INSERTが失敗した場合、
            //ここでは何も処理せず、UserRegister.java側に処理を記載
        }   
        
    }
    
}


