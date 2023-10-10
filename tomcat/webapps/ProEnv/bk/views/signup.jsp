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
        <form method="post" action="signup2">
            <h1>新規登録</h1>

            <input type="text" name="name" placeholder="ニックネーム">
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
                    <option value="北海道">北海道</option>
                    <option value="青森県">青森県</option>
                    <option value="岩手県">岩手県</option>
                    <option value="宮城県">宮城県</option>
                    <option value="秋田県">秋田県</option>
                    <option value="山形県">山形県</option>
                    <option value="福島県">福島県</option>
                    <option value="茨城県">茨城県</option>
                    <option value="栃木県">栃木県</option>
                    <option value="群馬県">群馬県</option>
                    <option value="埼玉県">埼玉県</option>
                    <option value="千葉県">千葉県</option>
                    <option value="東京都">東京都</option>
                    <option value="神奈川県">神奈川県</option>
                    <option value="新潟県">新潟県</option>
                    <option value="富山県">富山県</option>
                    <option value="石川県">石川県</option>
                    <option value="福井県">福井県</option>
                    <option value="山梨県">山梨県</option>
                    <option value="長野県">長野県</option>
                    <option value="岐阜県">岐阜県</option>
                    <option value="静岡県">静岡県</option>
                    <option value="愛知県">愛知県</option>
                    <option value="三重県">三重県</option>
                    <option value="滋賀県">滋賀県</option>
                    <option value="京都府">京都府</option>
                    <option value="京都府">京都府</option>
                    <option value="兵庫県">兵庫県</option>
                    <option value="奈良県">奈良県</option>
                    <option value="和歌山県">和歌山県</option>
                    <option value="鳥取県">鳥取県</option>
                    <option value="島根県">島根県</option>
                    <option value="岡山県">岡山県</option>
                    <option value="広島県">広島県</option>
                    <option value="山口県">山口県</option>
                    <option value="徳島県">徳島県</option>
                    <option value="香川県">香川県</option>
                    <option value="愛媛県">愛媛県</option>
                    <option value="高知県">高知県</option>
                    <option value="福岡県">福岡県</option>
                    <option value="佐賀県">佐賀県</option>
                    <option value="長崎県">長崎県</option>
                    <option value="熊本県">熊本県</option>
                    <option value="大分県">大分県</option>
                    <option value="宮崎県">宮崎県</option>
                    <option value="鹿児島県">鹿児島県</option>
                    <option value="沖縄県">沖縄県</option>
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