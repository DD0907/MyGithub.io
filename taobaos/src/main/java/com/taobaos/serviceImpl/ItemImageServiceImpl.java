package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.ItemImageMapper;
import com.taobaos.pojo.ItemImage;
import com.taobaos.pojo.ItemImageExample;
import com.taobaos.service.ItemImageService;

@Service
public class ItemImageServiceImpl implements ItemImageService {

	@Autowired
	ItemImageMapper imageMapper;

	@Override
	public int insertItemImage(ItemImage itemImage) {
		int result = imageMapper.insertSelective(itemImage);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateItemImage(ItemImage itemImage) {
		ItemImageExample example = new ItemImageExample();
		example.createCriteria().andItemIdEqualTo(itemImage.getItemId());
		int result = imageMapper.updateByExampleSelective(itemImage, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteItemImage(ItemImage itemImage) {
		ItemImageExample example = new ItemImageExample();
		example.createCriteria().andItemIdEqualTo(itemImage.getItemId());
		int result = imageMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<ItemImage> selectItemImageByItemId(Integer itemId) {
		ItemImageExample example = new ItemImageExample();
		example.createCriteria().andItemIdEqualTo(itemId);
		List<ItemImage> itemImages = imageMapper.selectByExample(example);
		if (itemImages.isEmpty()) {
			return null;
		} else {
			return itemImages;
		}
	}

	@Override
	public List<ItemImage> selectItemImageAll() {
		List<ItemImage> itemImages = imageMapper.selectByExample(null);
		if (itemImages.isEmpty()) {
			return null;
		} else {
			return itemImages;
		}
	}

}
