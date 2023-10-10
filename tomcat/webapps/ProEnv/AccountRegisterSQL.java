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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";
        int res = 0;
        

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, usermodel.getName());
        ps.setString(2, usermodel.getEmail());
        ps.setString(3, usermodel.getPassword());
        
        
        res = ps.executeUpdate(sql);

        if(res > 0){

        } else if(res == 0){
            
        }
        
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }
    
    }
    
}


