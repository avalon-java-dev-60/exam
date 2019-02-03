package servlets;

import data.ActionNotifications;
import data.Notification;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ella
 */
public abstract class InitServlet extends HttpServlet {

    @Inject
    protected ActionNotifications notifications;
    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected Notification alert;
    protected static final String AUTH_PAGE = "index.jsp";
    protected static final String USER_ID = "userId";
    protected static final String LOGIN = "login";

    protected void initialization(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;   
    }

    protected void setEncoding() throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
    
    protected void isAuthorised()  throws ServletException, IOException{
        Object login = request.getSession().getAttribute(USER_ID);
        if (login == null) {
            this.request.getRequestDispatcher(AUTH_PAGE).forward(this.request, this.response);
        }
    }
       
    protected void redirect(String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
