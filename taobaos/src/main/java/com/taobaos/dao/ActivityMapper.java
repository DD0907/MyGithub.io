package com.taobaos.dao;

import com.taobaos.pojo.Activity;
import com.taobaos.pojo.ActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityMapper {

	//
	int deletestatusActivity(String name);
	
	Activity selectActivityByNames(String name);

	long countByExample(ActivityExample example);

	int deleteByExample(ActivityExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Activity record);

	int insertSelective(Activity record);

	List<Activity> selectByExampleWithBLOBs(ActivityExample example);

	List<Activity> selectByExample(ActivityExample example);

	Activity selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByExampleWithBLOBs(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByExample(@Param("record") Activity record, @Param("example") ActivityExample example);

	int updateByPrimaryKeySelective(Activity record);

	int updateByPrimaryKeyWithBLOBs(Activity record);

	int updateByPrimaryKey(Activity record);
}