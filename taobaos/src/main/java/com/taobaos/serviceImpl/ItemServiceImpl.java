package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.ItemMapper;
import com.taobaos.pojo.Item;
import com.taobaos.pojo.ItemExample;
import com.taobaos.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemMapper itemMapper;

	@Override
	public int insertItem(Item item) {
		int result = itemMapper.insertSelective(item);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		ItemExample example = new ItemExample();
		example.createCriteria().andNameEqualTo(item.getName());
		int result = itemMapper.updateByExampleWithBLOBs(item, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteItem(Item item) {
		ItemExample example = new ItemExample();
		example.createCriteria().andNameEqualTo(item.getName());
		int result = itemMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<Item> selectItemByName(String name) {
		ItemExample example = new ItemExample();
		example.createCriteria().andNameEqualTo(name);
		List<Item> items = itemMapper.selectByExampleWithBLOBs(example);
		if (items.isEmpty()) {
			return null;
		}
		return items;
	}

	@Override
	public List<Item> selectItemAll() {
		List<Item> items = itemMapper.selectByExampleWithBLOBs(null);
		if (items.isEmpty()) {
			return null;
		}
		return items;
	}

	@Override
	public Item selectItemByNames(String name) {
		Item item = itemMapper.selectItemByNames(name);
		if (item != null) {
			return item;
		}
		return null;
	}
}
