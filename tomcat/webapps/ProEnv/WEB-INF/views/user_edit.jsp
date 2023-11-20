<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/user_edit.css">
<link href="https://use.fontawesome.com/releases/v6.2.0/css/all.css" rel="stylesheet">
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.3.1.min.js"></script>

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

      <div style="margin-top:120px;" class="box_con">

        <form>
            <table class="formTable">
            <h1 style="margin-bottom: 10px;">基本情報</h1>
              <tr>
                <tr>
                  <th>ニックネーム</th>
                  <td>
                    <div class="box">
                      <%= name %>
                      <i style="padding-top: 3px;" class="fa-solid fa-pen-to-square"></i>
                    </div>
                  </td>
                </tr>
                <th>居住地</th>
                <td>
                  <select name="address" id="user_address">
                    <option value="">未設定</option>
                    <option value="大阪">大阪</option>
                    <option value="兵庫">兵庫</option>
                    <option value="京都">京都</option>
                    <option value="奈良">奈良</option>
                    <option value="和歌山">和歌山</option>
                
                  </select>
                </td>
              </tr>
              <tr>
                <th>職業</th>
                  <td>
                    <select name="job" id="user_job">
                      <option value="">未設定</option>
                      <option value="エンジニア">エンジニア</option>
                      <option value="薬剤師">薬剤師</option>
                      <option value="研究職">美容師</option>
                      <option value="医師">医師</option>
                      <option value="デザイナー">デザイナー</option>
                  </select>
                  </td>
              </tr>
              
              </table>
          </form>
        </div>
    </body>
</html>

<script>

  $('#user_address').on('change', function(){
    let user_address = $('#user_address').val();

    $.ajax({
        type:'POST',
        url: 'user_edit',
        async : true,
        data: {address:user_address}
        }).done(function () {
          alert(user_address + "成功しました");
        }).fail(function (jqXHR, textStatus, errorThrown) {
          console.log("jqXHR          : " + jqXHR.status); // HTTPステータスが取得
          console.log("textStatus     : " + textStatus);    // タイムアウト、パースエラー
          console.log("errorThrown    : " + errorThrown.message); // 例外情報
          alert(user_address+"読み込み失敗");
    });

}); 

$('#user_job').on('change', function(){
    let user_job = $('#user_job').val();

    $.ajax({
        type:'POST',
        url: 'user_edit',
        async : true,
        data: {job:user_job},
        }).done(function () {
          alert(user_job + "成功しました");
        }).fail(function () {
          alert("読み込み失敗");
    });

});

</script>


<style>
.box {
  border: 2px solid #aaa;
  padding: 5px;
  color:#4e4f52;
  display: flex;
  justify-content: space-between;
}

