package com.taobaos.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.taobaos.dao.ActivityItemMapper;
import com.taobaos.pojo.ActivityItem;
import com.taobaos.pojo.ActivityItemExample;
import com.taobaos.service.ActivityItemService;
import com.taobaos.util.DBUtil;

public class ActivityItemServiceImpl implements ActivityItemService {
	SqlSession session = DBUtil.getSession();

	@Override
	public int insertActivityItem(ActivityItem activityItem) {
		ActivityItemMapper activityItemMapper = session.getMapper(ActivityItemMapper.class);
		int result = activityItemMapper.insertSelective(activityItem);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int updateActivityItem(ActivityItem activityItem) {
		ActivityItemMapper activityItemMapper = session.getMapper(ActivityItemMapper.class);
		ActivityItemExample example = new ActivityItemExample();
		example.createCriteria().andActivityIdEqualTo(activityItem.getItemId());
		int result = activityItemMapper.updateByExampleSelective(activityItem, example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public int deleteActivityItem(ActivityItem activityItem) {
		ActivityItemMapper activityItemMapper = session.getMapper(ActivityItemMapper.class);
		ActivityItemExample example = new ActivityItemExample();
		example.createCriteria().andActivityIdEqualTo(activityItem.getItemId());
		int result = activityItemMapper.deleteByExample(example);
		session.commit();
		if (result > 0) {
			return result;
		}
		return 0;
	}

	@Override
	public List<ActivityItem> selectActivityItemByActivityId(Integer activityId) {
		ActivityItemMapper activityItemMapper = session.getMapper(ActivityItemMapper.class);
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
		ActivityItemMapper activityItemMapper = session.getMapper(ActivityItemMapper.class);
		List<ActivityItem> result = activityItemMapper.selectByExample(null);
		if (result.isEmpty()) {
			return null;
		}
		return result;
	}

}
