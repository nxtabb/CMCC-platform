package com.hrbeu.Service;

public interface UserService {
    int checkphone(String phone);
    int checkphone2(String phone);
    void addUser(String number, String manyou, String jibie, int id,String zhanghao);
    int checkzhanghao(String zhanghao, String password);
    int checkMoney(int zhanghao_num);
}
