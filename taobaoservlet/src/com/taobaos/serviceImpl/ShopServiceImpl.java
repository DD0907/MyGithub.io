package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.ShopMapper;
import com.taobaos.pojo.Shop;
import com.taobaos.pojo.ShopExample;
import com.taobaos.service.ShopService;
import com.taobaos.util.DBUtil;

public class ShopServiceImpl implements ShopService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertShop(Shop shop) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		int result = shopMapper.insert(shop);
		session.commit();
		return result;
	}

	@Override
	public int updateShop(Shop shop) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		ShopExample example = new ShopExample();
		example.createCriteria().andNameEqualTo(shop.getName());
		int result=shopMapper.updateByExampleWithBLOBs(shop,example);
		session.commit();
		return result;
	}

	@Override
	public int deleteShop(Shop shop) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		ShopExample example = new ShopExample();
		example.createCriteria().andNameEqualTo(shop.getName());
		int result = shopMapper.deleteByExample(example);
		session.commit();
		return result;
	}

	@Override
	public List<Shop> selectShopByName(String name) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		ShopExample example = new ShopExample();
		example.createCriteria().andNameEqualTo(name);
		List<Shop> shop = shopMapper.selectByExample(example);
		if (shop.isEmpty()) {
			return null;
		} else {
			return shop;
		}
	}

	@Override
	public List<Shop> selectShopAll() {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		List<Shop> shops = shopMapper.selectByExampleWithBLOBs(null);
		if (shops.isEmpty()) {
			return null;
		} else {
			return shops;
		}
	}

	@Override
	public int deleteShopStatus(Shop shop) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		int result = shopMapper.deleteShopStatus(shop);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Shop updateSelectShopByName(String name) {
		ShopMapper shopMapper = session.getMapper(ShopMapper.class);
		Shop shop=shopMapper.updateSelectShopByName(name);
		session.commit();
		if (shop!=null) {
			return shop;
		}
		return null;
	}
}
