package org.zuel.app.servlet;

import org.zuel.app.dao.DeptOperationDAO;
import org.zuel.app.dao.DoctorOperationDAO;
import org.zuel.app.dao.PatientOperationDAO;
import org.zuel.app.module.DeptData;
import org.zuel.app.module.DoctorData;
import org.zuel.app.module.PatientData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * used for users when logging in
 * @author 陈昕
 * **/
@WebServlet(name = "Login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String identity=request.getParameter("identity");
        String info;
        DoctorData doctor=new DoctorData();
        PatientData patient=new PatientData();

        if(identity.equals("patient"))
            PatientOperationDAO.findData(id,patient);
        else
            DoctorOperationDAO.findData(id,doctor);
        if(patient.getId()!=null||doctor.getId()!=null) {
            String pwd,userId,userName;
            if(patient.getId()!=null){
                pwd=patient.getPassword();
                userId=patient.getId();
                userName=patient.getName();
            }
            else{
                pwd=doctor.getPassword();
                userId=doctor.getId();
                userName=doctor.getName();
            }
            if(pwd.equals(password)) {
                info="欢迎您"+userName+"!";
                List<DeptData> deptList= DeptOperationDAO.readDeptAll();
                request.getServletContext().setAttribute("deptList",deptList);
                request.getSession().setAttribute("outputMassage",info);
                request.getSession().setAttribute("login",userId);
                if(patient.getId()!=null) {
                    request.getSession().setAttribute("patient",patient);
                    request.getSession().setAttribute("userType","patient");
                    response.sendRedirect("PatientHome.jsp");
                }
                else {
                    DeptData doctorDept=new DeptData();
                    DeptOperationDAO.findData(doctor.getDept_id(),doctorDept);
                    request.getSession().setAttribute("userType","doctor");
                    request.getSession().setAttribute("doctor",doctor);
                    request.getSession().setAttribute("doctorDept",doctorDept);
                    request.getSession().setAttribute("doctorDeptId",doctorDept.getId());
                    response.sendRedirect("DoctorHome.jsp");
                }
            }
            else {
                info = "密码不正确!";
                request.getSession().setAttribute("error",info);
                response.sendRedirect("index.jsp");
            }
        }
        else {
            info = "id不正确!";
            request.getSession().setAttribute("error",info);
            response.sendRedirect("index.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
}
