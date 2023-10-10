import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;



public class Signup2 extends HttpServlet {

    //入力された生年月日を年齢に変換する関数。
    public static String getAge (String birthday){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            LocalDate localBirdhdate = LocalDate.parse(birthday, formatter);
            LocalDate nowDate = LocalDate.now();
            return Long.toString(ChronoUnit.YEARS.between(localBirdhdate, nowDate));
    }
    

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        PrintWriter out = response.getWriter();
        //名前、Eメール、パスワード、性別、アドレスを取得
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
       
        //生年月日から年齢を取得
        String birthDay = request.getParameter("calendar");
        int age = Integer.parseInt(getAge(birthDay));

        int res = 0;


        String sql = "INSERT INTO users (name, email, password, gender, address, age ) VALUES (?, ?, ?, ?, ?, ?)";
        //データベースに接続
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
        
        ps.setString(1, name);
        ps.setString(2, email);
        ps.setString(3, password);
        ps.setString(4, gender);
        ps.setString(5, address);
        ps.setInt(6, age);
			
        
        res = ps.executeUpdate(sql);        
        
        }catch (SQLException e) {
            e.printStackTrace();          
        }
        
    
    }

}

//INSERT INTO users (name, email, password, gender, address, age ) VALUES ("星野さん", "ho@gmail.com", "mikan0713", "男性", "兵庫県", 29)