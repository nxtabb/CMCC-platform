package com.hrbeu.Controller;

import com.hrbeu.Entity.TOperator;
import com.hrbeu.Service.Impl.LoginServiceImpl;
import com.hrbeu.Service.LoginService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/check")
public class LoginController extends HttpServlet {
    LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Operator_ID = req.getParameter("Operator_ID");
        String Operator_Pwd = req.getParameter("Operator_Pwd");
        TOperator tOperator = null;
        tOperator = loginService.login(Operator_ID,Operator_Pwd);
        if(tOperator==null){
            String error1 = "用户名不存在或密码错误";
            req.setAttribute("error1",error1);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("tOperator",tOperator);
            resp.sendRedirect("/welcome");
        }

    }
}
