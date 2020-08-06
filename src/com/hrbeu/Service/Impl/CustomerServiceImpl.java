package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.CustomerDao;
import com.hrbeu.Dao.Impl.CustomerDaoImpl;
import com.hrbeu.Entity.TCustomer;
import com.hrbeu.Service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Override
    public TCustomer selectcustomerByID(String idcode,String zhengjian) {
        return customerDao.selectcustomerByID(idcode,zhengjian);
    }

    @Override
    public void addCustmoer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address) {
        customerDao.addCustomer(zhengjian,idcode,customer_name,birthday,sex,address);
    }

    @Override
    public void updateCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address) {
        customerDao.updateCustomer(zhengjian,idcode,customer_name,birthday,sex,address);
    }

    @Override
    public int selectIDByCode(String idcode, String zhengjian) {
        return customerDao.selectIDByCode(idcode,zhengjian);
    }
}
