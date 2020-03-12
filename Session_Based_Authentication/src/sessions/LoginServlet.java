package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String user = "admin";
	private final String password = "admin@1234";
	
   
   
    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get request parameters for username and password
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
         
        if(user.equals(username) && password.equals(passwd)){
        	
        	// When ever new session is created, it creates a new cookie named JSESSIONID and adds the created session to that cookie.
        	HttpSession session = request.getSession();
            session.setAttribute("user", "ashwani");
            
            //setting session to expire in 1 hour
            session.setMaxInactiveInterval(60*60);
            
            // Cookie not mandatory. Just adding with some purpose.           
            Cookie userName = new Cookie("user", user);
            userName.setMaxAge(60*60);
            response.addCookie(userName);
            response.sendRedirect("LoginSuccess.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
	}

}
