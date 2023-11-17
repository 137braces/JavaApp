<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/user.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>


    <body>

      <!-- リクエストスコープからログインユーザーのIDを取得する -->
      <%String name = (String)session.getAttribute("name");%>
      <%int age = (int)session.getAttribute("age");%>
      <%String image = (String)session.getAttribute("image");%>
      <%String gender = (String)session.getAttribute("gender");%>
      <%String address = (String)session.getAttribute("address");%>
      <%String job = (String)session.getAttribute("job");%>

      

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
        <img style="border-radius:50%; width:150px; height:150px; border: solid 1px #6b6767;" 
        src= "<%=request.getContextPath() %><%= image %>">
      </div>

      <p style="text-align: center;"><span class="user-info"><%= name %></span></p>
      
      <div class="profile_eria">
        <h4>ABOUT</h4>
        <p>年齢 : <span class="user-info"><%= age %>歳</span></p>
        <p>居住地 : <span class="user-info"><%= address %></span></p>
        <p>職業 : <span class="user-info"><%= job %></span></p>
      </div>
      
      <div class="edit_button">
        <a href="user_edit" class="btn btn--orange btn--radius">プロフィールを編集する</a>
      </div>
    </body>
</html>
<style>
  .btn--orange,
a.btn--orange {
  color: #fff;
  background-color: #77edb0;
  
  padding-top:20px;
  padding-bottom:20px;
  padding-left:50px;
  padding-right:50px;
}
.btn--orange:hover,
a.btn--orange:hover {
  color: #fff;
  background: #77edb0;
}

a.btn--radius {
   border-radius: 100vh;
   
}

.container{
  margin-top:110px;
  display: flex;
  justify-content: center;
}

.profile_eria{
  text-align: center;
  margin-bottom: 30px;
}

.edit_button{
  text-align: center;
}

</style>

<script>

</script>



