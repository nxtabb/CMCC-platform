package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.ChargeDao;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChargeDaoImpl implements ChargeDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public void updateCharge1(String Charge_Code, String Charge_name, double Charge) {
        connection = DBUtil.getConnection();
        String sql = "update tcharge set Charge_Name=?,Charge=? where Charge_Code=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Charge_name);
            preparedStatement.setDouble(2,Charge);
            preparedStatement.setString(3,Charge_Code);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }

    @Override
    public int querybeforeCharge1(String Charge_Code) {
        connection = DBUtil.getConnection();
        int count =0;
        String sql = "select Charge from tcharge where Charge_Code=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,Charge_Code);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                count =(int)resultSet.getDouble(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
        return count;
    }

    @Override
    public void updateCharge2(String[] check_box) {
        Map<String,String> charge = new HashMap<String, String>();
        charge.put("A","开户");
        charge.put("B","漫游费");
        charge.put("C","押金");
        charge.put("D","入网费");
        charge.put("E","选号费");
        connection = DBUtil.getConnection();
        String sql1 = "delete from tcharge_rule";
        try {
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.executeUpdate();
            String sql2 = "insert into tcharge_rule(Rule_ID,Func_Name,Charge_Code) values(?,?,?)";
            for(String check:check_box){
                preparedStatement = connection.prepareStatement(sql2);
                preparedStatement.setString(1,"O");
                preparedStatement.setString(2,charge.get(check));
                preparedStatement.setString(3,check);
                preparedStatement.executeUpdate();
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }

    @Override
    public List<String> querybeforeCharge2() {
        List<String> list = new ArrayList<String>();
        connection = DBUtil.getConnection();
        String sql = "select Charge_Code from tcharge_rule where Rule_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"O");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String Charge_Code = resultSet.getString(1);
                list.add(Charge_Code);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return list;
    }
}
