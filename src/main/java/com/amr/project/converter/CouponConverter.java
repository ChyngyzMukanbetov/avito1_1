package com.amr.project.converter;

import com.amr.project.model.entity.Coupon;
import org.mapstruct.Mapper;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponConverter {

    default List<Long> mapLongtoList(List<Coupon> coupons) {
        if (coupons !=null) {
            List<Long> listCouponIds = new ArrayList<>(coupons.size());
            for (Coupon coupon : coupons) {
                listCouponIds.add(coupon.getId());
            }
            return listCouponIds;
        } else {
            return null;
        }
    }
}
