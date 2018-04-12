package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.MallShopMapper;
import com.taobaos.pojo.MallShop;
import com.taobaos.pojo.MallShopExample;
import com.taobaos.service.MallShopService;

@Service
public class MallShopServiceImpl implements MallShopService {
	@Autowired
	MallShopMapper mallShopMapper;

	@Override
	public int insertMallShop(MallShop mallShop) {
		int result = mallShopMapper.insertSelective(mallShop);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateMallShop(MallShop mallShop) {
		MallShopExample example = new MallShopExample();
		example.createCriteria().andMallIdEqualTo(mallShop.getMallId());
		int result = mallShopMapper.updateByExampleSelective(mallShop, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteMallShop(MallShop mallShop) {
		MallShopExample example = new MallShopExample();
		example.createCriteria().andMallIdEqualTo(mallShop.getMallId());
		int result = mallShopMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<MallShop> selectMallShopByMallId(Integer mallId) {
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
		List<MallShop> mList = mallShopMapper.selectByExample(null);
		if (mList.isEmpty()) {
			return null;
		}
		return mList;
	}

}
