package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Users.User;

/**
 *
 * @author 734972
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       
        String action = request.getParameter("action");
        if (action != null && action.equals("logout")) {
            request.getSession().removeAttribute("user");
            request.setAttribute("logout", "You have successfully logged out.");
        }
        
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            response.sendRedirect("home");
            return;
        }
        
        Cookie userCookie = getCookie(request.getCookies());
        
        if (userCookie != null && !userCookie.getValue().equals("")) {
            request.setAttribute("username", userCookie.getValue());
            request.setAttribute("remember", "checked");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        String username = (String)request.getParameter("username");
       String password = (String)request.getParameter("password");
       String[] rememberCheck = request.getParameterValues("remember");
       
       if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
           request.setAttribute("errorMessage", "Invalid Login");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
           return;
       }
       
       UserService service = new UserService();
       User user = service.login(username, password);
       
       if (user == null) {
           request.setAttribute("username", username);
           request.setAttribute("errorMessage", "Invalid Login");
           getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
       }
       
       if (rememberCheck != null) {
           response.addCookie(new Cookie("user", username));
       }
       
       else {
           Cookie cookie = getCookie(request.getCookies());
           if (cookie != null) {
                cookie.setMaxAge(-1);
                cookie.setValue(null);
                response.addCookie(cookie);
           }
       }
       
       HttpSession session = request.getSession();
       session.setAttribute("user", user);
       response.sendRedirect("home");
    } 
    
    private Cookie getCookie(Cookie[] cookies) {
        Cookie userCookie = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("user")) {
                userCookie = c;
            }
        }
        return userCookie;
    }

}
