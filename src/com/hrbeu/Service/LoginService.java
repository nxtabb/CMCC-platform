package com.hrbeu.Service;

import com.hrbeu.Entity.TOperator;

public interface LoginService {
    TOperator login(String Operator_ID,String Operator_Pwd);
}
