package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.CustomerDao;
import com.hrbeu.Entity.TCustomer;
import com.hrbeu.Util.DBUtil;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class CustomerDaoImpl implements CustomerDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    @Override
    public TCustomer selectcustomerByID(String idcode,String zhengjian) {
        connection = DBUtil.getConnection();
        TCustomer tCustomer = null;
        String sql = "select * from tcustomer where ID_Number=? and ID_Type=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idcode);
            preparedStatement.setString(2,zhengjian);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int Customer_ID = resultSet.getInt(1);
                String ID_Type =  resultSet.getString(2);
                String  Customer_Name = resultSet.getString(4);
                Date Customer_Birthday = resultSet.getDate(5);
                String Customer_sex = resultSet.getString(6);
                String  Customer_Address = resultSet.getString(7);
                tCustomer = new TCustomer(Customer_ID,ID_Type, idcode,Customer_Name,Customer_Birthday,Customer_sex,Customer_Address);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return tCustomer;
    }

    @Override
    public void addCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address) {
        connection = DBUtil.getConnection();
        String sql ="insert into tcustomer(ID_Type,ID_Number,Customer_Name,Customer_Birthday,Customer_Sex,Customer_Address) values(?,?,?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,zhengjian);
            preparedStatement.setString(2,idcode);
            preparedStatement.setString(3,customer_name);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday_date = simpleDateFormat.parse(birthday);
            preparedStatement.setDate(4, new java.sql.Date(birthday_date.getTime()));
            preparedStatement.setString(5,sex);
            preparedStatement.setString(6,address);
            preparedStatement.executeUpdate();
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
    }

    @Override
    public void updateCustomer(String zhengjian, String idcode, String customer_name, String birthday, String sex, String address) {
        connection = DBUtil.getConnection();
        String sql ="update tcustomer set Customer_Name=?,Customer_Birthday=?,Customer_Sex=?,Customer_Address=? where ID_Type=? and ID_Number=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(5,zhengjian);
            preparedStatement.setString(6,idcode);
            preparedStatement.setString(1,customer_name);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthday_date = simpleDateFormat.parse(birthday);
            preparedStatement.setDate(2, new java.sql.Date(birthday_date.getTime()));
            preparedStatement.setString(3,sex);
            preparedStatement.setString(4,address);
            preparedStatement.executeUpdate();
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
    }

    @Override
    public int selectIDByCode(String idcode, String zhengjian) {
        connection = DBUtil.getConnection();
        int id =0;
        String sql ="select Customer_ID from tcustomer where ID_Number=? and ID_Type=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,idcode);
            preparedStatement.setString(2,zhengjian);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                id = resultSet.getInt(1);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return id;
    }
}
