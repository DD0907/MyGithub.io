package com.blog.dao;

import com.blog.pojo.BlogCollect;
import com.blog.pojo.BlogCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogCollectMapper {
    long countByExample(BlogCollectExample example);

    int deleteByExample(BlogCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogCollect record);

    int insertSelective(BlogCollect record);

    List<BlogCollect> selectByExample(BlogCollectExample example);

    BlogCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogCollect record, @Param("example") BlogCollectExample example);

    int updateByExample(@Param("record") BlogCollect record, @Param("example") BlogCollectExample example);

    int updateByPrimaryKeySelective(BlogCollect record);

    int updateByPrimaryKey(BlogCollect record);
}