import java.util.*;
import java.io.*;
import java.sql.*;
import pakage.usermodel.UserModel;

public class AccountRegisterSQL {

    
        //名前、Eメール、パスワード、性別、アドレスを取得
        
    public AccountRegisterSQL(UserModel usermodel) {
    
    
        String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";

        //データベースに接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";
      
        

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {

        
        ps.setString(1, usermodel.getName());
        ps.setString(2, usermodel.getEmail());
        ps.setString(3, usermodel.getPassword());
        
        
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


