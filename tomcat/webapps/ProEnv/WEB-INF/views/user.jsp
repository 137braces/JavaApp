<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
        <style>body {padding: 30px;}</style>
    </head>
    <body>
        <ul id="nav">
        <li><a href="#">MENU1</a></li>
        <li><a href="#">MENU2</a></li>
        <li><a href="#">MENU3</a></li>
        <li><a href="#">プロフィールを編集</a></li>
        </ul>
        
        <div id="app">
            <div @click="toggle">クリック</div>
            <div v-show="show">コンテンツ</div>
        </div>
      
        <!-- リクエストスコープからログインユーザーのIDを取得する -->
        <%String name = (String)request.getAttribute("name"); %>
        <%String gender = (String)request.getAttribute("gender"); %>
        <%int age = (int)request.getAttribute("age"); %>
        <!-- メッセージを表示する -->
        
        <h2><%=name %></h2>
        <h2><%=gender %></h2>
        <h2><%=age %>歳</h2>
       

        
          
    </body>
</html>

<script>
  const app = Vue.createApp({
    data() {
        return {
            // デフォルトはfalseにして非表示
            show: false
        }
    },
    methods: {
        //クリックしたら表示/非表示する
        toggle: function () {
            this.show = !this.show;
        },
    }
});
app.mount("#app");

  </script>

<style>
    #nav {
  list-style: none;
  overflow: hidden;
}
 
#nav li {
  width: 200px;
  text-align: center;
  background-color: #333;
  float: left;
  height: 50px;
  line-height: 50px;
  margin-right: 2px;
}
 
#nav li a {
  text-decoration: none;
  color: #fff;
  font-weight: bold;
  padding: 20px;
}
</style>

