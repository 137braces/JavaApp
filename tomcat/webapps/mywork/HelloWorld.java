import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class HelloWorld extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><head>paiza</head><body>");
            out.println("<p>Hello World!</p>");
            out.println("</body></html>");

            String url = "jdbc:mysql://localhost/mydb";
            String user = "root";
            String password = "apple0713";

            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement statment = connection.prepareStatement("SELECT * FROM players");
                ResultSet results = statment.executeQuery()) {
                out.println("<p>接続成功！</p>");

            } catch (Exception e) {
                out.println("Exception" + e.getMessage());
            }
    }
}