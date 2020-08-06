package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.Impl.OperatorDaoImpl;
import com.hrbeu.Dao.OperatorDao;
import com.hrbeu.Entity.TOperator;
import com.hrbeu.Service.OperatorService;

import java.util.List;

public class OperatorServiceImpl implements OperatorService {
    OperatorDao operatorDao = new OperatorDaoImpl();
    @Override
    public void addOperator(String Operator_ID, String Operator_Name, String Operator_Pwd, String Is_Admin) {
        operatorDao.addOperator(Operator_ID,Operator_Name,Operator_Pwd,Is_Admin);
    }

    @Override
    public List<String> queryAllId_ByAjax() {
        return operatorDao.queryAllId_ByAjax();
    }

    @Override
    public TOperator selectBeforeUpdate(String operator_id) {
        return operatorDao.selectBeforeUpdate(operator_id);

    }

    @Override
    public void updateOperator(String operator_id, String operator_name, String operator_pwd, String is_admin) {
        operatorDao.updateOperator(operator_id,operator_name,operator_pwd,is_admin);
    }
}
