package com.hrbeu.Service;

import com.hrbeu.Entity.TCustomer;

public interface CustomerService {
    TCustomer selectcustomerByID(String idcode,String zhengjian);
    void addCustmoer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address);
    void updateCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address);
    int selectIDByCode(String idcode, String zhengjian);
}
