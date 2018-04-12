package com.taobaos.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taobaos.dao.ActivityItemMapper;
import com.taobaos.pojo.ActivityItem;
import com.taobaos.pojo.ActivityItemExample;
import com.taobaos.service.ActivityItemService;

@Service
public class ActivityItemServiceImpl implements ActivityItemService {
	@Autowired
	ActivityItemMapper activityItemMapper;

	@Override
	public int insertActivityItem(ActivityItem activityItem) {
		int result = activityItemMapper.insertSelective(activityItem);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateActivityItem(ActivityItem activityItem) {
		ActivityItemExample example = new ActivityItemExample();
		example.createCriteria().andActivityIdEqualTo(activityItem.getItemId());
		int result = activityItemMapper.updateByExampleSelective(activityItem, example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteActivityItem(ActivityItem activityItem) {
		ActivityItemExample example = new ActivityItemExample();
		example.createCriteria().andActivityIdEqualTo(activityItem.getItemId());
		int result = activityItemMapper.deleteByExample(example);
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<ActivityItem> selectActivityItemByActivityId(Integer activityId) {
		ActivityItemExample example = new ActivityItemExample();
		example.createCriteria().andActivityIdEqualTo(activityId);
		List<ActivityItem> result = activityItemMapper.selectByExample(example);
		if (result.isEmpty()) {
			return null;
		}
		return result;
	}

	@Override
	public List<ActivityItem> selectActivityItemAll() {
		List<ActivityItem> result = activityItemMapper.selectByExample(null);
		if (result.isEmpty()) {
			return null;
		}
		return result;
	}

}
