package com.taobaos.dao;

import com.taobaos.pojo.ActivityItem;
import com.taobaos.pojo.ActivityItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityItemMapper {
    long countByExample(ActivityItemExample example);

    int deleteByExample(ActivityItemExample example);

    int insert(ActivityItem record);

    int insertSelective(ActivityItem record);

    List<ActivityItem> selectByExample(ActivityItemExample example);

    int updateByExampleSelective(@Param("record") ActivityItem record, @Param("example") ActivityItemExample example);

    int updateByExample(@Param("record") ActivityItem record, @Param("example") ActivityItemExample example);
}