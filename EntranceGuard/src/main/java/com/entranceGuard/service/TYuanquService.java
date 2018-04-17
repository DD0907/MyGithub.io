package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TYuanqu;

public interface TYuanquService {
	int insert(TYuanqu tYuanqu);

	int update(TYuanqu tYuanqu);

	int delete(TYuanqu tYuanqu);

	TYuanqu selectTYuanquById(String yuanquname);

	List<TYuanqu> selectTYuanquAll();

	List<TYuanqu> selectTYuanquByIds(String yuanquname);
}
