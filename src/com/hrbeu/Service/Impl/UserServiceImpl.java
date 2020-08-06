package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.Impl.UserDaoImpl;
import com.hrbeu.Dao.UserDao;
import com.hrbeu.Entity.TAccount;
import com.hrbeu.Entity.TMobiles;
import com.hrbeu.Service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public int checkphone(String phone) {
        TMobiles mobiles = userDao.checkphone(phone);
        if(mobiles==null){
            return 0;
        }
        else return 1;
    }

    @Override
    public int checkphone2(String phone) {
        TMobiles mobiles = userDao.checkphone2(phone);
        if(mobiles==null){
            return 1;
        }
        else return 0;
    }

    @Override
    public void addUser(String number, String manyou, String jibie, int id,String zhanghao) {
        userDao.addUser(number,manyou,jibie,id,zhanghao);
    }

    @Override
    public int checkzhanghao(String zhanghao, String password) {
        TAccount account = userDao.checkzhanghao(zhanghao,password);
        if(account==null){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int checkMoney(int zhanghao_num) {
        List<Double> moneys = userDao.queryFee();
        int count =0;
        for(double fee:moneys){
            count+=fee;
        }
        boolean flag = userDao.checkMoney(zhanghao_num,count);
        if(flag){

            userDao.minusMoney(zhanghao_num,count);
            return 1;
        }
        else {
            return 0;
        }
    }
}
