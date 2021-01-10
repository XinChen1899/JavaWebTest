package org.zuel.app.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * 过滤器，用于拦截非法访问
 * @author 陈昕
 * **/
@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    /** the url of file that don't need filter**/
    private String loginUrl;


    /**
     * destroy the filter
     * **/
    @Override
    public void destroy() {}



    /**
     * the filter work
     * @param req
     * @param resp
     * @param chain
     * @author 陈昕
     * **/
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session = request.getSession();
        String uri = ((HttpServletRequest) req).getRequestURI();
        if(session.getAttribute("login") == null && !loginUrl.contains(uri)) {
            System.out.println(uri);
            response.sendRedirect("index.jsp");
        } else {
            chain.doFilter(req, resp);
        }
    }



    /**
     * initial filter
     * @param config
     * @author 陈昕
     * **/
    @Override
    public void init(FilterConfig config) throws ServletException {
        this.loginUrl = config.getInitParameter("noCheck");
    }

}
