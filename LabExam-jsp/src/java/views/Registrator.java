package views;

import domain.Parameter;
import ejb.UpdateBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;

@WebServlet(name = "Registrator", urlPatterns = "/registrator")
public class Registrator extends HttpServlet {

    String parameter;
    String value;
    Parameter param;
    RequestDispatcher dispatcher;

    @EJB
    UpdateBean updateBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submitButton") != null) {
            registratorAdd(request, response);
        } else if ((request.getParameter("deleteButton") != null)) {
            registratorDel(request, response);
        } else {
            dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void registratorAdd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parameter = request.getParameter("userParameter");
        value = request.getParameter("userValue");
        System.out.println(parameter);
        System.out.println(value);
        if (parameter != null && !parameter.isEmpty()) {
            request.setAttribute("userParameter", parameter);
            if (value != null && !value.isEmpty()) {
                request.setAttribute("userValue", value);
                try {
                    //Новый параметр
                    boolean add = updateBean.addNew(parameter, value);
                    if (add == true) {
                        request.setAttribute("message", "You input new parameter");
                    } else {
                        request.setAttribute("message", "You change old parameter");
                    }
                } catch (Exception e) {
                    printStackTrace(e);
                    request.setAttribute("error", "Parameter not exist!");
                }

            } else {
                request.setAttribute("error", "Value is empty!");
            }
        } else {
            request.setAttribute("error", "Parameter is required!");
        }
        dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void registratorDel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parameter = request.getParameter("userParameter");
        value = request.getParameter("userValue");
        System.out.println(parameter);
        System.out.println(value);
        if (parameter != null && !parameter.isEmpty()) {
            request.setAttribute("userParameter", parameter);
            try {
                //Новый параметр
                boolean del = updateBean.delete(parameter);
                if (del == true) {
                    request.setAttribute("message", "You delete parameter");
                } else {
                    request.setAttribute("message", "Parameter not exist or delete yet");
                }
            } catch (Exception e) {
                printStackTrace(e);
                request.setAttribute("error", "Parameter not exist!");
            }

        } else {
            request.setAttribute("error", "Parameter is required!");
        }

        dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
