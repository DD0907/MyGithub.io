package com.blog.dao;

import com.blog.pojo.BlogStatistics;
import com.blog.pojo.BlogStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogStatisticsMapper {
    long countByExample(BlogStatisticsExample example);

    int deleteByExample(BlogStatisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogStatistics record);

    int insertSelective(BlogStatistics record);

    List<BlogStatistics> selectByExample(BlogStatisticsExample example);

    BlogStatistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogStatistics record, @Param("example") BlogStatisticsExample example);

    int updateByExample(@Param("record") BlogStatistics record, @Param("example") BlogStatisticsExample example);

    int updateByPrimaryKeySelective(BlogStatistics record);

    int updateByPrimaryKey(BlogStatistics record);
}