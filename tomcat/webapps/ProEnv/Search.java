import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.searchbean.SearchBean;

import java.sql.*;

public class Search extends HttpServlet {

        //データベース接続情報
        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String password = "";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            System.out.println();

        }catch(NullPointerException n){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            rd.forward(request, response);
        }


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();

        //性別のみの検索に必要な変数。
        String gender = (String)session.getAttribute("gender");
        
        //インスタンス化
        SearchBean searchBean = new SearchBean();

        //利用ユーザーが男性の場合、女性ユーザーを全検索※女性の場合は男性を検索。
        searchBean.ifGender(gender);
        String man = searchBean.getMan();

        final String alterSql = searchBean.getAlterSql();


        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement ps = connection.prepareStatement(alterSql)){
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
            String view = "/WEB-INF/views/login.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }

        String view = "/WEB-INF/views/search.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try{
            System.out.println();

        }catch(NullPointerException n){
            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
            rd.forward(request, response);
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        HttpSession session = request.getSession();

        //性別のみの検索に必要な変数。
        String gender = (String)session.getAttribute("gender");
        
        //インスタンス化
        SearchBean searchBean = new SearchBean();

        //SearchBeanの各メソッドはSQL文を追加していく。
        //利用ユーザーが男性の場合、女性ユーザーを全検索※女性の場合は男性を検索。
        searchBean.ifGender(gender);

        //man変数をSQL文の(?)部分にsetStringする
        String man = searchBean.getMan();

        //リンクからの画面遷移はnullで値を取得
        String age1 = request.getParameter("age1");
        String age2 = request.getParameter("age2");

        if(age1 == null || age2 == null){
            //nullの場合、ifAgeメソッド(年齢範囲の検索)は実行されない。
        }else {
            int intAge1 = Integer.parseInt(request.getParameter("age1"));
            int intAge2 = Integer.parseInt(request.getParameter("age2")); 
             //年齢の範囲検索をするメソッド。初期は全検索に設定。
            searchBean.ifAge(intAge1,intAge2);
        }
        

        //上記ifメソッドで生成したSQL文をalterSql変数に格納。
        String alterSql = searchBean.getAlterSql();



        try (Connection connection = DriverManager.getConnection(url, root, password);
             PreparedStatement ps = connection.prepareStatement(alterSql)){
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
