import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.searchbean.SearchBean;
import pakage.userbean.UserBean;

import java.sql.*;

public class SearchResult extends HttpServlet {
    
    public SearchResult(){
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
       

        //年齢(age)検索の部分
        //①age1とage2の年齢数値が逆転しても通常のbetween検索ができるの処理
        SearchBean search_method = new SearchBean();
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
