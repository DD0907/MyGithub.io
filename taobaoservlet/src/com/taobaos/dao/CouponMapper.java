package com.taobaos.dao;

import com.taobaos.pojo.Coupon;
import com.taobaos.pojo.CouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {

	//<!-- 把优惠券的状态改为0 -->
	int deleteCouponStatus(Coupon coupon);

	Coupon selectCouponByNames(String name);

	long countByExample(CouponExample example);

	int deleteByExample(CouponExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Coupon record);

	int insertSelective(Coupon record);

	List<Coupon> selectByExample(CouponExample example);

	Coupon selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

	int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

	int updateByPrimaryKeySelective(Coupon record);

	int updateByPrimaryKey(Coupon record);
}