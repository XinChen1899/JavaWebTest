package org.zuel.app.servlet;

import org.zuel.app.dao.DoctorOperationDAO;
import org.zuel.app.dao.PatientOperationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * used for user to sign out his or her account
 * @author 陈昕
 * **/
@WebServlet(name = "DelUserServlet")
public class DelUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id=request.getSession().getAttribute("login").toString();
        String userType= request.getSession().getAttribute("userType").toString();
        if(userType.equals("doctor"))
            DoctorOperationDAO.deleteData(id);
        else
            PatientOperationDAO.deleteData(id);
        request.getSession().setAttribute("login",null);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>注销成功</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <script type=\"text/javascript\">");
        out.println("        alert(\"注销成功\");");
        out.println("        window.location.href=\"index.jsp\";");
        out.println("    </script>");
        out.println("</body>");
        out.println("</html>");
        out.flush();
        out.close();
    }
}
