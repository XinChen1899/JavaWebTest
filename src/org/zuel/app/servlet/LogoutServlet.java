package org.zuel.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * used for users when logging out
 * **/
@WebServlet(name = "Logout")
public class LogoutServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException{
        request.getSession().setAttribute("login",null);
        request.getSession().setAttribute("error",null);
        response.sendRedirect("index.jsp");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
}
