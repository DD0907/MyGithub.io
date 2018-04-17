package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TXibie;

public interface TXiBieService {
//	int insert(TXiBie tXiBie);
//
//	int update(TXiBie tXiBie);
//
//	int delete(TXiBie tXiBie);
//
//	TXiBie selectTXiBieByName(TXiBie tXiBie);

	List<TXibie> selectByName(String name);

	List<TXibie> selectByAll();
}
