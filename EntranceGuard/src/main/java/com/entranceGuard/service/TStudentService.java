package com.entranceGuard.service;

import java.util.List;

import com.entranceGuard.pojo.TStudent;

public interface TStudentService {
	int insert(TStudent tStudent);

	int update(TStudent tStudent);

	int delete(TStudent tStudent);

	TStudent selectTStudentByStuId(String stuId);

	List<TStudent> selectTStudentAll();

	List<TStudent> selectTStudentByStuIds(String stuid);
}
