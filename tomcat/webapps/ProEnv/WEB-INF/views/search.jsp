<!-- ServletからArryaListでデータ渡し -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/search.css">
<script src="https://cdn.jsdelivr.net/npm/vue@2.*/dist/vue.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title>Java - paiza</title>
    </head>
    <body>

        <!-- リクエストスコープからログインユーザーのIDを取得する -->
        <%String name = (String)session.getAttribute("name");%>

        <!-- エラーメッセージを取得 -->
        <%String message = (String)request.getAttribute("message");%>
       

        <header id="header">
            <h3 class="logo"><a href="#">Java Portfolio</a></h3>
            <nav>
              <ul class="nav__list">
                <li class="nav__item"><a href="user"><%= name %></a></li>
              
                <li class="nav__item"><a href="">さがす</a></li>
                
               
                <li class="nav__item"><a href="#">ログアウト</a></li>
              </ul>
            </nav>
          </header>

          <div id="app">
            <button @click="isShow = !isShow">表示切り替え</button>
            <div v-show="isShow">
              <form method="get" action="search_result">
              <label class="selectbox-002">
                <select name="age1">
                    <option value="0">こだわらない</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                    <option value="25">25</option>
                    <option value="26">26</option>
                    <option value="27">27</option>
                    <option value="28">28</option>
                    <option value="29">29</option>
                    <option value="30">30</option>
                </select>
            </label>
        
            <label class="selectbox-002">
              <select name="age2">
                <option value="0">こだわらない</option>
                <option value="18">18</option>
                <option value="19">19</option>
                <option value="20">20</option>
                <option value="21">21</option>
                <option value="22">22</option>
                <option value="23">23</option>
                <option value="24">24</option>
                <option value="25">25</option>
                <option value="26">26</option>
                <option value="27">27</option>
                <option value="28">28</option>
                <option value="29">29</option>
                <option value="30">30</option>
              </select>
          </label>
          <button type="submit">この条件で検索</button>
        </form>
            </div>
          </div>
    
        
          <div class="arraylist">
           
            <div>
              <% ArrayList<HashMap<String,String>> rows = (ArrayList<HashMap<String,String>>)request.getAttribute("rows");%>

                <%for (HashMap<String,String> columns : rows) { %>
                
                      <img style="border-radius:50%; width: 150px; height: 150px; border: solid 1px #6b6767;" 
                      src= "<%=request.getContextPath() %><%= columns.get("image") %>">

                      <p><a href="other_user?id=<%= columns.get("id") %>"><%= columns.get("name") %></a></p>
                      <p><%= columns.get("age") %>歳</p>
                
                <% } %>
            </div>            
          </div>          
    </body>
</html>

<style>
.arraylist {
  padding-top:20px;
  display: flex;
  flex-direction: row;

}

#app {
  margin-top:150px;
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
    background-color: #2589d0;
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
    border: 2px solid #2589d0;
    border-radius: 3px;
    color: #333333;
    font-size: 1em;
    cursor: pointer;
}

.selectbox-002 select:focus {
    outline: 1px solid #2589d0;
}
</style>

<script>
  new Vue({
      el: '#app',
      data() {
          return {
              isShow: false,
          }
      },
  })
</script>