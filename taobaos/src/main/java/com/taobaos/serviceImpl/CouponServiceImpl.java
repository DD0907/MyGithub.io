package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.CouponMapper;
import com.taobaos.pojo.Coupon;
import com.taobaos.pojo.CouponExample;
import com.taobaos.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService {
	@Autowired
	CouponMapper couponMapper;

	@Override
	public int insertCoupon(Coupon coupon) {
		int result = couponMapper.insertSelective(coupon);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateCoupon(Coupon coupon) {
		CouponExample example = new CouponExample();
		example.createCriteria().andNameEqualTo(coupon.getName());
		int result = couponMapper.updateByExampleSelective(coupon, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteCoupon(Coupon coupon) {
		CouponExample example = new CouponExample();
		example.createCriteria().andNameEqualTo(coupon.getName());
		int result = couponMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteCouponStatus(Coupon coupon) {
		int result = couponMapper.deleteCouponStatus(coupon);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Coupon selectCouponByNames(String name) {
		Coupon coupon = couponMapper.selectCouponByNames(name);
		if (coupon != null) {
			return coupon;
		}
		return null;
	}

	@Override
	public List<Coupon> selectCouponByName(String name) {
		CouponExample example = new CouponExample();
		example.createCriteria().andNameEqualTo(name);
		List<Coupon> cList = couponMapper.selectByExample(example);
		if (cList.isEmpty()) {
			return null;
		}
		return cList;
	}

	@Override
	public List<Coupon> selectCouponAll() {
		List<Coupon> cList = couponMapper.selectByExample(null);
		if (cList.isEmpty()) {
			return null;
		}
		return cList;
	}

}
