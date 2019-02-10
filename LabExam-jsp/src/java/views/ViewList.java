package views;

import ejb.SelectBean;
import java.io.IOException;
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
            
    String parameter;
    String value;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewlist(request, response);
    }

    protected void viewlist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parameter = request.getParameter("userParameter");
        value = request.getParameter("userValue");
        try {


        } catch (Exception e) {
            request.setAttribute("error", "Parameter not exist!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }
}
