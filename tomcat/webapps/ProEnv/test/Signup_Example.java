package test;

import java.sql.*;

public class Signup_Example {
    public static void main(String[] args) {

        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";
        int res = 0;
        
    //データベースに接続
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        String name = "テスト太郎";
        String email = "testtaro@gmail.com";
        String password = "mikan0713";
        String sql = "INSERT INTO users (name, email, password) VALUES (?,?,?);";

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        
        
        res = ps.executeUpdate();
        
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