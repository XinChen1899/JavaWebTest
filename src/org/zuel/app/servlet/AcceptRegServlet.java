package org.zuel.app.servlet;

import org.zuel.app.dao.RegOperationDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * used for doctor to accept the registration
 * @author 陈昕
 * **/
@WebServlet(name = "AcceptReg")
public class AcceptRegServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException {
        request.setCharacterEncoding("utf-8");
        String reg_id=request.getParameter("reg_id");
        RegOperationDAO.acceptReg(reg_id);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("    <title>受理成功</title>");
        out.println("<head>");
        out.println("<body>");
        out.println("    <script type=\"text/javascript\">");
        out.println("        alert(\"受理成功\");");
        out.println("        window.location.href=\"DeptReg\";");
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
