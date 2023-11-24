<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/other_user.css">
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
     <!-- セッションスコープからログインユーザーのIDを取得する -->
     <%String user_name = (String)session.getAttribute("name");%>

     <!-- リクエストスコープから受け取ったidを基に他ユーザーの詳細情報を取得する -->
     <%String id = (String)request.getAttribute("id"); %>
     <%String age = (String)request.getAttribute("age");%>
     <%String other_user_name = (String)request.getAttribute("name");%>
     <%String image = (String)request.getAttribute("image");%>
     <%String address = (String)request.getAttribute("address");%>
     <%String job = (String)request.getAttribute("job");%>
        
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
    
          <p style="text-align: center;"><span class="user-info"><%= other_user_name %></span></p>
          
          <div class="profile_eria">
            <h4>ABOUT</h4>
            <p>年齢 : <span class="user-info"><%= age %>歳</span></p>
            <p>居住地 : <span class="user-info"><%= address %></span></p>
            <p>職業 : <span class="user-info"><%= job %></span></p>
          </div>
          
          
          <form id="follow_button">
            <a type="submit" name="followee_id" value="<%=id %>" v-if="isActive" v-on:click="active" class="btn btn--orange btn--radius followYet"><i class="fa-solid fa-heart"></i>いいね！</a>
            <a v-else class="btn btn--orange btn--radius followDone"><i class="fa-solid fa-heart"></i>いいね！</a>
          </form>
       

    </body>
</html>

<script>
  //いいね！機能
  
  const follow = new Vue ({
    el:'#follow_button',
    data:{
      isActive:true
    },
    
    methods:{
      active: function(){
        this.isActive = !this.isActive,
        axios
        .post('other_user',{followee_id:id})
        .then(response => (this.info = response))
        .catch(error => (this.error = error));
      }
  }
})
</script>

<style>
  .followDone{
    background-color: blue;
  }
  .followYet{
    background-color: #df5da2;
  }

  .btn--orange,
  a.btn--orange {
    color: #fff;
    
    padding-top:20px;
    padding-bottom:20px;
    padding-left:50px;
    padding-right:50px;
  }
  /*.btn--orange:hover,
  a.btn--orange:hover {
    color: #fff;
    background: #df5da2;
  }*/

  a.btn--radius {
    border-radius: 100vh;
    
  }

  .buttoncolor {
    background-color: green;
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

#follow_button{
  text-align: center;
}
p{
  color:#282829;
}
</style>