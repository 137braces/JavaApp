import pakage.userbean.UserBean;
import java.sql.*;

public class AlterPasswordDAO {

    private String originPassword;

    public String getOriginPassword(){
        return originPassword;
    }

    public void setOriginPassword(String originPassword){
        this.originPassword = originPassword;
    }

    public void searchPassword(String id, String originPassword){

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
        
        final String sql = "SELECT password FROM users WHERE id = ? AND password = ?";

        try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
        PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, id);
        ps.setString(2, originPassword);
        
        
        ResultSet res = ps.executeQuery();

        if(res.next()){
            setOriginPassword(res.getString("password"));

        }
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }
        
    }

    public void alterPassword(UserBean userBean) {

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

        ps.setString(1, userBean.getHash());
        ps.setString(2, userBean.getId());
        
        
        int res = ps.executeUpdate();

        userBean.setRes(res);
        
    
        }catch (SQLException e) {
            e.printStackTrace();          
        }
    }


}
