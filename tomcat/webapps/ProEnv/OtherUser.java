import java.util.*;

import javax.sql.rowset.serial.SerialException;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;

public class OtherUser extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }

        //ユーザーid
        String id = request.getParameter("id");
    
        //ユーザーidを検索
        String sql = "SELECT * FROM users where id = ?";


        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement ps = connection.prepareStatement(sql)){
            
             ps.setString(1, id);
            
             
             ResultSet res = ps.executeQuery();


            if (res.next()) {

                //ユーザーアイコン
                String image = res.getString("image");
                                
                //ユーザー名
                String name = res.getString("name");
                
                //ユーザーの年齢
                String age = res.getString("age");

                request.setAttribute("image",image);
                request.setAttribute("name",name);
                request.setAttribute("age",age);
            } 

        } catch (Exception e) {
            //request.setAttribute("message", "Exception:" + e.getMessage());
        }

        String view = "/WEB-INF/views/other_user.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
