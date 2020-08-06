package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.ChargeDao;
import com.hrbeu.Dao.Impl.ChargeDaoImpl;
import com.hrbeu.Service.ChargeService;

import java.util.List;

public class ChargeServiceImpl implements ChargeService {
    ChargeDao chargeDao = new ChargeDaoImpl();
    @Override
    public void updateCharge1(String Charge_Code, double charge) {
        String Charge_Name = null;
        switch (Charge_Code){
            case "A":
                Charge_Name = "开户费";
                break;
            case "B":
                Charge_Name = "漫游费";
                break;
            case "C":
                Charge_Name = "押金";
                break;
            case "D":
                Charge_Name = "入网费";
                break;
            case "E":
                Charge_Name = "选号费";
                break;
        }
        chargeDao.updateCharge1(Charge_Code,Charge_Name,charge);

    }

    @Override
    public int querybeforeCharge1(String Charge_Code) {
        return chargeDao.querybeforeCharge1(Charge_Code);
    }

    @Override
    public void updateCharge2(String[] check_box) {
        chargeDao.updateCharge2(check_box);
    }

    @Override
    public List<String> querybeforeCharge2() {
        return chargeDao.querybeforeCharge2();
    }


}
