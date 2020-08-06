package com.hrbeu.Controller;

import com.hrbeu.Entity.TCustomer;
import com.hrbeu.Service.CustomerService;
import com.hrbeu.Service.Impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/customer2")
public class Customer2Controller extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idcode = (String) req.getAttribute("idcode");
        String zhengjian = (String) req.getAttribute("zhengjian");
        TCustomer customer = customerService.selectcustomerByID(idcode,zhengjian);
        req.setAttribute("customer",customer);
        req.getRequestDispatcher("NewCustomer2.jsp").forward(req,resp);
    }
}
