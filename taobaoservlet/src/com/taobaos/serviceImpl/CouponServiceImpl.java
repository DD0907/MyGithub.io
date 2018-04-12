package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.CouponMapper;
import com.taobaos.pojo.Coupon;
import com.taobaos.pojo.CouponExample;
import com.taobaos.service.CouponService;
import com.taobaos.util.DBUtil;

public class CouponServiceImpl implements CouponService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertCoupon(Coupon coupon) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		int result = couponMapper.insertSelective(coupon);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateCoupon(Coupon coupon) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		CouponExample example = new CouponExample();
		example.createCriteria().andNameEqualTo(coupon.getName());
		int result = couponMapper.updateByExampleSelective(coupon, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteCoupon(Coupon coupon) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		CouponExample example = new CouponExample();
		example.createCriteria().andNameEqualTo(coupon.getName());
		int result = couponMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteCouponStatus(Coupon coupon) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		int result = couponMapper.deleteCouponStatus(coupon);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Coupon selectCouponByNames(String name) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		Coupon coupon = couponMapper.selectCouponByNames(name);
		if (coupon != null) {
			return coupon;
		}
		return null;
	}

	@Override
	public List<Coupon> selectCouponByName(String name) {
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
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
		CouponMapper couponMapper = session.getMapper(CouponMapper.class);
		List<Coupon> cList = couponMapper.selectByExample(null);
		if (cList.isEmpty()) {
			return null;
		}
		return cList;
	}

}
