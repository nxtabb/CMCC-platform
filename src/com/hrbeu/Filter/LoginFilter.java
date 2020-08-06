package com.hrbeu.Filter;

import com.hrbeu.Entity.TOperator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpSession session = request.getSession();
        TOperator tOperator = (TOperator) session.getAttribute("tOperator");
        if(tOperator==null){
            String error1 = "未登录，请重新登录";
            servletRequest.setAttribute("error1",error1);
            servletRequest.getRequestDispatcher("index.jsp").forward(servletRequest, servletResponse);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
