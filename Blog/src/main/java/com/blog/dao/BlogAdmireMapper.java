package com.blog.dao;

import com.blog.pojo.BlogAdmire;
import com.blog.pojo.BlogAdmireExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogAdmireMapper {
    long countByExample(BlogAdmireExample example);

    int deleteByExample(BlogAdmireExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogAdmire record);

    int insertSelective(BlogAdmire record);

    List<BlogAdmire> selectByExample(BlogAdmireExample example);

    BlogAdmire selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogAdmire record, @Param("example") BlogAdmireExample example);

    int updateByExample(@Param("record") BlogAdmire record, @Param("example") BlogAdmireExample example);

    int updateByPrimaryKeySelective(BlogAdmire record);

    int updateByPrimaryKey(BlogAdmire record);
}