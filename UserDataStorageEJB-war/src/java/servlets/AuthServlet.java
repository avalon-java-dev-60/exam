package servlets;

import beans.AutorisationBeanLocal;
import data.AuthNotifications;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;


/**
 *
 * @author Ella
 */
public abstract class AuthServlet extends InitServlet {
    @EJB
    protected AutorisationBeanLocal authBean;
    @Inject
    protected AuthNotifications authNotifications;
    protected static final String PAGE = "index.jsp";
    protected static final String REGISTRATOR_PAGE = "/registrator.jsp";
    
    
    protected boolean notEmpty(String postParam) {
        return postParam != null && !postParam.isEmpty();
    }
    
    protected void showWrongMessage() throws IOException, ServletException {
        alert = authNotifications.getWrongEmptyName();
        getServletContext().setAttribute("loginAlert", alert);
        redirect(PAGE);
    }

    protected void showDbErrorMessage() throws IOException, ServletException {
        alert = notifications.getWrongDb();
        getServletContext().setAttribute("loginAlert", alert);
        redirect(PAGE);
    }
}
