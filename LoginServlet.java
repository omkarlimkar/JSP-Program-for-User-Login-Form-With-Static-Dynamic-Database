import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean loggedIn = false;
        
        // Static user credentials
        String staticUsername = "admin";
        String staticPassword = "password";
        
        // Dynamic database interaction (you need to replace this with actual database interaction)
        // Assuming you have a User table with username and password columns
        // You'll need to implement your database connection and query here
        // For simplicity, I'll just compare the static credentials
        if (username != null && password != null && username.equals(staticUsername) && password.equals(staticPassword)) {
            loggedIn = true;
        }
        
        if (loggedIn) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>You are logged in successfully.</p>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>User Login</h2>");
            out.println("<form action='LoginServlet' method='post'>");
            out.println("<label for='username'>Username:</label>");
            out.println("<input type='text' id='username' name='username' required><br>");
            out.println("<label for='password'>Password:</label>");
            out.println("<input type='password' id='password' name='password' required><br>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}