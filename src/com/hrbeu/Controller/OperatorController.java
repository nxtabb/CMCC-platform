package com.hrbeu.Controller;

import com.hrbeu.Entity.TOperator;
import com.hrbeu.Service.Impl.OperatorServiceImpl;
import com.hrbeu.Service.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/crud")
public class OperatorController extends HttpServlet {
    OperatorService operatorService = new OperatorServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "add":
                String Operator_ID = req.getParameter("Operator_ID");
                String Operator_Name = req.getParameter("Operator_Name");
                String Operator_Pwd = req.getParameter("Operator_Pwd");
                String Is_Admin = req.getParameter("Is_Admin");
                operatorService.addOperator(Operator_ID,Operator_Name,Operator_Pwd,Is_Admin);
                String success = "添加成功";
                resp.getWriter().write(success);
                break;
            case "update":
                Operator_ID = req.getParameter("Operator_ID");
                Operator_Name = req.getParameter("Operator_Name");
                Operator_Pwd = req.getParameter("Operator_Pwd");
                Is_Admin = req.getParameter("Is_Admin");
                operatorService.updateOperator(Operator_ID,Operator_Name,Operator_Pwd,Is_Admin);
                success = "修改成功";
                resp.getWriter().write(success);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "add":
                resp.sendRedirect("newOperator.jsp");
                break;
            case "beforeupadte":
                String Operator_ID = req.getParameter("Operator_ID");
                TOperator tOperator = operatorService.selectBeforeUpdate(Operator_ID);
                req.setAttribute("tOperator",tOperator);
                req.getRequestDispatcher("modifyOperator.jsp").forward(req,resp);
                break;
        }
    }
}
