package servlets;

import beans.SelectBeanLocal;
import database.Params;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ella
 */
@WebServlet(name = "ViewList", urlPatterns = {"/view-list"})
public class ViewList extends InitServlet {

    @EJB
    private SelectBeanLocal selectBean;
    private static final String PAGE = "/WEB-INF/jsp/result-table.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialization(request, response);
        isAuthorised();
        setEncoding();

        List<Params> list = null;
        long id = (Long)request.getSession().getAttribute(USER_ID);
        if (request.getParameter("pattern-button") != null) {
            String pattern = request.getParameter("pattern");
            if (pattern.matches("[\\d\\w_]+")) {
                list = selectBean.findByPattern(pattern, id);
            } else {
                alert = notifications.getWrongPattern();
                request.setAttribute("alert", alert);
                redirect(PAGE);
            }
        } else if (request.getParameter("range-button") != null) {
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            try {
                int start = (from == null || from.length() == 0) ? Integer.MIN_VALUE : Integer.parseInt(from);
                int end = (to == null || to.length() == 0) ? Integer.MAX_VALUE : Integer.parseInt(to);
                list = selectBean.findByInterval(start, end, id);
            } catch (NumberFormatException e) {
                alert = notifications.getWrongRange();
                request.setAttribute("alert", alert);
                redirect(PAGE);
            }
        } else {
            list = selectBean.findAll(id);
        }
        request.setAttribute("list", list);
        redirect(PAGE);
    }
}
