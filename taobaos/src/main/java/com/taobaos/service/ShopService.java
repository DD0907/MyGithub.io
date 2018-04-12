package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Shop;

public interface ShopService {
	int insertShop(Shop shop);

	int updateShop(Shop shop);

	int deleteShop(Shop shop);
	
	int deleteShopStatus(Shop shop);

	Shop updateSelectShopByName(String name);
	
	List<Shop> selectShopByName(String name);

	List<Shop> selectShopAll();
}
