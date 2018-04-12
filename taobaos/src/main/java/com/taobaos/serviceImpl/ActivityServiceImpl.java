package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.ActivityMapper;
import com.taobaos.pojo.Activity;
import com.taobaos.pojo.ActivityExample;
import com.taobaos.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	@Autowired
	ActivityMapper activityMapper;

	@Override
	public int insertActivity(Activity activity) {
		int result = activityMapper.insertSelective(activity);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateActivity(Activity activity) {
		int result = activityMapper.updateByPrimaryKeySelective(activity);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteActivity(Activity activity) {
		ActivityExample example = new ActivityExample();
		example.createCriteria().andNameEqualTo(activity.getName());
		int result = activityMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Activity selectActivityByNames(String name) {
		Activity activity = activityMapper.selectActivityByNames(name);
		if (activity == null) {
			return null;
		} else {
			return activity;
		}
	}

	@Override
	public List<Activity> selectActivityByName(String name) {
		ActivityExample example = new ActivityExample();
		example.createCriteria().andNameEqualTo(name);
		List<Activity> aList = activityMapper.selectByExample(example);
		if (aList.isEmpty()) {
			return null;
		} else {
			return aList;
		}
	}

	@Override
	public List<Activity> selectActivityAll() {
		List<Activity> aList = activityMapper.selectByExampleWithBLOBs(null);
		if (aList.isEmpty()) {
			return null;
		} else {
			return aList;
		}
	}

	@Override
	public int deletestatusActivity(String name) {
		int result = activityMapper.deletestatusActivity(name);
		if (result > 0) {
			return result;
		}
		return 0;
	}

}
