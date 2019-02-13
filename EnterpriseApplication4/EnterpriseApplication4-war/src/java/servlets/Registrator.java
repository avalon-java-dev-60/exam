/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.UpdateBeanLocal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ulll
 */
@WebServlet(name = "Registrator", urlPatterns = {"/registrator"})
public class Registrator extends HttpServlet {
    
    @EJB
    private UpdateBeanLocal update;
    HttpServletRequest request;
    HttpServletResponse response;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getParameter("Parameter");
        String val = request.getParameter("Value");
        String view = request.getParameter("View");
        String del = request.getParameter("Delete");
        String set = request.getParameter("Set");
        if (view != null) {
            request.setAttribute("message", "View page");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
            dispatcher.forward(request, response);
        }
        if (del != null) {
            DeleteParameter(name);
            request.setAttribute("message", "Parameter was deleted");
        }
        if (set != null){
            AddParameter(name, val);
            request.setAttribute("message", "Parameter added to Database");
        }
       
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        
    }

    private void DeleteParameter(String name) {
        if (TrimName(name)) {
            update.delete(name);
            
        }
    }

    private void AddParameter(String name, String value) {
        if (TrimName(name) && GoodValue(value)) {
            update.add(name, value);
            
        }
    }

    private boolean TrimName(String name) {
        name = name.replaceAll("\\s+", "");
        if (name.length() < 255 && name != null) {
            return true;
        } else {
            return false;
        }
        
    }
    
    private boolean GoodValue(String value) {
        try {
            int v = Integer.parseInt(value);
        } catch (NumberFormatException n) {
            return false;
        }
        return true;
    }
    
}
