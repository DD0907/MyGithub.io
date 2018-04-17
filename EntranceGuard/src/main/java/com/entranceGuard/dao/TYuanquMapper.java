package com.entranceGuard.dao;

import com.entranceGuard.pojo.TYuanqu;
import com.entranceGuard.pojo.TYuanquExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TYuanquMapper {
    long countByExample(TYuanquExample example);

    int deleteByExample(TYuanquExample example);

    int deleteByPrimaryKey(String yuanquid);

    int insert(TYuanqu record);

    int insertSelective(TYuanqu record);

    List<TYuanqu> selectByExample(TYuanquExample example);

    TYuanqu selectByPrimaryKey(String yuanquid);

    int updateByExampleSelective(@Param("record") TYuanqu record, @Param("example") TYuanquExample example);

    int updateByExample(@Param("record") TYuanqu record, @Param("example") TYuanquExample example);

    int updateByPrimaryKeySelective(TYuanqu record);

    int updateByPrimaryKey(TYuanqu record);
}