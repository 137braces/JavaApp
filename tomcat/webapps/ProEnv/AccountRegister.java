import pakage.usermodel.UserModel;

import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class AccountRegister extends HttpServlet {

    public AccountRegister() {
        super();    // TODO Auto-generated constructor stub
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String passwpord = request.getParameter("password");

    
        // Beanを生成
        UserModel usermodel = new UserModel();

        // getterを使ってプロパティを代入
        usermodel.setName(name);
        usermodel.setEmail(email);
        usermodel.setPassword(passwpord);

        AccountRegisterSQL dbRegister = new AccountRegisterSQL(usermodel);
        request.setAttribute("name", name);

        String path = "/WEB-INF/views/AccountRegisterResult.jsp";
        RequestDispatcher rd = request.getRequestDispatcher(path);
        rd.forward(request, response);

        
    }
        
        
        

}

//INSERT INTO users (name, email, password, gender, address, age ) VALUES ("星野さん", "ho@gmail.com", "mikan0713", "男性", "兵庫県", 29)