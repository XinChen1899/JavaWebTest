package org.zuel.app.servlet;

import org.zuel.app.dao.RegOperationDAO;
import org.zuel.app.module.RegistrationData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * used for patient to add new registration
 * @author 陈昕
 * **/
@WebServlet(name = "AddReg")
public class AddRegServlet extends HttpServlet {

    private int price=0;

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        request.setCharacterEncoding("utf-8");
        String patientid=request.getSession().getAttribute("login").toString();
        String deptid=request.getParameter("deptid");
        String date=request.getParameter("date");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>挂号结果</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <script type=\"text/javascript\">");
        if(newRegistration(patientid,deptid,date))
            out.printf("        alert(\"挂号成功！费用为%d元\");\n",price);
        else
            out.println("        alert(\"挂号失败！\");");
        out.println("        window.location.href=\" PatientReg\";");
        out.println("    </script>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request,response);
    }

    private boolean newRegistration(String patientid,String deptId,String date)
    {
        java.util.Date regTime=RegistrationData.dateFormatter(date);
        RegistrationData newReg=new RegistrationData(patientid,deptId,regTime);
        price=newReg.getPrice();
        return RegOperationDAO.insertData(newReg);
    }
}
