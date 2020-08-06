package com.hrbeu.Controller;

import com.hrbeu.Dao.Impl.MobileDaoImpl;
import com.hrbeu.Dao.MobileDao;
import com.hrbeu.Service.Impl.MobileServiceImpl;
import com.hrbeu.Service.MobileService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/mobile")
public class MobileController extends HttpServlet {
    MobileService mobileService = new MobileServiceImpl();
    MobileDao mobileDao =new MobileDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("resource.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String kaleibie = req.getParameter("R1");
        String from_numStr = req.getParameter("T1");
        String to_numStr = req.getParameter("T2");
        long from_num = Long.parseLong(from_numStr);
        long to_num = Long.parseLong(to_numStr);
        List<Long> nums= null;
        nums = mobileDao.queryAllMobiles();
        int count = mobileService.addMobile(kaleibie,from_num,to_num,nums);
        String success = "成功添加"+count+"个号码！";
        resp.getWriter().write(success);
    }
}
