package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.ItemMapper;
import com.taobaos.pojo.Item;
import com.taobaos.pojo.ItemExample;
import com.taobaos.service.ItemService;
import com.taobaos.util.DBUtil;

public class ItemServiceImpl implements ItemService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertItem(Item item) {
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
		int result = itemMapper.insertSelective(item);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateItem(Item item) {
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
		ItemExample example = new ItemExample();
		example.createCriteria().andNameEqualTo(item.getName());
		int result = itemMapper.updateByExampleWithBLOBs(item, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteItem(Item item) {
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
		ItemExample example = new ItemExample();
		example.createCriteria().andNameEqualTo(item.getName());
		int result = itemMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<Item> selectItemByName(String name) {
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
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
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
		List<Item> items = itemMapper.selectByExampleWithBLOBs(null);
		if (items.isEmpty()) {
			return null;
		}
		return items;
	}

	@Override
	public Item selectItemByNames(String name) {
		ItemMapper itemMapper = session.getMapper(ItemMapper.class);
		Item item = itemMapper.selectItemByNames(name);
		if (item != null) {
			return item;
		}
		return null;
	}
}
