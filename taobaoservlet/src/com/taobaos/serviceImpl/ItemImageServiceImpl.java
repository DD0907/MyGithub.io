package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.ItemImageMapper;
import com.taobaos.pojo.ItemImage;
import com.taobaos.pojo.ItemImageExample;
import com.taobaos.service.ItemImageService;
import com.taobaos.util.DBUtil;

public class ItemImageServiceImpl implements ItemImageService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertItemImage(ItemImage itemImage) {
		ItemImageMapper imageMapper = session.getMapper(ItemImageMapper.class);
		int result = imageMapper.insertSelective(itemImage);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateItemImage(ItemImage itemImage) {
		ItemImageMapper imageMapper = session.getMapper(ItemImageMapper.class);
		ItemImageExample example = new ItemImageExample();
		example.createCriteria().andItemIdEqualTo(itemImage.getItemId());
		int result = imageMapper.updateByExampleSelective(itemImage, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteItemImage(ItemImage itemImage) {
		ItemImageMapper imageMapper = session.getMapper(ItemImageMapper.class);
		ItemImageExample example = new ItemImageExample();
		example.createCriteria().andItemIdEqualTo(itemImage.getItemId());
		int result = imageMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<ItemImage> selectItemImageByItemId(Integer itemId) {
		ItemImageMapper imageMapper = session.getMapper(ItemImageMapper.class);
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
		ItemImageMapper imageMapper = session.getMapper(ItemImageMapper.class);
		List<ItemImage> itemImages = imageMapper.selectByExample(null);
		if (itemImages.isEmpty()) {
			return null;
		} else {
			return itemImages;
		}
	}

}
