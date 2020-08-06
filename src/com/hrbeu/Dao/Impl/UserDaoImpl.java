package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.UserDao;
import com.hrbeu.Entity.TAccount;
import com.hrbeu.Entity.TMobiles;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    @Override
    public TMobiles checkphone(String phone) {
        connection = DBUtil.getConnection();
        TMobiles tMobiles = null;
        String sql ="select * from tmobiles where Mobile_Number=? limit 1";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String type = resultSet.getString(2);
                String ava = resultSet.getString(3);
                tMobiles = new TMobiles(phone,type,ava);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return tMobiles;

    }

    @Override
    public TMobiles checkphone2(String phone) {
        connection = DBUtil.getConnection();
        TMobiles tMobiles = null;
        String sql ="select * from tuser where Mobile_Number=? limit 1";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,phone);
            resultSet = preparedStatement.executeQuery();
            int i=0;
            while (resultSet.next()){
                phone = resultSet.getString(2);
                tMobiles = new TMobiles(phone);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return tMobiles;
    }

    @Override
    public void addUser(String number, String manyou, String jibie, int id,String zhanghao) {
        connection = DBUtil.getConnection();
        int zhanghao_num = Integer.parseInt(zhanghao);
        String sql ="insert into tuser(Mobile_Number,Roaming_Status,Com_Level,Customer_ID,Account_ID) values (?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,number);
            preparedStatement.setString(2,manyou);
            preparedStatement.setString(3,jibie);
            preparedStatement.setInt(4,id);
            preparedStatement.setInt(5,zhanghao_num);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }

    @Override
    public TAccount checkzhanghao(String zhanghao, String password) {
        TAccount account =null;
        connection = DBUtil.getConnection();
        int zhanghao_num =Integer.parseInt(zhanghao);
        String sql ="select * from taccount where Account_ID=? and password=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,zhanghao_num);
            preparedStatement.setString(2,password);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String password_sel = resultSet.getString(5);
                account = new TAccount(id+"",password_sel);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return account;
    }

    @Override
    public List<Double> queryFee() {
        connection = DBUtil.getConnection();
        List<Double> fees = new ArrayList<Double>();
        String sql = "select Charge from tcharge where Charge_Code in (select Charge_Code from tcharge_rule where Rule_ID=?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"O");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                double fee = resultSet.getDouble(1);
                fees.add(fee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
        return fees;
    }

    @Override
    public boolean checkMoney(int zhanghao_num, int count) {
        TAccount tAccount = null;
        connection =DBUtil.getConnection();
        String sql = "select * from taccount where Account_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,zhanghao_num);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String Contact_Person = resultSet.getString(2);
                String Contact_Address = resultSet.getString(3);
                double Account_Balance = resultSet.getDouble(4);
                String password = resultSet.getString(5);
                tAccount = new TAccount(zhanghao_num+"",Contact_Person,Contact_Address,Account_Balance,password);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        if(tAccount.getAccount_Balance()<count){
            return false;
        }
        else {
            return true;
        }

    }

    @Override
    public void minusMoney(int zhanghao_num, int count) {
        connection = DBUtil.getConnection();
        try {
            connection.setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String sql = "update taccount set Account_Balance=Account_Balance-? where Account_ID=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,count);
            preparedStatement.setInt(2,zhanghao_num);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,null);
    }


}
