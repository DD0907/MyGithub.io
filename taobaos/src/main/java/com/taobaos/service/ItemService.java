package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Item;

public interface ItemService {
	int insertItem(Item item);

	int updateItem(Item item);

	int deleteItem(Item item);

	Item selectItemByNames(String name);
	
	List<Item> selectItemByName(String name);

	List<Item> selectItemAll();
}
