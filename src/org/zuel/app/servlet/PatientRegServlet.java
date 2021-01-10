package org.zuel.app.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.zuel.app.dao.DeptOperationDAO;
import org.zuel.app.dao.RegOperationDAO;
import org.zuel.app.module.DeptData;
import org.zuel.app.module.ModifiedReg;


/**
 * used for patient when browsing his or her registration record
 * @author 陈昕
 * **/
@WebServlet(name = "PatientReg")
public class PatientRegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        String id=request.getSession().getAttribute("login").toString();
        request.setCharacterEncoding("utf-8");
        List<ModifiedReg> regList= RegOperationDAO.readRegByPatient(id);
        request.setAttribute("regList",regList);
        request.getRequestDispatcher("AddReg.jsp").forward(request,response);
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
