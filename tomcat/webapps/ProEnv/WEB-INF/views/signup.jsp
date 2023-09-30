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
        
      <div id = "app">
        <form method="post" action="user">
            <h1>新規登録</h1>
            <input type="text" name="email" placeholder="Email"/>
            <input type="password" name="password" id="pass" placeholder="Password"/>
            
            <label class="selectbox-002">
                <select name="gender"> 
                    <option value="" selected>性別を選択してください</option>
                    <option>男性</option>
                    <option>女性</option>
                </select>
            </label>
        
            
                <select name ="address" style="margin-top:20px; padding-left:50px; padding-right:50px;padding-top:10px;padding-bottom:10px; font-size:15px;">
                    <option value="" selected>都道府県</option>
                    <option value="1">北海道</option>
                    <option value="2">青森県</option>
                    <option value="3">岩手県</option>
                    <option value="4">宮城県</option>
                    <option value="5">秋田県</option>
                    <option value="6">山形県</option>
                    <option value="7">福島県</option>
                    <option value="8">茨城県</option>
                    <option value="9">栃木県</option>
                    <option value="10">群馬県</option>
                    <option value="11">埼玉県</option>
                    <option value="12">千葉県</option>
                    <option value="13">東京都</option>
                    <option value="14">神奈川県</option>
                    <option value="15">新潟県</option>
                    <option value="16">富山県</option>
                    <option value="17">石川県</option>
                    <option value="18">福井県</option>
                    <option value="19">山梨県</option>
                    <option value="20">長野県</option>
                    <option value="21">岐阜県</option>
                    <option value="22">静岡県</option>
                    <option value="23">愛知県</option>
                    <option value="24">三重県</option>
                    <option value="25">滋賀県</option>
                    <option value="26">京都府</option>
                    <option value="27">大阪府</option>
                    <option value="28">兵庫県</option>
                    <option value="29">奈良県</option>
                    <option value="30">和歌山県</option>
                    <option value="31">鳥取県</option>
                    <option value="32">島根県</option>
                    <option value="33">岡山県</option>
                    <option value="34">広島県</option>
                    <option value="35">山口県</option>
                    <option value="36">徳島県</option>
                    <option value="37">香川県</option>
                    <option value="38">愛媛県</option>
                    <option value="39">高知県</option>
                    <option value="40">福岡県</option>
                    <option value="41">佐賀県</option>
                    <option value="42">長崎県</option>
                    <option value="43">熊本県</option>
                    <option value="44">大分県</option>
                    <option value="45">宮崎県</option>
                    <option value="46">鹿児島県</option>
                    <option value="47">沖縄県</option>
                </select>
                	
            <input type="date" name="calendar" max="9999-12-31">

            
            
            <button type="submit">サインアップ</button>
        </form>

        <form method="get" action="login">
            <input type="submit" value="ログインはこちらから">
        </form>
      </div>
  

    </body>
</html>



<script src="https://unpkg.com/vue@2.6.14/dist/vue.min.js"></script>

<script>

function passLengthCheck (){
    const password = document.getElementById("pass");
    let count = password.value.length;
    let messege1 = "";
    
    if(count < 8) {
        message1 += "パスワードが短すぎます。8文字で入力して下さい。"
        document.getElementById("target").textContent = message1;
    }

}

</script>

<script>
  new Vue({
    el:"#app",
    data : {
        
    },
    methods : {
        passwordVisibility: function() {
        this.isChecked = !this.isChecked;
    }
  })
</script>


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

body {
  font:15px/1.25 'Alef';
  color:@text;
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




.selectbox-002 {
    position: relative;
}

.selectbox-002::before,
.selectbox-002::after {
    position: absolute;
    content: '';
    pointer-events: none;
}

.selectbox-002::before {
    right: 0;
    display: inline-block;
    width: 2.8em;
    height: 2.8em;
    border-radius: 0 3px 3px 0;
    background-color: #1676d0;
    content: '';
}

.selectbox-002::after {
    position: absolute;
    top: 50%;
    right: 1.4em;
    transform: translate(50%, -50%) rotate(45deg);
    width: 6px;
    height: 6px;
    border-bottom: 3px solid #fff;
    border-right: 3px solid #fff;
    content: '';
}

.selectbox-002 select {
    appearance: none;
    -webkit-appearance: none;
    -moz-appearance: none;
    min-width: 230px;
    height: 2.8em;
    padding: .4em 3.6em .4em .8em;
    border: 2px solid #1676d0;
    border-radius: 3px;
    color: #333333;
    font-size: 1em;
    cursor: pointer;
}

.selectbox-002 select:focus {
    outline: 1px solid #1676d0;
}






</style>    
          
    </body>
</html>