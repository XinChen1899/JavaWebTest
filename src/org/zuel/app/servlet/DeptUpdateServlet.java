package org.zuel.app.servlet;

import org.zuel.app.dao.DeptOperationDAO;
import org.zuel.app.module.DeptData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * used for doctor to update the information of his or her dept
 * @author 陈昕
 * **/
@WebServlet(name = "DeptUpdate")
public class DeptUpdateServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String type=request.getParameter("type");
        String description=request.getParameter("description");
        String address=request.getParameter("address");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();

        out.println("<html>");
        out.println("    <head>");
        out.println("       <title>修改结果</title>");
        out.println("    </head>");
        out.println("    <body>");
        out.println("        <script type=\"text/javascript\">");
        if(!DeptOperationDAO.UpdateData(id,name,type,description,address))
            out.println("            alert(\"修改失败\");");
        else{
            DeptData newDept=new DeptData(id,name,type,description,address);
            request.getSession().setAttribute("doctorDept",newDept);
            out.println("            alert(\"修改成功\");");
        }
        out.println("            window.location.href=\" DoctorHome.jsp\"");
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
