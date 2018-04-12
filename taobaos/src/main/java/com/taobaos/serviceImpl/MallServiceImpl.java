package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.MallMapper;
import com.taobaos.pojo.Mall;
import com.taobaos.pojo.MallExample;
import com.taobaos.service.MallServie;

@Service
public class MallServiceImpl implements MallServie {
	@Autowired
	MallMapper mallMapper;

	@Override
	public int insertMall(Mall mall) {
		int reult = mallMapper.insert(mall);
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int updateMall(Mall mall) {
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(mall.getName());
		int reult = mallMapper.updateByExampleWithBLOBs(mall, example);
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int deleteMall(Mall mall) {
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(mall.getName());
		int reult = mallMapper.deleteByExample(example);
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int deleteMallStatus(Mall mall) {
		int reult = mallMapper.deleteMallStatus(mall);
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public List<Mall> selectMallByName(String name) {
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(name);
		List<Mall> malls = mallMapper.selectByExample(example);
		if (malls.isEmpty()) {
			return null;
		}
		return malls;
	}

	@Override
	public List<Mall> selectMallAll() {
		List<Mall> malls = mallMapper.selectByExampleWithBLOBs(null);
		if (malls.isEmpty()) {
			return null;
		}
		return malls;
	}

	@Override
	public Mall updateSelectMallByName(String name) {
		Mall mall = mallMapper.updateSelectMallByName(name);
		if (mall != null) {
			return mall;
		}
		return null;
	}
}
