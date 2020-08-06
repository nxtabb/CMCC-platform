package com.hrbeu.Service;

import java.util.List;

public interface ChargeService {
    void updateCharge1(String Charge_Code,double charge);
    int querybeforeCharge1(String Charge_Code);
    void updateCharge2(String[] check_box);
    List<String> querybeforeCharge2();
}
