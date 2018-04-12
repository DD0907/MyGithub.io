package com.taobaos.service;

import java.util.List;

import com.taobaos.pojo.ActivityItem;

public interface ActivityItemService {
	int insertActivityItem(ActivityItem activityItem);

	int updateActivityItem(ActivityItem activityItem);

	int deleteActivityItem(ActivityItem activityItem);

	List<ActivityItem> selectActivityItemByActivityId(Integer activityId);

	List<ActivityItem> selectActivityItemAll();
}
