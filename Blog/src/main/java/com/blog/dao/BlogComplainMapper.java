package com.blog.dao;

import com.blog.pojo.BlogComplain;
import com.blog.pojo.BlogComplainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogComplainMapper {
    long countByExample(BlogComplainExample example);

    int deleteByExample(BlogComplainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogComplain record);

    int insertSelective(BlogComplain record);

    List<BlogComplain> selectByExampleWithBLOBs(BlogComplainExample example);

    List<BlogComplain> selectByExample(BlogComplainExample example);

    BlogComplain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogComplain record, @Param("example") BlogComplainExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogComplain record, @Param("example") BlogComplainExample example);

    int updateByExample(@Param("record") BlogComplain record, @Param("example") BlogComplainExample example);

    int updateByPrimaryKeySelective(BlogComplain record);

    int updateByPrimaryKeyWithBLOBs(BlogComplain record);

    int updateByPrimaryKey(BlogComplain record);
}