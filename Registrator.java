/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.Parameter;
import database.Attribute;
        

/**
 *
 * @author MultatulyIM
 */
public class Registrator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Registrator</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Registrator at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        String err="";
        for(Parameter p: Attribute.list){
            System.out.println(p.convStr());
        }
        Parameter p=new Parameter();
        p.setName("par5");
        int index=Attribute.list.indexOf(p);
        err="Index parameter "+index;
         request.setAttribute("error", err);
         RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
//        processRequest(request, response);
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
//        processRequest(request, response);
        String parameter = request.getParameter("parameter");
        String p_value=request.getParameter("p_value");
        int value;
        StringBuilder err=new StringBuilder();
        Parameter par;
        if (parameter.length()>255){
            err=err.append("Parameter name length more that 255.\n");
           
        }
        if(parameter.length()==0){
            err=err.append("Parameter name is empty.\n");
            
        }
        try{value=parseInt(p_value);
                }catch (NumberFormatException e){
                    err=err.append("Parameter value cannot be converted to integer.\n");
                    
                }
       if (err.length()==0){
           err=err.append("New parameter added.");
           par=new Parameter();
           par.setName(parameter);
//           int index=Attribute.list.indexOf(par);
           
           par.setValue(par.convValue(p_value));
           Attribute.list.add(par);
       }
         request.setAttribute("error", err);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
