package servlets;

import data.Attribute;
import data.Parameter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ella
 */
@WebServlet(name = "ViewList", urlPatterns = {"/view-list"})
public class ViewList extends HttpServlet {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String name;
    private String value;
    private Attribute attr;
    private static final String PAGE = "/WEB-INF/jsp/result-table.jsp";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initialization(request, response);
        setEncoding();
        attr = (Attribute) getServletContext().getAttribute("attr");
        if (attr == null) {
            getServletContext().setAttribute("attr", new Attribute());
            attr = (Attribute) getServletContext().getAttribute("attr");
        }
        ArrayList<Parameter> list;
        if (request.getParameter("pattern-button") != null) {
            String pattern = request.getParameter("pattern");
            list = attr.getParametersByPattern(pattern);
        } else if (request.getParameter("range-button") != null) {
            String from = request.getParameter("from");
            String to = request.getParameter("to");
            try {
                int start = (from == null || from.length() == 0) ? Integer.MIN_VALUE : Integer.parseInt(from);
                int end = (to == null || to.length() == 0) ? Integer.MAX_VALUE : Integer.parseInt(to);
                list = attr.getParametersByInterval(start, end);
            } catch (NumberFormatException e) {
                list = attr.getParametersAll();
            }

        } else {
            list = attr.getParametersAll();
        }
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

    private void initialization(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    private void setEncoding() throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
}
