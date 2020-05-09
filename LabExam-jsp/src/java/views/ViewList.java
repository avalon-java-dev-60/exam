package views;

import database.DBParameter;
import ejb.SelectBean;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewList", urlPatterns = "/viewlist")
public class ViewList extends HttpServlet {

    @EJB
    SelectBean selectBean;
    List<DBParameter> list = null;
    RequestDispatcher dispatcher;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("templateButton") != null) {
            viewTemplate(request, response);
        } else if (request.getParameter("intervalButton") != null) {
            viewInterval(request, response);
        } else if (request.getParameter("allButton") != null) {
            viewAll(request, response);
        }
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }

    protected void viewTemplate(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String template = request.getParameter("userTemplate");
        if ((template != null && !template.isEmpty())) {
            if (template.matches("[\\d\\w_]+")) {
                request.setAttribute("userTemplate", template);
                list = selectBean.findTemplate(template);
                request.setAttribute("list", list);
            }
        } else {
            request.setAttribute("error", "Template is required!");
        }
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }

    protected void viewInterval(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String begin = request.getParameter("userBeginValue");
        String end = request.getParameter("userEndValue");
        if ((begin != null && !begin.isEmpty()) && (end != null && !end.isEmpty())) {
            request.setAttribute("userBeginValue", begin);
            request.setAttribute("userEndValue", end);
            list = selectBean.findInterval(begin, end);
            request.setAttribute("list", list);
        } else {
            request.setAttribute("error", "Intervals are required!");
        }
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }

    protected void viewAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        list = selectBean.findAll();
        request.setAttribute("list", list);
        dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }

}
