package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.ItemImage;

public interface ItemImageService {
	int insertItemImage(ItemImage itemImage);

	int updateItemImage(ItemImage itemImage);

	int deleteItemImage(ItemImage itemImage);

	List<ItemImage> selectItemImageByItemId(Integer itemId);

	List<ItemImage> selectItemImageAll();
}
