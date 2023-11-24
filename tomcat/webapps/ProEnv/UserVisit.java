import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import pakage.userbean.UserBean;
import pakage.follwbean.FollowBean;

import java.sql.*;

public class UserVisit extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        //表示させたい他のユーザーid
        final String other_id = request.getParameter("id");
         
        //自分のid
        HttpSession session = request.getSession(false);

        //自分の性別
        final String gender = (String)session.getAttribute("gender");

        UserBean userBean = new UserBean();
        userBean.setId(other_id);

        //下記メソッドは自分を含めた同性検索をフィルターするため。
        userBean.ifGender(gender);

        UserVisitDAO userVisitDAO = new UserVisitDAO(userBean);

        final String filter_gender = userBean.getGender();

        if(userBean.getResNext()){

            request.setAttribute("id", userBean.getId());
            request.setAttribute("image",userBean.getImage());
            request.setAttribute("name",userBean.getName());
            request.setAttribute("age",userBean.getAge());
            request.setAttribute("address",userBean.getAddress());
            request.setAttribute("job", userBean.getJob());

            String view = "/WEB-INF/views/other_user.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);

        }else if(userBean.getResNext() == false ){

            String view = "/WEB-INF/views/other_user.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    //doPostはユーザーのいいね処理を実装します。

        //下記ユーザーidフォロー機能に利用します。
        //相手のユーザーid
        final String other_id = request.getParameter("id");
         
        //自分のユーザーid
        HttpSession session = request.getSession(false);
        final String self_id = (String)session.getAttribute("id");

        //インスタンスを作成。
        FollowBean followBean = new FollowBean();
        //相手と自分のユーザーidをプロパティに格納。
        followBean.setFollows(self_id, other_id);

        //DAOにfollowBeanプロパティを渡す。
        UserFollowsDAO followsDAO = new UserFollowsDAO(followBean);

        //INSERT文の結果を取得
        int res = followBean.getRes();


        //INSERT文の処理が成功すればSELECT文が実行される。
        if(res != 0){   
            //SELECT文の処理結果
            boolean resNext = followBean.getResNext();

            //マッチング(相互フォロー)になったときの処理。(ajax通信)
            if(resNext){
                //JavaScriptで値取得をトリガーに画面に「マッチングしました！」と表示する。
                request.setAttribute("matching","matching");
                //マッチング後、メッセージルームを取得。
            
            }else if(resNext == false){
                //相互フォローではないときは何もしない。
                
            }

        }else{
            //INSERT文が失敗したときの処理。
        }
        
        
    }
}
