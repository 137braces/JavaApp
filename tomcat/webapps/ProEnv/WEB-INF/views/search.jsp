<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/search.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>
    <body>
        <!-- リクエストスコープからログインユーザーのIDを取得する -->
        <%String name = (String)session.getAttribute("name");%>

        <!-- エラーメッセージを取得 -->
        <%String message = (String)request.getAttribute("message");%>
       

        <header id="header">
            <h3 class="logo"><a href="#">Java Portfolio</a></h3>
            <nav>
              <ul class="nav__list">
                <li class="nav__item"><a href="user"><%= name %></a></li>
              
                <li class="nav__item"><a href="">さがす</a></li>
                
               
                <li class="nav__item"><a href="#">ログアウト</a></li>
              </ul>
            </nav>
          </header>
    
        
          <div class="arraylist">
           
            <div>
              <% ArrayList<HashMap<String,String>> rows = (ArrayList<HashMap<String,String>>)request.getAttribute("rows");%>

                <%for (HashMap<String,String> columns : rows) { %>
                
                      <img style="border-radius:50%; width: 150px; height: 150px; border: solid 1px #6b6767;" 
                      src= "<%=request.getContextPath() %><%= columns.get("image") %>">

                      <p><a href="other_user?id=<%= columns.get("id") %>"><%= columns.get("name") %></a></p>
                      <p><%= columns.get("age") %>歳</p>
                
                <% } %>
            </div>            
          </div>          
    </body>
</html>

<style>
.arraylist {
  padding-top:100px;
  display: flex;
  flex-direction: row;

}
</style>