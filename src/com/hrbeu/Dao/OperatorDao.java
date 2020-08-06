package com.hrbeu.Dao;

import com.hrbeu.Entity.TOperator;

import java.util.List;

public interface OperatorDao {
    void addOperator(String Operator_ID,String Operator_Name,String Operator_Pwd,String Is_Admin);
    List<String> queryAllId_ByAjax();
    TOperator selectBeforeUpdate(String Operator_ID);
    void updateOperator(String operator_id, String operator_name, String operator_pwd, String is_admin);
}
