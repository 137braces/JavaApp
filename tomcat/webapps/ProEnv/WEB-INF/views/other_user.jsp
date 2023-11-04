<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/other_user.css">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>
    <body>
        <!-- セッションスコープからログインユーザーのIDを取得する -->
        <%String user_name = (String)session.getAttribute("name");%>

        <!-- リクエストスコープから受け取ったidを基に他ユーザーの詳細情報を取得する -->
        <%String age = (String)request.getAttribute("age");%>
        <%String other_user_name = (String)request.getAttribute("name");%>
        
  
        <header id="header">
            <h3 class="logo"><a href="#">Java Portfolio</a></h3>
            <nav>
              <ul class="nav__list">
                <li class="nav__item"><a href="#"><%= user_name %></a></li>
                <li class="nav__item"><a href="#">さがす</a></li>
                <li class="nav__item"><a href="#">ログアウト</a></li>
              </ul>
            </nav>
        </header>
      <div class="other_profile">
      
      <%= age %>
      <%= other_user_name %>
        
        
      </div>

    </body>
</html>

<style>
  .other_profile {
    padding-top:100px;
  }
</style>