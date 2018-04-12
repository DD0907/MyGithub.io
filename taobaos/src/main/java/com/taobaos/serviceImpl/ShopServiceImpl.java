package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.ShopMapper;
import com.taobaos.pojo.Shop;
import com.taobaos.pojo.ShopExample;
import com.taobaos.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	ShopMapper shopMapper;

	@Override
	public int insertShop(Shop shop) {
		int result = shopMapper.insert(shop);
		return result;
	}

	@Override
	public int updateShop(Shop shop) {
		ShopExample example = new ShopExample();
		example.createCriteria().andNameEqualTo(shop.getName());
		int result = shopMapper.updateByExampleWithBLOBs(shop, example);
		return result;
	}

	@Override
	public int deleteShop(Shop shop) {
		ShopExample example = new ShopExample();
		example.createCriteria().andNameEqualTo(shop.getName());
		int result = shopMapper.deleteByExample(example);
		return result;
	}

	@Override
	public List<Shop> selectShopByName(String name) {
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
		List<Shop> shops = shopMapper.selectByExampleWithBLOBs(null);
		if (shops.isEmpty()) {
			return null;
		} else {
			return shops;
		}
	}

	@Override
	public int deleteShopStatus(Shop shop) {
		int result = shopMapper.deleteShopStatus(shop);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Shop updateSelectShopByName(String name) {
		Shop shop = shopMapper.updateSelectShopByName(name);
		if (shop != null) {
			return shop;
		}
		return null;
	}
}
