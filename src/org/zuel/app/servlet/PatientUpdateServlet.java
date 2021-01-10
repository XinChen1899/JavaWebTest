package org.zuel.app.servlet;

import org.zuel.app.dao.PatientOperationDAO;
import org.zuel.app.module.PatientData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * used for patient to update his or her information
 * **/
@WebServlet(name = "PatientUpdate")
public class PatientUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        String id=request.getSession().getAttribute("login").toString();
        String name=request.getParameter("name");
        String sex=request.getParameter("sex");
        int age=PatientData.calculateAge(request.getParameter("age"));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("    <head>");
        out.println("       <title>修改结果</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <script type=\"text/javascript\">");
        if(!PatientOperationDAO.updateData(id,name,sex,age))
            out.println("            alert(\"修改失败\");");
        else{
            PatientData patient=new PatientData();
            PatientOperationDAO.findData(id,patient);
            request.getSession().setAttribute("patient",patient);
            request.getSession().setAttribute("outputMassage","欢迎您"+name);
            out.println("            alert(\"修改成功\");");
        }
        out.println("            window.location.href=\" PatientHome.jsp\"");
        out.println("        </script>");
        out.println("   </body>");
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
}
