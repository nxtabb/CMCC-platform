package com.hrbeu.Controller;

import com.hrbeu.Entity.TCustomer;
import com.hrbeu.Service.CustomerService;
import com.hrbeu.Service.Impl.CustomerServiceImpl;
import com.hrbeu.Service.Impl.UserServiceImpl;
import com.hrbeu.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/newUser")
public class UserController  extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String step = req.getParameter("step");
        switch (step){
            case "custouser":
                String Customer_Name= req.getParameter("name");
                String zhengjian = req.getParameter("zhengjian");
                String idcode = req.getParameter("idcode");
                String sex = req.getParameter("sex");
                String birthday = req.getParameter("birthday");
                String address = req.getParameter("address");
                TCustomer tCustomer = customerService.selectcustomerByID(idcode,zhengjian);
                //新增
                if(tCustomer==null){
                    customerService.addCustmoer(zhengjian,idcode,Customer_Name,birthday,sex,address);
                }
                //修改
                else {
                    customerService.updateCustomer(zhengjian,idcode,Customer_Name,birthday,sex,address);

                }
                int id = customerService.selectIDByCode(idcode,zhengjian);
                req.setAttribute("id",id);
                req.getRequestDispatcher("newUser.jsp").forward(req,resp);
                break;
            case "checkphone":
                String phone = req.getParameter("phone");
                int canbuild = userService.checkphone(phone);
                int canbuild2 = userService.checkphone2(phone);
                if(canbuild==0){
                    resp.getWriter().write("号码不在范围");
                }
                else if(canbuild2==0){
                    resp.getWriter().write("号码已使用");
                }
                else {
                    resp.getWriter().write("该号码可以使用");
                }
                break;
            case "addUser":
                String number = req.getParameter("phone");
                String manyou = req.getParameter("manyou");
                String jibie = req.getParameter("jibie");
                String idStr = req.getParameter("id");
                String zhanghao = req.getParameter("zhanghao");
                id = Integer.parseInt(idStr);
                userService.addUser(number,manyou,jibie,id,zhanghao);
                resp.sendRedirect("");
                break;
            case "checkzhanghao":
                zhanghao = req.getParameter("zhanghao");
                String password = req.getParameter("password");
                int access = userService.checkzhanghao(zhanghao,password);
                if(access==0){
                    resp.getWriter().write("账号不存在或密码错误");
                }
                else {
                    resp.getWriter().write("账号可以使用");
                }
                break;
            case "final":
                zhanghao = req.getParameter("zhanghao");
                int zhanghao_num = Integer.parseInt(zhanghao);
                int moneyisok = userService.checkMoney(zhanghao_num);
                if(moneyisok==1){
                    resp.getWriter().write("添加成功");
                }
                else {
                    resp.getWriter().write("余额不足,添加失败");
                }

        }
    }
}
