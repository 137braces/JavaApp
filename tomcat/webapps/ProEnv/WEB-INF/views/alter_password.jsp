<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/alter_password.css">
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/vue@2.*/dist/vue.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.18.0/axios.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>JavaApp</title>
    </head>
    <body>
        <!-- リクエストスコープから受け取ったidを基に他ユーザーの詳細情報を取得する -->
        <%String success_message = (String)request.getAttribute("success_message");%>
      
        <header id="header">
          <h3 class="logo"><a href="#">Java Portfolio</a></h3>
          <nav>
            <ul class="nav__list">
              <li class="nav__item"><a href="user">プロフィール</a></li>
              <li class="nav__item"><a href="search">さがす</a></li>
              <li class="nav__item"><a href="setting">各種設定</a></li>
              <li class="nav__item"><a href="logout">ログアウト</a></li>
            </ul>
          </nav>
        </header>

        <div class="container">
        <% if(success_message != null){ %>
            <%=success_message %>
        <% } %>
        </div>

    </body>
</html>


<style>
  .container{
    margin-top:130px;
  }

</style>