html {
  overflow-y: scroll;
}
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,textarea,p,blockquote,th,td {
  margin: 0;
  padding: 0;
}
address,caption,cite,code,dfn,em,strong,th,var {
  font-style: normal;
}
table {
  border-collapse: collapse;
  border-spacing: 0;
}
caption,th {
  text-align: left;
}
q:before,q:after {
  content: '';
}
object,embed {
  vertical-align: top;
}
hr,legend {
  display: none;
}
h1{
  color:#2b2b2a;
  font-size: 30px;
}
img,abbr,acronym,fieldset {
  border: 0;
}
li {
  list-style-type: none;
}
sup {
  vertical-align: super;
  font-size: 0.5em;
}
img {
  vertical-align: top;
}
i {
  font-style: normal;
}
/*----リセットcss*----/

/*デザインcss↓*/
.box_con {
  max-width: 600px;
  margin: 0  auto;
}
@media only screen and (max-width: 768px) {
  .box_con {
    width: 95%;
  }
}
.box_con form {
  width: 100%;
}
.box_con form table {
  width: 100%;
}
.box_con form table tr {
  position: relative;
}
.box_con form table tr:after {
  content: "";
  position: absolute;
  width: 100%;
  left: 0;
  bottom: 0;
  height: 1px;
  border-bottom: dotted #cdcdcd 1px;
}
.box_con form table tr th {
  width: 30%;
  font-weight: normal;
  padding: 1em .5em;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
@media only screen and (max-width: 768px) {
  .box_con form table tr th {
    text-align: center;
    width: 100%;
    display: block;
    background: #97ae88;
    padding: .8em .2em;
    color: #fff;
  }
}
.box_con form table tr th span {
  background: #cd6f55;
  padding: 0 .3em;
  color: #fff;
  margin-left: .5em;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.box_con form table tr td {
  padding: 1em .5em;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
@media only screen and (max-width: 768px) {
  .box_con form table tr td {
    padding: 1.5em .5em;
    display: block;
    width: 100%;
  }
}
.box_con form table tr .box_br {
  display: block;
}
.box_con form table tr select {
  border: 1px solid #97ae88;
}
.box_con form table tr label input {
  cursor: pointer;
  display: none;
  vertical-align: middle;
}
.box_con form table tr .radio02-input + label {
  padding-left: 23px;
  margin-right: 20px;
  position: relative;
}
.box_con form table tr .radio02-input + label:before {
  content: "";
  display: block;
  position: absolute;
  top: 50%;
  left: 0;
  width: 16px;
  height: 16px;
  border: 1px solid #999;
  border-radius: 50%;
  -moz-transform: translateY(-50%);
  -ms-transform: translateY(-50%);
  -webkit-transform: translateY(-50%);
  transform: translateY(-50%);
}
.box_con form table tr .radio02-input:checked + label:after {
  content: "";
  display: block;
  position: absolute;
  top: 50%;
  left: 3px;
  width: 12px;
  height: 12px;
  background: #97ae88;
  border-radius: 50%;
  -moz-transform: translateY(-50%);
  -ms-transform: translateY(-50%);
  -webkit-transform: translateY(-50%);
  transform: translateY(-50%);
}
.box_con form table tr select, .box_con form table tr input, .box_con form table tr textarea {
  width: 100%;
  height: 3em;
  padding: .5em;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
}
.box_con form table tr textarea {
  height: 10em;
}

/*プライバシーのデザインcss↓*/
.con_pri {
  max-width: 700px;
  margin: 0  auto;
}
@media only screen and (max-width: 768px) {
  .con_pri {
    width: 95%;
  }
}
.con_pri .box_pri {
  height: 300px;
  overflow-y: scroll;
  border: 1px solid #cdcdcd;
  background: #f7f7f7;
  -moz-box-sizing: border-box;
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  margin-top: 20px;
  padding: 20px 55px;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri {
    margin-top: 4%;
    padding: 3%;
  }
}
@media only screen and (min-width: 769px) and (max-width: 1024px) {
  .con_pri .box_pri {
    padding: 4%;
  }
}
.con_pri .box_pri .box_tori {
  text-align: left;
  margin-top: 40px;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri .box_tori {
    margin-top: 4%;
  }
}
.con_pri .box_pri .box_tori h4 {
  font-weight: normal;
  margin-bottom: 30px;
  font-size: 150%;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri .box_tori h4 {
    margin-bottom: 4%;
  }
}
.con_pri .box_pri .box_tori .txt {
  padding: 0 20px;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri .box_tori .txt {
    padding: 0;
  }
}
.con_pri .box_pri .box_num {
  margin-top: 30px;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri .box_num {
    margin-top: 5%;
  }
}
.con_pri .box_pri .box_num h4 {
  font-weight: normal;
  font-size: 113%;
}
.con_pri .box_pri .box_num .txt {
  padding: 10px 0 0 20px;
}
@media only screen and (max-width: 768px) {
  .con_pri .box_pri .box_num .txt {
    padding: 3% 0 0 3%;
  }
}

.box_check {
  text-align: center;
  margin: 1em auto;
}
.box_check label {
  display: inline-block;
}
.box_check label span {
  margin-left: .3em;
}

.btn {
  text-align: center;
}
.btn input {
  display: inline-block;
  background: #eee;
  padding: .5em 4em;
  color: #000;
  text-decoration: none;
  cursor: pointer;
  border: none;
  -moz-transition: all 0.4s;
  -o-transition: all 0.4s;
  -webkit-transition: all 0.4s;
  transition: all 0.4s;
}
.btn input:hover {
  filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=70);
  opacity: 0.7;
}
</style>
