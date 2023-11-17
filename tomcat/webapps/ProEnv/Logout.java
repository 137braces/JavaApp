import java.util.*;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;


public class Logout extends HttpServlet  {

    public Logout(){
        super();        
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        HttpSession session = request.getSession();
        session.invalidate();

        String view = "/WEB-INF/views/login.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);


        

    }
    
}
