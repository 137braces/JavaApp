package test;

import pakage.userbean.UserBean;
import java.sql.*;


public class UserLoginDAO{

    public UserLoginDAO(UserBean userBean){

        final String email = userBean.getEmail();
        final String hash = userBean.getHash();


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String psword = "";

        //emailとパスワードが一致した場合、select文で該当のユーザーを格納
         final String sql = "SELECT * FROM users WHERE email=? AND password=?";
       
        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setString(1,email);
            ps.setString(2, hash);
            
            ResultSet res = ps.executeQuery();

            //遷移先を決めるのに利用する変数
            boolean resNext;
            
            if(resNext = res.next()){
                userBean.setId(res.getString("id"));
                userBean.setEmail(res.getString("email"));
                userBean.setAge(res.getInt("age"));
                userBean.setAddress(res.getString("address"));
                userBean.setJob(res.getString("job"));
                

                userBean.setResNext(resNext);

            } else {
            
            }

            
        }catch (SQLException e) {
            e.printStackTrace();
        }       

    }

}