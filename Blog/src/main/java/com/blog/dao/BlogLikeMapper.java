package com.blog.dao;

import com.blog.pojo.BlogLike;
import com.blog.pojo.BlogLikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogLikeMapper {
    long countByExample(BlogLikeExample example);

    int deleteByExample(BlogLikeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogLike record);

    int insertSelective(BlogLike record);

    List<BlogLike> selectByExample(BlogLikeExample example);

    BlogLike selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByExample(@Param("record") BlogLike record, @Param("example") BlogLikeExample example);

    int updateByPrimaryKeySelective(BlogLike record);

    int updateByPrimaryKey(BlogLike record);
}