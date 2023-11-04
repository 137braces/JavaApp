import java.util.*;

import pakage.userbean.UserBean;

import java.io.*;
import java.sql.*;

public class UserRegisterDAO {

    
        //名前、Eメール、パスワード、性別、アドレスを取得
        
    public UserRegisterDAO(UserBean user_bean) {
    
        //データベースに接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";
      
        
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";


        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {

        
        ps.setString(1, user_bean.getName());
        ps.setString(2, user_bean.getEmail());
        ps.setString(3, user_bean.getPassword());
        
        
        int res = ps.executeUpdate();

        if(res > 0){
            System.out.println("成功しました。");
        } else if(res == 0){
            System.out.println("失敗しました。");
        }
        
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }
    
    }
    
}


