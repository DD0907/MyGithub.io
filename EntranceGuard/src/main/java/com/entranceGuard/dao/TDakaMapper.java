package com.entranceGuard.dao;

import com.entranceGuard.pojo.TDaka;
import com.entranceGuard.pojo.TDakaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDakaMapper {
    long countByExample(TDakaExample example);

    int deleteByExample(TDakaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDaka record);

    int insertSelective(TDaka record);

    List<TDaka> selectByExample(TDakaExample example);

    TDaka selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDaka record, @Param("example") TDakaExample example);

    int updateByExample(@Param("record") TDaka record, @Param("example") TDakaExample example);

    int updateByPrimaryKeySelective(TDaka record);

    int updateByPrimaryKey(TDaka record);
}