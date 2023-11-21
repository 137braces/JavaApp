<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<script src="https://cdn.jsdelivr.net/npm/vue@2.*/dist/vue.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/setting.css">
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css" rel="stylesheet">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>


    <body>
        <%String error_message = (String)request.getAttribute("error_message");%>
        
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

      <h1 style="margin-top:120px;">各種設定</h1>
      
        <a href="">
            <i class="fa-solid fa-heart" style="color: #df5da2;"><span style="color:black"> いいね！履歴</span></i>
        </a>

        <div id="alter_password" style="margin-top:20px;"> 
            <i @click="isShow = !isShow" class="fa-solid fa-shield-halved" style="color: #2464e5;"><span style="color:black"> パスワード変更</span></i>
            <div v-show="isShow">
                <form method="post" action="alter_password" onsubmit="return checkForm()">
                    <p>現在のパスワード</p>
                    <input type="password" name="password" id="password" placeholder=""/>

                    <p>新しいパスワード(半角英数・大文字・小文字・記号・8〜100文字)</p>
                    <input type="password" name="alter_password1" id="alter_password1" placeholder=""/>

                    <p>新しいパスワードの再入力</p>
                    <input type="password" name="alter_password2" id="alter_password2" placeholder="確認のため、もう一度入力してください。"/>

                    <button type="submit">パスワード変更</button>
                </form>
            </div>
        </div>
        <% if(error_message != null){ %>
            <%=error_message %>
        <% } %>
        
      
    </body>
</html>
<script>
//Vue.js側の処理
    new Vue({
        el: '#alter_password',
        data() {
            return {
                isShow: false,
            }
        },
    })


function checkForm() {

    const password = document.getElementById("password");
    const alter_password1 = document.getElementById("alter_password2");
    const alter_password2 = document.getElementById("alter_password2");

    if(password.value === "" || alter_password1.value === "" || alter_password2.value === ""){
        alert("必須項目が記入されていません。");
        return false;
    }

}



</script>

<style>
i{
  cursor:pointer
}
</style>
  



