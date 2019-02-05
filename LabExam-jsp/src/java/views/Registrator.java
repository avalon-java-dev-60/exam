package views;

import domain.Attribute;
import domain.Parameter;
//import ejb.SelectBean;
//import ejb.UpdateBean;
import java.io.IOException;
import java.util.Arrays;
//import javax.ejb.EJB;
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
    static Attribute attrib = new Attribute();

//    @EJB
//    SelectBean selectBean;
//    @EJB
//    UpdateBean udpateBean;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("submitButton") != null) {
            registrator(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void registrator(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parameter = request.getParameter("userParameter");
        value = request.getParameter("userValue");
        int intvalue = 0;

        String error;
        System.out.println(parameter);
        System.out.println(value);

        if (parameter != null && !parameter.isEmpty()) {
            request.setAttribute("userParameter", parameter);
            if (value != null && !value.isEmpty()) {
                intvalue = Integer.parseInt(value);
                request.setAttribute("userValue", value);
//                System.out.println(attrib.getList());
                try {
//                    if (attrib.getList().isEmpty()) {
                    //Новый параметр
                    param = new Parameter(parameter, intvalue);
                    attrib.add(param);
//                    System.out.println(param.printInfo());
                    
                    
                    request.setAttribute("message", "You input new parameter");
//                    } else {
//                        for (Parameter p : attrib.getList()) {
//                            param = new Parameter(parameter, intvalue);
//                            //Замена параметра
//                            if (parameter.equals(p.getParameter())) {
//                                param.changeParam(parameter);
//                                attrib.add(param);
//                                request.setAttribute("message", "You change old parameter");
//                                System.out.println("Change " + param);
//                            } else {
//                                attrib.add(param);
//                                System.out.println("New " + param);
//                                request.setAttribute("message", "You input new parameter");
//                            }
//                        }
//                    }
                } catch (Exception e) {
//                    printStackTrace(e);
                    request.setAttribute("error", "Parameter not exist!");
                }

            } else {
                request.setAttribute("error", "Value is empty!");
            }
        } else {
            request.setAttribute("error", "Parameter is required!");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

}
