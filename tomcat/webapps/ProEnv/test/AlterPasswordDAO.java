package test;

import pakage.userbean.UserBean;
import java.sql.*;

public class AlterPasswordDAO {

    
    public AlterPasswordDAO(UserBean user_bean) {

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
        
        final String sql = "UPDATE users SET password = (?) where id = (?)";

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, user_bean.getHash());
        ps.setString(2, user_bean.getId());
        
        
        int res = ps.executeUpdate();

        user_bean.setRes(res);
        
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }
    }


}