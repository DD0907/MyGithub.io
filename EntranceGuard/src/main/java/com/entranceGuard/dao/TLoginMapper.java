package com.entranceGuard.dao;

import com.entranceGuard.pojo.TLogin;
import com.entranceGuard.pojo.TLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLoginMapper {
    long countByExample(TLoginExample example);

    int deleteByExample(TLoginExample example);

    int deleteByPrimaryKey(String username);

    int insert(TLogin record);

    int insertSelective(TLogin record);

    List<TLogin> selectByExample(TLoginExample example);

    TLogin selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") TLogin record, @Param("example") TLoginExample example);

    int updateByExample(@Param("record") TLogin record, @Param("example") TLoginExample example);

    int updateByPrimaryKeySelective(TLogin record);

    int updateByPrimaryKey(TLogin record);
}