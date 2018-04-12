package com.blog.dao;

import com.blog.pojo.BlogPicture;
import com.blog.pojo.BlogPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogPictureMapper {
    long countByExample(BlogPictureExample example);

    int deleteByExample(BlogPictureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BlogPicture record);

    int insertSelective(BlogPicture record);

    List<BlogPicture> selectByExample(BlogPictureExample example);

    BlogPicture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByExample(@Param("record") BlogPicture record, @Param("example") BlogPictureExample example);

    int updateByPrimaryKeySelective(BlogPicture record);

    int updateByPrimaryKey(BlogPicture record);
}