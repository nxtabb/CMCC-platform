package com.hrbeu.Controller;

import com.hrbeu.Entity.TCustomer;
import com.hrbeu.Service.CustomerService;
import com.hrbeu.Service.Impl.CustomerServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/customer")
public class CustomerController extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stepStr = req.getParameter("step");
        switch (stepStr){
            case "1":
                resp.sendRedirect("NewCustomer.jsp");
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stepStr = req.getParameter("step");
        switch (stepStr){
            case "1":
                String zhengjian = req.getParameter("zhengjian");
                String idcode = req.getParameter("idcode");
                req.setAttribute("zhengjian",zhengjian);
                req.setAttribute("idcode",idcode);
                req.getRequestDispatcher("/customer2").forward(req,resp);
                break;
        }
    }


}
