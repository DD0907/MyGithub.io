package com.entranceGuard.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entranceGuard.dao.TStudentMapper;
import com.entranceGuard.pojo.TStudent;
import com.entranceGuard.pojo.TStudentExample;
import com.entranceGuard.service.TStudentService;

@Service
public class TStudentServiceImpl implements TStudentService {
	@Autowired
	TStudentMapper tStudentMapper;

	@Override
	public int insert(TStudent tStudent) {
		int result = tStudentMapper.insertSelective(tStudent);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int update(TStudent tStudent) {
		TStudentExample example = new TStudentExample();
		example.createCriteria().andStuidEqualTo(tStudent.getStuid());
		int result = tStudentMapper.updateByExampleSelective(tStudent, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int delete(TStudent tStudent) {
		int result = tStudentMapper.deleteByPrimaryKey(tStudent.getStuid());
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public TStudent selectTStudentByStuId(String stuId) {
		TStudent tStudent = tStudentMapper.selectByPrimaryKey(stuId);
		if (tStudent != null) {
			return tStudent;
		}
		return null;
	}

	@Override
	public List<TStudent> selectTStudentAll() {
		List<TStudent> tStudents = tStudentMapper.selectByExample(null);
		if (tStudents.isEmpty()) {
			return null;
		}
		return tStudents;
	}

	@Override
	public List<TStudent> selectTStudentByStuIds(String stuid) {
		TStudentExample example = new TStudentExample();
		example.createCriteria().andStuidEqualTo(stuid);
		List<TStudent> tStudents = tStudentMapper.selectByExample(example);
		if (tStudents.isEmpty()) {
			return null;
		}
		return tStudents;
	}
}
