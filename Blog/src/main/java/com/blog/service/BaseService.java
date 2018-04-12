package com.blog.service;

import java.util.List;

public interface BaseService<T> {
	
	int insertData(T t);

	int updateData(T t);

	int deleteData(T t);

	List<T> selectDataAll();
	
	List<T> selectDataByCondition(T t);
	
}
