<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
        <style>body {padding: 30px;}</style>
    </head>
    <body>
        <!-- リクエストスコープからログインユーザーのIDを取得する -->
        <%String email = (String)request.getAttribute("email"); %>
        <%String gender = (String)request.getAttribute("gender"); %>
        <!-- メッセージを表示する -->
        <h1>ログイン成功！！</h1>
        <h2>こんにちは！<%=email %>さん</h2>
        <h2>こんにちは！<%=gender %>さん</h2>
          
    </body>
</html>

