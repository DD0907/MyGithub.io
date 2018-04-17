package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TClassMapper;
import com.entranceGuard.pojo.TClass;
import com.entranceGuard.pojo.TClassExample;

@Service
public class TClassServiceImpl implements com.entranceGuard.service.TClassService {
	@Autowired
	TClassMapper tClassMapper;

	@Override
	public int insertUser(TClass tClass) {
		int result = tClassMapper.insertSelective(tClass);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateUser(TClass tClass) {
		TClassExample example = new TClassExample();
		example.createCriteria().andClassidEqualTo(tClass.getClassid());
		int result = tClassMapper.updateByExampleSelective(tClass, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteUser(TClass tClass) {
		int result = tClassMapper.deleteByPrimaryKey(tClass.getClassid());
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public TClass selectTClassByclassName(TClass tClass) {
		TClass tClass2 = tClassMapper.selectClassByClassName(tClass.getClassname());
		if (tClass2 != null) {
			return tClass2;
		}
		return null;
	}

	@Override
	public List<TClass> selectTClassAll() {
		List<TClass> tClasses = tClassMapper.selectByExample(null);
		if (tClasses.isEmpty()) {
			return null;
		}
		return tClasses;
	}

	@Override
	public List<TClass> selectTClassByclassNames(String name) {
		TClassExample example = new TClassExample();
		example.createCriteria().andClassnameEqualTo(name);
		List<TClass> tClasses = tClassMapper.selectByExample(example);
		if (tClasses.isEmpty()) {
			return null;
		}
		return tClasses;
	}

}
