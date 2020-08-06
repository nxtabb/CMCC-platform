package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.LoginDao;
import com.hrbeu.Entity.TOperator;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    @Override
    public TOperator login(String Operator_ID, String Operator_Pwd) {
        connection = DBUtil.getConnection();
        TOperator tOperator = null;
        String sql = "select * from toperator where Operator_ID=? and Operator_Pwd=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Operator_ID);
            preparedStatement.setString(2,Operator_Pwd);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Operator_ID = resultSet.getString(1);
                String name = resultSet.getString(2);
                Operator_Pwd = resultSet.getString(3);
                String Is_Admin = resultSet.getString(4);
                tOperator = new TOperator(Operator_ID,name,Operator_Pwd,Is_Admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return tOperator;
    }
}
