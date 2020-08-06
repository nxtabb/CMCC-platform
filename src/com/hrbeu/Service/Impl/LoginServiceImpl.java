package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.Impl.LoginDaoImpl;
import com.hrbeu.Dao.LoginDao;
import com.hrbeu.Entity.TOperator;
import com.hrbeu.Service.LoginService;

public class LoginServiceImpl implements LoginService {
    LoginDao loginDao = new LoginDaoImpl();
    @Override
    public TOperator login(String Operator_ID, String Operator_Pwd) {
        return loginDao.login(Operator_ID,Operator_Pwd);
    }
}
