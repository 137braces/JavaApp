import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Signup extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        
        
        String birthDay = request.getParameter("calender");
        BirthSet birthset = new BirthSet();
        String age = getAge(birthDay);

        private int getAge(String birthDay) {
            String birthdate = birthDay;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/M/d");
            LocalDate localBirdhdate = LocalDate.parse(birthdate, formatter);
            LocalDate nowDate = LocalDate.now();
            return Long.toString(ChronoUnit.YEARS.between(localBirdhdate, nowDate));
        }


        
        String view = "/WEB-INF/views/user.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }

}