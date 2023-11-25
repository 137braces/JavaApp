package test;

import pakage.userbean.UserBean;
import java.sql.*;

public class UserVisitDAO {

    public UserVisitDAO(UserBean userBean) {

        //データベースへの接続情報
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";

        //ユーザー検索
        final String sql = "SELECT * FROM users where id = ? and gender = ?";


        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {

        
        ps.setString(1, userBean.getId());
        ps.setString(2, userBean.getGender());
        
        
        ResultSet res = ps.executeQuery();

        boolean resNext;

        //処理結果をUserVisit.javaで利用する。
        if(resNext = res.next()){
            userBean.setId(res.getString("id"));
            userBean.setName(res.getString("name"));
            userBean.setAge(res.getInt("age"));
            userBean.setAddress(res.getString("address"));
            userBean.setJob(res.getString("job"));
        }
        
        //処理結果をUserVisit.javaと共有。
        userBean.setResNext(resNext);
        
        }catch (SQLException e) {
            e.printStackTrace();          
        }
    
    }
    
}



