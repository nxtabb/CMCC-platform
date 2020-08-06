package com.hrbeu.Dao;

import java.util.List;

public interface ChargeDao {
    void updateCharge1(String Charge_Code,String Charge_name,double Charge);
    int querybeforeCharge1(String Charge_Code);
    void updateCharge2(String[] check_box);
    List<String> querybeforeCharge2();
}
