package com.hrbeu.Dao;

import com.hrbeu.Entity.TAccount;
import com.hrbeu.Entity.TMobiles;

import java.util.List;

public interface UserDao {
    TMobiles checkphone(String phone);
    TMobiles checkphone2(String phone);
    void addUser(String number, String manyou, String jibie, int id,String zhanghao);
    TAccount checkzhanghao(String zhanghao, String password);

    List<Double> queryFee();
    boolean checkMoney(int zhanghao_num, int count);
    void minusMoney(int zhanghao_num, int count);
}
