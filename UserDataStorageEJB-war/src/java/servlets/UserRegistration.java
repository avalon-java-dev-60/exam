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
public class UserRegistration extends AuthServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialization(request, response);
        setEncoding();
        String userName = request.getParameter("name");
        if (notEmpty(userName.trim())) {
            userSigingUp(userName);
        } else {
            showWrongMessage();
        }
    }

    private void userSigingUp(String signUp) throws IOException, ServletException {
        try {
            if (authBean.signUp(signUp)) {
                request.getSession().setAttribute(USER_ID, authBean.getId());
                request.getSession().setAttribute(LOGIN, authBean.getName());
                redirect(REGISTRATOR_PAGE);
            } else {
                alert = authNotifications.getWrongSignUp();
                getServletContext().setAttribute("loginAlert", alert);
                redirect(PAGE);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace(System.err);
            showDbErrorMessage();
        }
    }
}
