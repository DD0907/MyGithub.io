package com.blog.dao;

import com.blog.pojo.BloggeInfo;
import com.blog.pojo.BloggeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BloggeInfoMapper {
    long countByExample(BloggeInfoExample example);

    int deleteByExample(BloggeInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BloggeInfo record);

    int insertSelective(BloggeInfo record);

    List<BloggeInfo> selectByExample(BloggeInfoExample example);

    BloggeInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BloggeInfo record, @Param("example") BloggeInfoExample example);

    int updateByExample(@Param("record") BloggeInfo record, @Param("example") BloggeInfoExample example);

    int updateByPrimaryKeySelective(BloggeInfo record);

    int updateByPrimaryKey(BloggeInfo record);
}