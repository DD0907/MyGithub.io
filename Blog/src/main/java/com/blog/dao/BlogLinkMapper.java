package com.blog.dao;

import com.blog.pojo.BlogLink;
import com.blog.pojo.BlogLinkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLinkMapper {
    long countByExample(BlogLinkExample example);

    int deleteByExample(BlogLinkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLink record);

    int insertSelective(BlogLink record);

    List<BlogLink> selectByExample(BlogLinkExample example);

    BlogLink selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLink record, @Param("example") BlogLinkExample example);

    int updateByExample(@Param("record") BlogLink record, @Param("example") BlogLinkExample example);

    int updateByPrimaryKeySelective(BlogLink record);

    int updateByPrimaryKey(BlogLink record);
}