package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TDaka;

public interface TDakaService {
	int insert(TDaka tDaka);

	int update(TDaka tDaka);

	int delete(TDaka tDaka);

	TDaka selectTDakaByStuId(Integer id);

	List<TDaka> selectTDakaAll();

	List<TDaka> selectTDakaByStuIds(String stuid);
}
