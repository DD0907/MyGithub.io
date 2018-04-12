package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.ActivityMapper;
import com.taobaos.pojo.Activity;
import com.taobaos.pojo.ActivityExample;
import com.taobaos.service.ActivityService;
import com.taobaos.util.DBUtil;

public class ActivityServiceImpl implements ActivityService {
	SqlSession seesion = DBUtil.getSession();

	@Override
	public int insertActivity(Activity activity) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		int result = activityMapper.insertSelective(activity);
		seesion.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateActivity(Activity activity) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		int result = activityMapper.updateByPrimaryKeySelective(activity);
		seesion.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteActivity(Activity activity) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		ActivityExample example = new ActivityExample();
		example.createCriteria().andNameEqualTo(activity.getName());
		int result = activityMapper.deleteByExample(example);
		seesion.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public Activity selectActivityByNames(String name) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		Activity activity = activityMapper.selectActivityByNames(name);
		if (activity == null) {
			return null;
		} else {
			return activity;
		}
	}

	@Override
	public List<Activity> selectActivityByName(String name) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
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
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		List<Activity> aList = activityMapper.selectByExampleWithBLOBs(null);
		if (aList.isEmpty()) {
			return null;
		} else {
			return aList;
		}
	}

	@Override
	public int deletestatusActivity(String name) {
		ActivityMapper activityMapper = seesion.getMapper(ActivityMapper.class);
		int result = activityMapper.deletestatusActivity(name);
		seesion.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

}
