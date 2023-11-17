<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/user_edit.css">


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>


    <body>

      <!-- リクエストスコープからログインユーザーのIDを取得する -->
      <%String name = (String)session.getAttribute("name");%>
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
      
      <div class="user_edit">
        <form>
            <input type="text" name="name" size="" value="<%= name %>" id="user_name">
            <br>
            <br>
            <select name="address" id="user_address">
                <option value="">未設定</option>
                <option value="大阪">大阪</option>
                <option value="兵庫">兵庫</option>
                <option value="京都">京都</option>
                <option value="奈良">奈良</option>
                <option value="和歌山">和歌山</option>
            </select>
        
        <br>
        <br>
        <select name="job" id="user_job">
            <option value="">未設定</option>
            <option value="エンジニア">エンジニア</option>
            <option value="薬剤師">薬剤師</option>
            <option value="研究職">美容師</option>
            <option value="医師">医師</option>
            <option value="デザイナー">デザイナー</option>
        </select>
    </form>
      </div>

    </body>
</html>

<script>

$('#user_name').on('change', function(){
    let user_name = $('#user_name').val();

    $.ajax({
        type:'POST',
        url: 'user_edit',
        async : true,
        data: {name:user_name}
        }).done(function () {
          alert(user_name + "成功しました");
        }).fail(function () {
          alert("読み込み失敗");
    });

}); 


$('#user_address').on('change', function(){
    let user_address = $('#user_address').val();

    $.ajax({
        type:'POST',
        url: 'user_edit',
        async : true,
        data: {address:user_address}
        }).done(function () {
          alert(user_address + "成功しました");
        }).fail(function () {
          alert("読み込み失敗");
    });

}); 

$('#user_job').on('change', function(){
    let user_job = $('#user_job').val();

    $.ajax({
        type:'POST',
        url: 'user_edit',
        async : true,
        data: {job:user_job}
        }).done(function () {
          alert(user_job + "成功しました");
        }).fail(function () {
          alert("読み込み失敗");
    });

});     

</script>



