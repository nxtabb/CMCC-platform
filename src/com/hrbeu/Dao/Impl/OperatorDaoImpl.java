package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.OperatorDao;
import com.hrbeu.Entity.TOperator;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OperatorDaoImpl implements OperatorDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void addOperator(String Operator_ID, String Operator_Name, String Operator_Pwd, String Is_Admin) {
        connection = DBUtil.getConnection();
        String sql = "insert into toperator(Operator_ID,Operator_Name,Operator_Pwd,Is_Admin) values(?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Operator_ID);
            preparedStatement.setString(2,Operator_Name);
            preparedStatement.setString(3,Operator_Pwd);
            preparedStatement.setString(4,Is_Admin);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }

    @Override
    public List<String> queryAllId_ByAjax() {
        connection = DBUtil.getConnection();
        List<String> Ids =new ArrayList<String>();
        String sql = "select Operator_ID from toperator";
        String Operator_ID = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Operator_ID = resultSet.getString(1);
                Ids.add(Operator_ID);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
        return Ids;
    }

    @Override
    public TOperator selectBeforeUpdate(String Operator_ID) {
        connection = DBUtil.getConnection();
        TOperator tOperator = null;
        String sql = "select * from toperator where Operator_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Operator_ID);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Operator_ID = resultSet.getString(1);
                String Operator_Name = resultSet.getString(2);
                String Operator_Pwd = resultSet.getString(3);
                String Is_Admin = resultSet.getString(4);
                tOperator = new TOperator(Operator_ID,Operator_Name,Operator_Pwd,Is_Admin);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return tOperator;
    }

    @Override
    public void updateOperator(String operator_id, String operator_name, String operator_pwd, String is_admin) {
        connection = DBUtil.getConnection();
        String sql = "update toperator set Operator_Name=?,Operator_Pwd=?,Is_Admin=? where Operator_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4,operator_id);
            preparedStatement.setString(1,operator_name);
            preparedStatement.setString(2,operator_pwd);
            preparedStatement.setString(3,is_admin);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }
}
