package com.blog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.blog.dao.BloggerMapper;
import com.blog.pojo.Blogger;
import com.blog.pojo.BloggerExample;
import com.blog.service.BloggerService;

@Service
public class BloggerServiceImpl implements BloggerService {

	@Autowired
	BloggerMapper bloggerMapper;

	@Override
	public int insertData(Blogger t) {
		int result = bloggerMapper.insertSelective(t);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateData(Blogger t) {
		BloggerExample example = new BloggerExample();
		example.createCriteria().andIdEqualTo(t.getId());
		int result = bloggerMapper.updateByExampleSelective(t, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteData(Blogger t) {
		int result = bloggerMapper.updateByPrimaryKeySelective(t);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<Blogger> selectDataAll() {
		List<Blogger> bList = bloggerMapper.selectByExample(null);
		if (bList.isEmpty()) {
			return null;
		}
		return bList;
	}

	@Override
	public List<Blogger> selectDataByCondition(Blogger t) {
		BloggerExample example = new BloggerExample();
		example.createCriteria().andUsernameEqualTo(t.getUsername());
		List<Blogger> bList = bloggerMapper.selectByExample(example);
		if (bList.isEmpty()) {
			return null;
		}
		return bList;
	}
}
