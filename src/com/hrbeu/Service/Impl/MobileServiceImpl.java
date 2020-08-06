package com.hrbeu.Service.Impl;

import com.hrbeu.Dao.Impl.MobileDaoImpl;
import com.hrbeu.Dao.MobileDao;
import com.hrbeu.Service.MobileService;

import java.util.ArrayList;
import java.util.List;

public class MobileServiceImpl implements MobileService {
    MobileDao mobileDao = new MobileDaoImpl();

    @Override
    public int addMobile(String kaleibie, long from_num, long to_num, List<Long> nums) {
        List<Long> addNums = new ArrayList<Long>();
        for(long i=from_num;i<=to_num;i++){
            addNums.add(i);
        }
        addNums.removeAll(nums);
        return mobileDao.addMobile(kaleibie,addNums);
    }
}
