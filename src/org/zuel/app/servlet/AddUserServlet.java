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
import java.io.PrintWriter;


/**
 * used for new user to sign up a new account
 * @author 陈昕
 * **/
@WebServlet(name = "AddUser")
public class AddUserServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String username=request.getParameter("name");
        String sex=request.getParameter("sex");
        String userType=request.getParameter("userType");

        if(userType.equals("patient")){
            int age=PatientData.calculateAge(request.getParameter("age"));
            PatientData newPatient=new PatientData(id,username,password,age,sex);
            if(!PatientOperationDAO.insertData(newPatient)){
                printMassage(response);
                return;
            }
            request.getSession().setAttribute("patient",newPatient);
            String info="欢迎您"+username+"!";
            request.getSession().setAttribute("userType","patient");
            request.getSession().setAttribute("outputMassage",info);
            request.getSession().setAttribute("login",id);
            response.sendRedirect("PatientHome.jsp");
        }
        else{
            String dept_id=request.getParameter("deptid");
            DoctorData newDoctor=new DoctorData(id,username,dept_id,sex,password);
            DeptData doctorDept=new DeptData();
            DeptOperationDAO.findData(dept_id,doctorDept);
            if(!DoctorOperationDAO.insertData(newDoctor)){
                printMassage(response);
                return;
            }
            request.getSession().setAttribute("doctor",newDoctor);
            request.getSession().setAttribute("doctorDept",doctorDept);
            String info="欢迎您"+username+"!";
            request.getSession().setAttribute("userType","doctor");
            request.getSession().setAttribute("outputMassage",info);
            request.getSession().setAttribute("login",id);
            response.sendRedirect("DoctorHome.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);

    }

    private void printMassage(HttpServletResponse response)
            throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head><title>注册失败</title></head>");
        out.println("<body>");
        out.println("    <script type=\"text/javascript\">");
        out.println("        alert(\"用户已存在\");");
        out.println("        window.location.href=\"index.jsp\"");
        out.println("    </script>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
