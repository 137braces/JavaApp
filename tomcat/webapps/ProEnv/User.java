import java.util.*;

import javax.sql.rowset.serial.SerialException;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;



public class User extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
        rd.forward(request, response);
        

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        //ハッシュ化したパスワードを入れる変数
        String hash = "";

        
        //パスワードをハッシュ化
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            byte[] hashBytes = md.digest();
            hash = Base64.getEncoder().encodeToString(hashBytes);
            System.out.println("Hashed Password: " + hash);
            } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            }

        
        //ログイン後、遷移先ページのパス
        String path = "";
        

        //emailとパスワードが一致した場合、select文で該当のユーザーを格納
        String sql = "SELECT * FROM users WHERE email=? AND password=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String psword = "";
       
        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setString(1,email);
            ps.setString(2, hash);
            
            ResultSet res = ps.executeQuery();

            
            
            if(res.next()){
                String name = res.getString("name");
                String image = res.getString("image");
                String gender = res.getString("gender");
                int age = res.getInt("age");
                String address = res.getString(("address"));
                String job = res.getString(("job"));
                String id = res.getString("id");

                HttpSession session = request.getSession();
                session.setAttribute("id", id);
                session.setAttribute("name", name);
                session.setAttribute("age",age);
                session.setAttribute("image",image);
                session.setAttribute("gender",gender);
                session.setAttribute("address",address);
                session.setAttribute("job",job);
               
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