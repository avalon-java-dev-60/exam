package servlets;

import beans.UpdateBeanLocal;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;

/**
 *
 * @author Ella
 */
@WebServlet(name = "Registrator", urlPatterns = {"/registrator"})
public class Registrator extends InitServlet {

    @EJB
    private UpdateBeanLocal update;

    private String name;
    private String value;
    private static final String PAGE = "/registrator.jsp";
    private final static int MAX_LENGHT = 255;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, UnsupportedEncodingException, ServletException {
        initialization(request, response);
        isAuthorised();
        setEncoding();
        String add = request.getParameter("add");
        String delete = request.getParameter("delete");
        if (add != null) {
            addParam();
        }
        if (delete != null) {
            deleteParam();
        }
    }

    /**
     *
     * @param request
     * @param response
     */
    @Override
    protected void initialization(HttpServletRequest request, HttpServletResponse response) {
        super.initialization(request, response);
        name = request.getParameter("name").trim();
        value = request.getParameter("value").trim();
    }

    private void addParam() throws UnsupportedEncodingException, ServletException, IOException {
        if (nameIsValid() && valueIsValid()) {
            long id = getUserId();
            alert = update.add(name, value, id) ? notifications.getSuccessAdd() : notifications.getWrongDb();
            request.setAttribute("alert", alert);
            redirect(PAGE);
        } else {
            request.setAttribute("alert", alert);
            redirect(PAGE);
        }
    }

    private void deleteParam() throws UnsupportedEncodingException, ServletException, IOException {
        if (nameIsValid()) {
            long id = getUserId();
            alert = update.delete(name, id) ? notifications.getSuccessDelete() : notifications.getWrongDb();
            request.setAttribute("alert", alert);
            redirect(PAGE);
        } else {
            request.setAttribute("alert", alert);
            redirect(PAGE);
        }
    }

    private long getUserId() {
        return (Long) request.getSession().getAttribute(USER_ID);
    }

    private boolean valueIsValid() {
        if (value == null || value.isEmpty()) {
            alert = notifications.getWrongValueIsEmpty();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            alert = notifications.getWrongInt();
            return false;
        }
        return true;
    }

    private boolean nameIsValid() {
        if (name == null || name.isEmpty()) {
            alert = notifications.getWrongNameIsEmpty();
            return false;
        }
        if (name.length() > MAX_LENGHT) {
            alert = notifications.getWrongLength(MAX_LENGHT);
            return false;
        }
        return true;
    }
}
