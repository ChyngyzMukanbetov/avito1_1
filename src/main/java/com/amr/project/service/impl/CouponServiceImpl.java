package com.amr.project.service.impl;

import com.amr.project.dao.abstracts.ReadWriteDao;
import com.amr.project.model.entity.Coupon;
import com.amr.project.service.abstracts.CouponService;
import org.springframework.stereotype.Service;

@Service
public class CouponServiceImpl extends ReadWriteServiceImpl<Coupon, Long> implements CouponService {
    public CouponServiceImpl(ReadWriteDao<Coupon, Long> dao) {
        super(dao);
    }
}
