/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Victor.Malmygin
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
        
        if (request.getParameter("view")!= null){
            request.getRequestDispatcher("view.html").forward(request, response);
            return;
        }
        
        String reply = null;
        
        String data_name;
        int value;
        Parameter prm = null;
        
        
        
        data_name = request.getParameter("data-name");
        if (data_name.isEmpty() || data_name.length() > 255){
            reply = "<h3>Error: " + "wrong data name" + "</h3>";
        }else{
            try {
                value = Integer.parseInt(request.getParameter("value"));
                    try {
                        prm = new Parameter(data_name, value);
                    }catch(Exception e){
                        reply = "<h3>Error: " + e.getMessage() + "</h3>";
                    }
            }catch (NumberFormatException e){
                reply = "<h3>Error: " + e.getMessage() + "</h3>";
            }
        }
        
        Attribute a = (Attribute)getServletContext().getAttribute("attribute");
        if (a == null){
            a = new Attribute();
            getServletContext().setAttribute("attribute", a);
        }
        if(prm != null) {
            reply = "<h3>" + prm.getData_name() + " : " + prm.getValue() + " added" + "</h3>";
            for(Parameter p : a.getList()){
                if(prm.getData_name().equals(p.getData_name())){
                    reply = "<h3>Warning: " + p.getData_name() + " replaced to " + prm.getValue() + "</h3>";
                    break;
                }              
            }
            if(!a.add(prm)){
                reply = "<h3>" + prm.getData_name() + " : " + prm.getValue() + " not added" + "</h3>";
            }
        }
          
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registrator</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + reply + "</h1>");

//            Map<String,String[]> map = request.getParameterMap();
//            for (Entry entry : map.entrySet()){
//                out.println(entry.getKey() + " " + ((String[])entry.getValue())[0] + "<br>");
//            }

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
        processRequest(request, response);
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
