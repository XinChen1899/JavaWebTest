package org.zuel.app.servlet;

import org.zuel.app.dao.DeptOperationDAO;
import org.zuel.app.module.DeptData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * used for new doctor when he or she choose the dept while signing up a new account
 * @author 陈昕
 * **/
@WebServlet(name = "DisplayDept")
public class DisplayDeptServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        List<DeptData> deptList= DeptOperationDAO.readDeptAll();
        request.getServletContext().setAttribute("deptList",deptList);
        response.sendRedirect("UserSignIn.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }
}
