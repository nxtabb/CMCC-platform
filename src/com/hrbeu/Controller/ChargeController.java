package com.hrbeu.Controller;

import com.hrbeu.Service.ChargeService;
import com.hrbeu.Service.Impl.ChargeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/charge")
public class ChargeController extends HttpServlet {
    ChargeService chargeService = new ChargeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = chargeService.querybeforeCharge2();
        req.setAttribute("list",list);
        req.getRequestDispatcher("charge.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        switch (method){
            case "charge1":
                String content = req.getParameter("D1");
                String ChargeStr = req.getParameter("Charge");
                double charge = Double.parseDouble(ChargeStr);
                chargeService.updateCharge1(content,charge);
                resp.sendRedirect("/charge");
                break;
            case "charge2":
                String[] check_box = req.getParameterValues("C1");
                chargeService.updateCharge2(check_box);
                resp.sendRedirect("/charge");
            case "ajax1":
                String Charge_Code = req.getParameter("D1");
                int money = chargeService.querybeforeCharge1(Charge_Code);
                resp.getWriter().write(money+"");
                break;
        }
    }
}
