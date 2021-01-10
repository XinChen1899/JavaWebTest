package org.zuel.app.servlet;

import org.zuel.app.dao.DoctorOperationDAO;
import org.zuel.app.module.DoctorData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * used for doctor to update his or her information
 * **/
@WebServlet(name = "DoctorUpdate")
public class DoctorUpdateServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {

        HttpSession session=request.getSession();
        request.setCharacterEncoding("utf-8");
        String id=session.getAttribute("login").toString();
        String name=request.getParameter("name");
        String dept_id=request.getParameter("dept_id");
        String sex=request.getParameter("sex");
        request.getSession().setAttribute("doctorDeptId",dept_id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        out.println("<html>");
        out.println("<head><title>修改结果</title></head>");
        out.println("<body>");
        out.println("    <script type=\"text/javascript\">");
        if(!DoctorOperationDAO.updateData(id,name,dept_id,sex))
            out.println("        alert(\"修改失败\");");
        else{
            DoctorData doctor=new DoctorData();
            DoctorOperationDAO.findData(id,doctor);
            session.setAttribute("doctor",doctor);
            out.println("        alert(\"修改成功\");");
            session.setAttribute("outputMassage","欢迎您"+name);
        }
        out.println("        window.location.href=\" DoctorHome.jsp\";");
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
}
