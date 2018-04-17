package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TXibieMapper;
import com.entranceGuard.pojo.TXibie;
import com.entranceGuard.pojo.TXibieExample;
import com.entranceGuard.service.TXiBieService;

@Service
public class TXiBieServiceImpl implements TXiBieService {
	@Autowired
	TXibieMapper tXiBieMapper;

	@Override
	public List<TXibie> selectByName(String name) {
		TXibieExample example=new TXibieExample();
		example.createCriteria().andXibienameEqualTo(name);
		List<TXibie> tXiBies = tXiBieMapper.selectByExample(example);
		if (tXiBies.isEmpty()) {
			return null;
		}
		return tXiBies;
	}

	@Override
	public List<TXibie> selectByAll() {
		List<TXibie> tXiBies = tXiBieMapper.selectByExample(null);
		if (tXiBies.isEmpty()) {
			return null;
		}
		return tXiBies;
	}

}
