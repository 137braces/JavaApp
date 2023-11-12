import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;

import java.sql.*;

public class SearchResult extends HttpServlet {
    
    public SearchResult(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String psword = "";

        //全検索(異性)↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
        
        HttpSession session = request.getSession();
        String filter_gender = (String)session.getAttribute("gender");
        String man = "";

        if(filter_gender.equals("男性")){
            man = "女性";
        }else if(filter_gender.equals("女性")){
            man = "男性";
        }
        //ここまで↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

        String name = request.getParameter("name");

        //age1とage2は年齢の範囲検索に利用する
        int age1 = Integer.parseInt(request.getParameter("age1"));
        int age2 = Integer.parseInt(request.getParameter("age2")); 

        String address = request.getParameter("job");

        //年齢(age)検索の部分
        //①age1とage2の年齢数値が逆転しても通常のbetween検索ができるの処理
        SearchMethod search_method = new SearchMethod();
        search_method.ifAge(age1,age2);

        final String alterSql = search_method.getAlterSql();

        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(alterSql)) {
        
            ps.setString(1,man);
            
            
            ResultSet res = ps.executeQuery();

            ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

            while (res.next()) {
                HashMap<String, String> columns = new HashMap<String, String>();

                //ユーザーアイコン
                String image = res.getString("image");
                columns.put("image", image);
                
                //ユーザー名
                String other_name = res.getString("name");
                columns.put("name", other_name);

                
                String age = res.getString("age");
                columns.put("age", age);

                String id = res.getString("id");
                columns.put("id", id);

                rows.add(columns);
            }

            request.setAttribute("rows", rows);
        
        
            
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        String view = "/WEB-INF/views/search_result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);      
    }

}
