package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Mall;

public interface MallServie {
	int insertMall(Mall mall);

	int updateMall(Mall mall);

	int deleteMall(Mall mall);

	int deleteMallStatus(Mall mall);

	Mall updateSelectMallByName(String name);

	List<Mall> selectMallByName(String name);

	List<Mall> selectMallAll();
}
