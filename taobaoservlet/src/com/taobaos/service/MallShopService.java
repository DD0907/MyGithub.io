package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.MallShop;

public interface MallShopService {
	int insertMallShop(MallShop mallShop);

	int updateMallShop(MallShop mallShop);

	int deleteMallShop(MallShop mallShop);

	List<MallShop> selectMallShopByMallId(Integer mallId);

	List<MallShop> selectMallShopAll();
}
