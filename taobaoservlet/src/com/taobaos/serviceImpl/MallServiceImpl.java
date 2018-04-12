package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.MallMapper;
import com.taobaos.pojo.Mall;
import com.taobaos.pojo.MallExample;
import com.taobaos.service.MallServie;
import com.taobaos.util.DBUtil;

public class MallServiceImpl implements MallServie {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertMall(Mall mall) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		int reult = mallMapper.insert(mall);
		session.commit();
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int updateMall(Mall mall) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(mall.getName());
		int reult = mallMapper.updateByExampleWithBLOBs(mall, example);
		session.commit();
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int deleteMall(Mall mall) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(mall.getName());
		int reult = mallMapper.deleteByExample(example);
		session.commit();
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public int deleteMallStatus(Mall mall) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		int reult = mallMapper.deleteMallStatus(mall);
		session.commit();
		if (reult > 0) {
			return reult;
		}
		return 0;
	}

	@Override
	public List<Mall> selectMallByName(String name) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		MallExample example = new MallExample();
		example.createCriteria().andNameEqualTo(name);
		List<Mall> malls = mallMapper.selectByExample(example);
		if (malls.isEmpty()) {
			return malls;
		}
		return null;
	}

	@Override
	public List<Mall> selectMallAll() {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		List<Mall> malls = mallMapper.selectByExampleWithBLOBs(null);
		if (malls.isEmpty()) {
			return null;
		}
		return malls;
	}

	@Override
	public Mall updateSelectMallByName(String name) {
		MallMapper mallMapper = session.getMapper(MallMapper.class);
		Mall mall = mallMapper.updateSelectMallByName(name);
		if (mall != null) {
			return mall;
		}
		return null;
	}
}
