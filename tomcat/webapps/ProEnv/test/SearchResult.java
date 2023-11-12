package test;

import java.util.*;

import java.sql.*;

public class SearchResult{
    
    public static void main(String[] args){

        //SQLの接続情報
        final String url = "jdbc:mysql://localhost/mydb";
        final String root = "root";
        final String psword = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //インスタンス化
        SearchMethod search_method = new SearchMethod();

        String gender = "男性";
        //String _gender = "女性";

        //性別検索
        search_method.filter_gender(gender);
        String man = search_method.getMan();
            System.out.println(man);

        int age1 = Integer.parseInt("18");
        int age2 = Integer.parseInt("27");


        //年齢の範囲検索
        search_method.ifAge(age1,age2);
        final String sql = search_method.getAlterSql();
            System.out.println(sql);

        try (Connection con = DriverManager.getConnection(url, root, psword);
        PreparedStatement ps = con.prepareStatement(sql)) {
        
            ps.setString(1,man);
            
            
            ResultSet res = ps.executeQuery();
                System.out.println(res);

            ArrayList<HashMap<String, String>> rows = new ArrayList<HashMap<String, String>>();

            while (res.next()) {
                HashMap<String, String> columns = new HashMap<String, String>();
                
                //ユーザー名
                String other_name = res.getString("name");
                columns.put("name", other_name);

                
                String age = res.getString("age");
                columns.put("age", age);

                String id = res.getString("id");
                columns.put("id", id);

                rows.add(columns);
            }
        

        for(HashMap<String,String> columns : rows) {
            System.out.println(columns.get("id"));
            System.out.println(columns.get("name"));
            System.out.println(columns.get("age")+"\n");
        }
        
            
        }catch (SQLException e) {
            e.printStackTrace();
        } 
        
    }

}
