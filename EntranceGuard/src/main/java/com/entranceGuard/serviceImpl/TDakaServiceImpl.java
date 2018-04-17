package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TDakaMapper;
import com.entranceGuard.pojo.TDaka;
import com.entranceGuard.pojo.TDakaExample;
import com.entranceGuard.service.TDakaService;

@Service
public class TDakaServiceImpl implements TDakaService {
	@Autowired
	TDakaMapper tDakaMapper;

	@Override
	public int insert(TDaka tDaka) {
		int result = tDakaMapper.insertSelective(tDaka);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int update(TDaka tDaka) {
		TDakaExample example = new TDakaExample();
		example.createCriteria().andIdEqualTo(tDaka.getId());
		int result = tDakaMapper.updateByExampleSelective(tDaka, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int delete(TDaka tDaka) {
		int result = tDakaMapper.deleteByPrimaryKey(tDaka.getId());
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public TDaka selectTDakaByStuId(Integer id) {
		TDaka tDaka2 = tDakaMapper.selectByPrimaryKey(id);
		if (tDaka2 != null) {
			return tDaka2;
		}
		return null;
	}

	@Override
	public List<TDaka> selectTDakaAll() {
		List<TDaka> tDakas = tDakaMapper.selectByExample(null);
		if (tDakas.isEmpty()) {
			return null;
		}
		return tDakas;
	}

	@Override
	public List<TDaka> selectTDakaByStuIds(String stuid) {
		TDakaExample example = new TDakaExample();
		example.createCriteria().andStuidEqualTo(stuid);
		List<TDaka> tDakas = tDakaMapper.selectByExample(example);
		if (tDakas.isEmpty()) {
			return null;
		}
		return tDakas;
	}

}
