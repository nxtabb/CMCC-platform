package com.hrbeu.Dao;

import com.hrbeu.Entity.TOperator;

public interface LoginDao {
    TOperator login(String username,String password);
}
