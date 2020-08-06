package com.hrbeu.Controller;

import com.hrbeu.Service.Impl.OperatorServiceImpl;
import com.hrbeu.Service.OperatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/check_form")
public class Check_formController extends HttpServlet {
    OperatorService operatorService = new OperatorServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Operator_ID = req.getParameter("Operator_ID");
        List<String> IDS = operatorService.queryAllId_ByAjax();
        int count = Collections.frequency(IDS,Operator_ID);
        if(count==0){
            resp.getWriter().write("true");
        }
        else {
            resp.getWriter().write("false");
        }

    }
}
