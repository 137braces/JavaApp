<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
        <style>body {padding: 30px;}</style>
    </head>
    <body>

        <%String error_message = (String)request.getAttribute("error_message");%>

        <% if(error_message != null) { %>
          <p style ="color:red;"><%= error_message %></p>
        <% } %>

        <form method="post" action="user">
            <h1>Java App</h1>
            <input type="text" name="email" placeholder="Email"/>
            <input type="password" name="password" placeholder="Password"/>
            <button type="submit">ログイン</button>
        </form>

        <form method="post" action="user">
          <input name="gest" style="cursor: pointer;" type="submit" value="ゲストユーザーでログイン">
        </form>

        <p style="text-align: center; font-size:20px;"><a style="text-decoration:none;" href="signup">新規登録はこちら</a></p>
  

    </body>
</html>


  

<style>
a{
    color: #403e3e;
}

a:hover{
    color: #4287f5;
}

@text: #111;
@base: #f4f4f4;
@link: #2a3644;
@button: #f26964;
@bottom: #ab4b47;

.rounded (@radius: 6px) {
  -webkit-border-radius: @radius;
     -moz-border-radius: @radius;
      -ms-border-radius: @radius;
       -o-border-radius: @radius;
          border-radius: @radius;
}

.trans (@transition: .1s) {
  -webkit-transition: all @transition ease-in-out;
     -moz-transition: all @transition ease-in-out;
          transition: all @transition ease-in-out;
 
}

* {
  margin:0;
  padding:0;
  border:none;
  list-style:none;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
}

form {
  margin:20px auto;
  background:#2a2b2b;
  width:347px;
  text-align:center;
  padding:40px;
  .rounded;
}

form > h1 {
  color:white;
  text-shadow:1px 1px 0px rgba(0, 0, 0, 0.7);
  font-weight:400;
  margin-bottom:20px;
}

input {
  background:rgba(0, 0, 0, 0.2);
  color:#fff;
  text-shadow:1px 1px 0px rgba(0, 0, 0,0.3);
  display:block;
  width:269px;
  padding:15px;
  margin-bottom:10px;
  .rounded;
  .trans;
  outline:none;
}

input:focus {
  background:rgba(0, 0, 0, 0.1);
  .trans;
}

::-webkit-input-placeholder {
   color: rgba(225, 225, 225, 0.4);
}

:-moz-placeholder {
   color: rgba(225, 225, 225, 0.4); 
}

::-moz-placeholder {
   color: rgba(225, 225, 225, 0.4);
}

:-ms-input-placeholder {  
   color: rgba(225, 225, 225, 0.4);
}

button {
  position:relative;
  display:block;
  margin-top:15px;
  margin-bottom:15px;
  padding:17px;
  width:270px;
  .rounded;
  .trans;
  font-size:1.2em;
  background:@button;
  color:@base;
  box-shadow:0px 3px 0px @bottom;
  cursor:pointer;
}

button:active {
  top:3px;
  box-shadow:none;
}
</style>