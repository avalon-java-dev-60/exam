package servlets;

import java.io.IOException;
import javax.persistence.PersistenceException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ella
 */
public class Authorisation extends AuthServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialization(request, response);
        setEncoding();

        String userName = request.getParameter("name");
        if (notEmpty(userName.trim())) {
            userLogging(userName);
        } else {
            showWrongMessage();
        }
    }

    private void userLogging(String login) throws IOException, ServletException {
        try {
            if (authBean.login(login)) {
                request.getSession().setAttribute(USER_ID, authBean.getId());
                request.getSession().setAttribute(LOGIN, authBean.getName());
                redirect(REGISTRATOR_PAGE);
            } else {
                alert = authNotifications.getWrongLogin();
                getServletContext().setAttribute("loginAlert", alert);
                redirect(PAGE);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace(System.err);
            showDbErrorMessage();
        }
    }
}
