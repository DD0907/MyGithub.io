package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TClass;

public interface TClassService {
	int insertUser(TClass tClass);

	int updateUser(TClass tClass);

	int deleteUser(TClass tClass);

	TClass selectTClassByclassName(TClass tClass);

	List<TClass> selectTClassAll();

	List<TClass> selectTClassByclassNames(String name);
}
