package views;

import domain.Attribute;
import domain.Parameter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static views.Registrator.attrib;

@WebServlet(name = "ViewList", urlPatterns = "/viewlist")
public class ViewList extends HttpServlet {

    String parameter;
    String value;
//    Parameter param = new Parameter("test", 123);
//    Parameter param1 = new Parameter("test2", 345);
//    List<Parameter> Example;


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewlist(request, response);
    }

    protected void viewlist(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        parameter = request.getParameter("userParameter");
        value = request.getParameter("userValue");

//        System.out.println(parameter);
//        System.out.println(value);
        try {
            System.out.println(attrib.getList().size());
            for (int i = 0; i < attrib.getList().size(); i++) {
                Parameter parameter = attrib.getList().get(i);
                String message = parameter.printInfo();
//                Param.getParameter().toString();
//                Integer.toString(Param.getValue());

                System.out.println(message);

                request.setAttribute("parameters", parameter);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Parameter not exist!");
        }

//        if (parameter != null && !parameter.isEmpty()) {
//            request.setAttribute("userParameter", parameter);
//            if (value != null && !value.isEmpty()) {
//                intvalue = Integer.parseInt(value);
//                request.setAttribute("userValue", value);
//                try {
//                    for (Parameter p: attrib.getList()) {
//                        request.setAttribute("message", attrib.getList());
//                    }
//                                        
//                    
//                } catch (Exception e) {
//                    request.setAttribute("error", "Parameter not exist!");
//                }
//
//            } else {
//                request.setAttribute("error", "Value is empty!");
//            }
//        } else {
//            request.setAttribute("error", "Parameter is required!");
//        }
//        Example = new ArrayList<Parameter>();
//        Example.add(param);
//        Example.add(param1);
//
//        request.setAttribute("list", Example);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewlist.jsp");
        dispatcher.forward(request, response);
    }
}
