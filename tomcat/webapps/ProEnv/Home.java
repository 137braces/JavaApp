import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class Home extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("message", "Hello World!");

        String url = "jdbc:mysql://localhost/mydb";
        String root = "root";
        String password = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement statment = connection.prepareStatement("SELECT * FROM users");
             ResultSet results = statment.executeQuery()) {

            ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

            while (results.next()) {
                HashMap<String, String> columns = new HashMap<String, String>();

                String id = results.getString("id");
                columns.put("id", id);

                String name = results.getString("name");
                columns.put("name", name);

                String gender = results.getString("gender");
                columns.put("gender", gender);

                rows.add(columns);
            }

            request.setAttribute("rows", rows);

        } catch (Exception e) {
            request.setAttribute("message", "Exception:" + e.getMessage());
        }

        String view = "/WEB-INF/views/index.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}