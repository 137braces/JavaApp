import java.util.*;

import javax.sql.rowset.serial.SerialException;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;

public class UserEdit extends HttpServlet {

    //空のコンストラクタ
    public UserEdit(){
        super();
    }

    //データベースへの接続情報
    final String SqlUrl = "jdbc:mysql://localhost/mydb";
    final String SqlRoot = "root";
    final String SqlPass = "";
    

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user_edit.jsp");
        rd.forward(request, response);
        
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
            HttpSession session = request.getSession(false);
            String id = (String)session.getAttribute("id");

            // Beanを生成
            UserBean user_bean = new UserBean();
            
    
            //リクエストで送信されたパラメータ
            String address = request.getParameter("address");
            String job = request.getParameter("job");

            String sql = "";
        
            //Ajax通信は1つのフォームが変更されると非同期通信されるので、※以下続き
            //→nullじゃなければ変更したカラムに対応したINSERT文をsql変数に格納。
            //同時にUserBeanインスタンスのプロパティにもsetterメソッド格納。
            if(address != null){
                sql = "UPDATE users SET address = (?) where id = " + id;
                user_bean.setAddress(address);

            }else if(job != null){
                sql = "UPDATE users SET job = (?) where id= " + id;
                user_bean.setJob(job);
            }

            //データベースに接続
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }
    
            try (Connection con = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
            PreparedStatement ps = con.prepareStatement(sql)) {
    
                if(address != null){
                    address = user_bean.getAddress();
                    ps.setString(1, address);
                    session.setAttribute("address",user_bean.getAddress());

                }else if(job != null){
                    job = user_bean.getJob();
                    ps.setString(1, job);
                    session.setAttribute("job",job);

                }
                
                int res = ps.executeUpdate();

                if(res != 0){
                    
                }
    
        
            }catch (SQLException e) {
                e.printStackTrace();          
            }

            
        
    }
    
}
