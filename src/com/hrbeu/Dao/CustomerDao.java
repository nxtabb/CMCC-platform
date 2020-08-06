package com.hrbeu.Dao;

import com.hrbeu.Entity.TCustomer;

public interface CustomerDao {
    TCustomer selectcustomerByID(String idcode,String zhengjian);
    void addCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address);
    void updateCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address);
    int selectIDByCode(String idcode, String zhengjian);
}
