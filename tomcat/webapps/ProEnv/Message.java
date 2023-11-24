import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;

public class Message extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        //ユーザーidを取得(メッセージルームを取得するためのキーになる)
        HttpSession session = request.getSession(false);
        String id = (String)session.getAttribute("id");


        //データベースへの接続情報
        final String SqlUrl = "jdbc:mysql://localhost/mydb";
        final String SqlRoot = "root";
        final String SqlPass = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            
            e.printStackTrace();
        }

        
        //SQL
        String sql = "SELECT * FROM users where id = ?";


        try (Connection connection = DriverManager.getConnection(SqlUrl, SqlRoot, SqlPass);
             PreparedStatement ps = connection.prepareStatement(sql)){
            
             ps.setString(1, id);
            
             
             ResultSet res = ps.executeQuery();


             if (res.next()) {
                //ユーザーID
                String other_id = res.getString("id");

                //ユーザーアイコン
                String image = res.getString("image");
                                
                //ユーザー名
                String name = res.getString("name");
                
                //ユーザーの年齢
                String age = res.getString("age");

                //ユーザーの住所
                String address = res.getString("address");

                //ユーザーの職業
                String job = res.getString("job");

                
                request.setAttribute("id", other_id);
                request.setAttribute("image",image);
                request.setAttribute("name",name);
                request.setAttribute("age",age);
                request.setAttribute("address",address);
                request.setAttribute("job", job);

                String view = "/WEB-INF/views/other_user.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            } 

        } catch (Exception e) {
            //request.setAttribute("message", "Exception:" + e.getMessage());
        }

    }

}
