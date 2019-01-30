package servlets;

import data.Attribute;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import data.UserNotifications;
import data.Notification;

/**
 *
 * @author Ella
 */
@WebServlet(name = "Registrator", urlPatterns = {"/registrator"})
public class Registrator extends HttpServlet {

    @Inject
    UserNotifications userNotifications;

    private HttpServletRequest request;
    private HttpServletResponse response;
    private String name;
    private String value;
    private Notification alert;
    private static final String PAGE = "/WEB-INF/jsp/index.jsp";
    private final static int MAX_LENGHT = 255;

    @Override
    public void init() {
        getServletContext().setAttribute("attr", new Attribute());

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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
        print();
    }

    private void processRequest(HttpServletRequest request1, HttpServletResponse response1) throws IOException, UnsupportedEncodingException, ServletException {
        initialization(request1, response1);
        setEncoding();

        if (!isValid()) {
            request.setAttribute("alert", alert);
            print();
        } else {
            Attribute attr = (Attribute) getServletContext().getAttribute("attr");
            attr.addParameter(name, value);
            alert = userNotifications.getSuccessAdd();
            request.setAttribute("alert", alert);
            print();
        }
    }

    private void initialization(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        name = request.getParameter("name").trim();
        value = request.getParameter("value").trim();
    }

    private void setEncoding() throws UnsupportedEncodingException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

    private boolean isValid() {
        if (name == null || name.isEmpty()) {
            alert = userNotifications.getWrongNameIsEmpty();
            return false;
        }
        if (name == null || name.length() > MAX_LENGHT) {
            alert = userNotifications.getWrongLength(MAX_LENGHT);
            return false;
        }
        if (value.isEmpty()) {
            alert = userNotifications.getWrongValueIsEmpty();
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            alert = userNotifications.getWrongInt();
            return false;
        }
        return true;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
//    private void setSuccessAlert(String message) {
//        alert = "<div class='alert alert-success'>"
//                + "<strong>" + message
//                + "</div>";
//    }
//
//    private void setWrongAlert(String message) {
//        alert = "<div class='alert alert-warning'>"
//                + "<strong>" + message
//                + "</div>";
//    }
    private void print() throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(PAGE);
        dispatcher.forward(request, response);
    }

}
