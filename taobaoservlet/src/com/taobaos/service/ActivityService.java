package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.Activity;

public interface ActivityService {
	int insertActivity(Activity activity);

	int updateActivity(Activity activity);

	int deleteActivity(Activity activity);
	
	int deletestatusActivity(String name);

	Activity selectActivityByNames(String name);

	List<Activity> selectActivityByName(String name);

	List<Activity> selectActivityAll();
}
