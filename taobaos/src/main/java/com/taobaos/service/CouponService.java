package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Coupon;

public interface CouponService {
	int insertCoupon(Coupon coupon);

	int updateCoupon(Coupon coupon);

	int deleteCoupon(Coupon coupon);
	
//	<!-- 把优惠券的状态改为0 -->
	int deleteCouponStatus(Coupon coupon);

	Coupon selectCouponByNames(String name);

	List<Coupon> selectCouponByName(String name);

	List<Coupon> selectCouponAll();
}
