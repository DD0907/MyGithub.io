package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TYuanquMapper;
import com.entranceGuard.pojo.TYuanqu;
import com.entranceGuard.pojo.TYuanquExample;
import com.entranceGuard.service.TYuanquService;

@Service
public class TYuanquServiceImpl implements TYuanquService {
	@Autowired
	TYuanquMapper tYuanquMapper;

	@Override
	public int insert(TYuanqu tYuanqu) {
		int result = tYuanquMapper.insertSelective(tYuanqu);
		return result;
	}

	@Override
	public int update(TYuanqu tYuanqu) {
		TYuanquExample example = new TYuanquExample();
		example.createCriteria().andYuanquidEqualTo(tYuanqu.getYuanquid());
		int result = tYuanquMapper.updateByExampleSelective(tYuanqu, example);
		return result;
	}

	@Override
	public int delete(TYuanqu tYuanqu) {
		int result = tYuanquMapper.deleteByPrimaryKey(tYuanqu.getYuanquid());
		return result;
	}

	@Override
	public TYuanqu selectTYuanquById(String yuanquname) {

		return null;
	}

	@Override
	public List<TYuanqu> selectTYuanquAll() {
		List<TYuanqu> tYuanqus = tYuanquMapper.selectByExample(null);
		if (tYuanqus.isEmpty()) {
			return null;
		}
		return tYuanqus;
	}

	@Override
	public List<TYuanqu> selectTYuanquByIds(String yuanquname) {
		TYuanquExample example = new TYuanquExample();
		example.createCriteria().andYuanqunameEqualTo(yuanquname);
		List<TYuanqu> tYuanqus = tYuanquMapper.selectByExample(example);
		if (tYuanqus.isEmpty()) {
			return null;
		}
		return tYuanqus;
	}

}
