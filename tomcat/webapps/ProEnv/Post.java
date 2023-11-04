import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Post extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }


//postsテーブルとusersテーブルを結合し、idとuser_idを紐付けた投稿を一覧表示。
        String sql = "select * from posts inner join users on posts.user_id = users.id";

        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement res = connection.prepareStatement(sql);
             
             ResultSet results = res.executeQuery()) {


            ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

//投稿内容が存在していれば、「ユーザー名、ユーザーアイコン、つぶやきのタイトル、つぶやきの内容をHashMapで表示。
            while (results.next()) {
                HashMap<String, String> columns = new HashMap<String, String>();

                String image = results.getString("image");
                columns.put("image", image);

                String name = results.getString("name");
                columns.put("name", name);

                String title = results.getString("title");
                columns.put("title", title);

                String content = results.getString("content");
                columns.put("content", content);

                rows.add(columns);
            }

            request.setAttribute("rows", rows);

        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }

        String view = "/WEB-INF/views/post.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    
        }
    
}
