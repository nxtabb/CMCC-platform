package com.hrbeu.Dao;

import java.util.List;

public interface MobileDao {
    List<Long> queryAllMobiles();
    int addMobile(String kaleibie, List<Long> addNums);
}
