package org.zuel.app.servlet;

import org.zuel.app.dao.RegOperationDAO;
import org.zuel.app.module.DeptData;
import org.zuel.app.module.ModifiedReg;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * used for doctor to browse the registration of his or her dept
 * @author 陈昕
 * **/
@WebServlet(name = "DeptReg")
public class DeptRegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String dept_id=session.getAttribute("doctorDeptId").toString();
        List<ModifiedReg> regList= RegOperationDAO.readRegByDept(dept_id);
        request.setAttribute("regList",regList);
        request.getRequestDispatcher("AcceptReg.jsp").forward(request,response);
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
