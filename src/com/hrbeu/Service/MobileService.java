package com.hrbeu.Service;

import java.util.List;

public interface MobileService {
    int addMobile(String kaleibie, long from_num, long to_num, List<Long> nums);
}
