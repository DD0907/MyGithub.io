package com.blog.dao;

import com.blog.pojo.BlogLabel;
import com.blog.pojo.BlogLabelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLabelMapper {
    long countByExample(BlogLabelExample example);

    int deleteByExample(BlogLabelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLabel record);

    int insertSelective(BlogLabel record);

    List<BlogLabel> selectByExample(BlogLabelExample example);

    BlogLabel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLabel record, @Param("example") BlogLabelExample example);

    int updateByExample(@Param("record") BlogLabel record, @Param("example") BlogLabelExample example);

    int updateByPrimaryKeySelective(BlogLabel record);

    int updateByPrimaryKey(BlogLabel record);
}