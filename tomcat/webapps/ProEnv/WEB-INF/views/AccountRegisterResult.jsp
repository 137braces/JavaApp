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
        <%String name = (String)request.getAttribute("name"); %>
       
        
        <!-- メッセージを表示する -->
        
        <h2><%=name %></h2>
        
        <p>登録完了</p>
    </body>
</html>