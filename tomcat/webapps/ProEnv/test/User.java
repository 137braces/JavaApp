package test;

import java.util.*;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;


public class User {

    public static void main(String[] args) {

        //実際はリクエストされた値をgetParameterメソッドで取得。
        String email = "test_taro@gmail.com";
        String password = "mikan0713";

        //ハッシュ化したパスワードを入れる変数
        String hash = "";

        //パスワードをハッシュ化
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);
            System.out.println("Hashed Password: " + hash);
            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String psword = "";

        //emailとパスワードが一致した場合、select文で該当のユーザーを格納
        String sql = "SELECT * FROM users WHERE email=? AND password=?";
       
        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setString(1,email);
            ps.setString(2, hash);
            
            ResultSet res = ps.executeQuery();

            
            
            if(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                int age = res.getInt("age");
                String address = res.getString(("address"));
                String job = res.getString(("job"));
                
                System.out.println(id + " " + name + " " +  age + "歳" + " " + address + " " + job);
                System.out.println("ログイン成功");

            } else {
                System.out.println("ログイン失敗");
            }

            
        }catch (SQLException e) {
            e.printStackTrace();
        }       

    }

}