import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Search extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //利用ユーザーが男性の場合、女性ユーザーを全検索。
        String sql = "SELECT * FROM users where gender = ?";
        HttpSession session = request.getSession();
        String filter_gender = (String)session.getAttribute("gender");
        String man = "";

        if(filter_gender.equals("男性")){
            man = "女性";
        }else if(filter_gender.equals("女性")){
            man = "男性";
        }


        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement ps = connection.prepareStatement(sql)){
            ps.setString(1, man);
             
             
             ResultSet results = ps.executeQuery();

            ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

            while (results.next()) {
                HashMap<String, String> columns = new HashMap<String, String>();

                //ユーザーアイコン
                String image = results.getString("image");
                columns.put("image", image);
                
                //ユーザー名
                String name = results.getString("name");
                columns.put("name", name);

                
                String age = results.getString("age");
                columns.put("age", age);

                String id = results.getString("id");
                columns.put("id", id);

                rows.add(columns);
            }


            request.setAttribute("rows", rows);
        
        

        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }

        String view = "/WEB-INF/views/search.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
