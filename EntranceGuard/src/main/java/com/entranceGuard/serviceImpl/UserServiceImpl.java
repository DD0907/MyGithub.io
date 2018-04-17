package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TLoginMapper;
import com.entranceGuard.pojo.TLogin;
import com.entranceGuard.pojo.TLoginExample;
import com.entranceGuard.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TLoginMapper tLoginMapper;

	@Override
	public int insertUser(TLogin tLogin) {
		int result = tLoginMapper.insertSelective(tLogin);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateUser(TLogin tLogin) {
		TLoginExample example = new TLoginExample();
		example.createCriteria().andUsernameEqualTo(tLogin.getUsername());
		int result = tLoginMapper.updateByExampleSelective(tLogin, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteUser(TLogin tLogin) {
		int result = tLoginMapper.deleteByPrimaryKey(tLogin.getUsername());
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public TLogin selectUserByUsername(String username) {
		TLogin tLogin = tLoginMapper.selectByPrimaryKey(username);
		if (tLogin != null) {
			return tLogin;
		}
		return null;
	}

	@Override
	public List<TLogin> selectUserAll() {
		List<TLogin> tLogins = tLoginMapper.selectByExample(null);
		if (tLogins.isEmpty()) {
			return null;
		}
		return tLogins;
	}

	@Override
	public List<TLogin> selectUserByUsernames(String username) {
		TLoginExample example=new TLoginExample();
		example.createCriteria().andUsernameEqualTo(username);
		List<TLogin> tLogins = tLoginMapper.selectByExample(example);
		if (tLogins.isEmpty()) {
			return null;
		}
		return tLogins;
	}
}
