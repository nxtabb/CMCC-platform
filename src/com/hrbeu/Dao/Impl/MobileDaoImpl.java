package com.hrbeu.Dao.Impl;

import com.hrbeu.Dao.MobileDao;
import com.hrbeu.Entity.TOperator;
import com.hrbeu.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MobileDaoImpl implements MobileDao {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public int addMobile(String kaleibie, List<Long> addNums) {
        connection = DBUtil.getConnection();
        int count =0;
        String sql = "insert into tmobiles(Mobile_Number,Mobile_Type,Is_Avaiable) values(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        for(long num:addNums){
            try {
                preparedStatement.setString(1,num+"");
                preparedStatement.setString(2,kaleibie);
                preparedStatement.setString(3,"Y");
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        DBUtil.realease(connection,preparedStatement,null);
        return addNums.size();
    }

    @Override
    public List<Long> queryAllMobiles() {
        connection = DBUtil.getConnection();
        List<Long> nums = new ArrayList<Long>();
        String sql = "select Mobile_Number from tmobiles ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String numStr = resultSet.getString(1);
                Long num = Long.parseLong(numStr);
                nums.add(num);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        DBUtil.realease(connection,preparedStatement,resultSet);
        return nums;
    }
}
