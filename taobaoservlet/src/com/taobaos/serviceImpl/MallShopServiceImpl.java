package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.MallShopMapper;
import com.taobaos.pojo.MallShop;
import com.taobaos.pojo.MallShopExample;
import com.taobaos.service.MallShopService;
import com.taobaos.util.DBUtil;

public class MallShopServiceImpl implements MallShopService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertMallShop(MallShop mallShop) {
		MallShopMapper mallShopMapper = session.getMapper(MallShopMapper.class);
		int result = mallShopMapper.insertSelective(mallShop);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateMallShop(MallShop mallShop) {
		MallShopMapper mallShopMapper = session.getMapper(MallShopMapper.class);
		MallShopExample example = new MallShopExample();
		example.createCriteria().andMallIdEqualTo(mallShop.getMallId());
		int result = mallShopMapper.updateByExampleSelective(mallShop, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteMallShop(MallShop mallShop) {
		MallShopMapper mallShopMapper = session.getMapper(MallShopMapper.class);
		MallShopExample example = new MallShopExample();
		example.createCriteria().andMallIdEqualTo(mallShop.getMallId());
		int result = mallShopMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<MallShop> selectMallShopByMallId(Integer mallId) {
		MallShopMapper mallShopMapper = session.getMapper(MallShopMapper.class);
		MallShopExample example = new MallShopExample();
		example.createCriteria().andMallIdEqualTo(mallId);
		List<MallShop> mList = mallShopMapper.selectByExample(example);
		if (mList.isEmpty()) {
			return null;
		}
		return mList;
	}

	@Override
	public List<MallShop> selectMallShopAll() {
		MallShopMapper mallShopMapper = session.getMapper(MallShopMapper.class);
		List<MallShop> mList = mallShopMapper.selectByExample(null);
		if (mList.isEmpty()) {
			return null;
		}
		return mList;
	}

}
