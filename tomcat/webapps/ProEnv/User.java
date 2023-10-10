import java.util.*;

import javax.sql.rowset.serial.SerialException;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

public class User extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
        rd.forward(request, response);
        

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();


        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String hashed = BCrypt.hashpw(passw, BCrypt.gensalt());
       
        //request.setAttribute("email",res.getString("email"));
        
        
        
        //ログイン後、遷移先ページのパス
        String path = "";
        

        //emailとパスワードが一致した場合、select文で該当のユーザーを格納
        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost/mydb";
        String root = "root";
        String psword = "";
       
        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setString(1,email);
            ps.setString(2, password);
            
            

            ResultSet res = ps.executeQuery();
            

            if(res.next()){
                String name = res.getString("name");
                String gender = res.getString("gender");
                int age = res.getInt("age");
                request.setAttribute("name",name);
                request.setAttribute("gender",gender);
                request.setAttribute("age",age);
               
                path = "/WEB-INF/views/user.jsp";
                RequestDispatcher rd = request.getRequestDispatcher(path);
                rd.forward(request, response);
            } else{

            }
            
            

            
        }catch (SQLException e) {
            e.printStackTrace();
        }       
          
            
           
                    
    }

}