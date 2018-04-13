package com.blog.service;

import java.util.List;

import com.blog.pojo.Blogger;

public interface BloggerService {
	int insertBlogger(Blogger blogger);

	int updateBlogger(Blogger blogger);

	int deleteBlogger(Blogger blogger);

	List<Blogger> selectBloggerAll();

	List<Blogger> selectBloggerByCondition(Blogger blogger);
}
