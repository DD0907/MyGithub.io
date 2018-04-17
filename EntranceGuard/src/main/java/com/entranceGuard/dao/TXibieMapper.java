package com.entranceGuard.dao;

import com.entranceGuard.pojo.TXibie;
import com.entranceGuard.pojo.TXibieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TXibieMapper {
    long countByExample(TXibieExample example);

    int deleteByExample(TXibieExample example);

    int deleteByPrimaryKey(Long xibieid);

    int insert(TXibie record);

    int insertSelective(TXibie record);

    List<TXibie> selectByExample(TXibieExample example);

    TXibie selectByPrimaryKey(Long xibieid);

    int updateByExampleSelective(@Param("record") TXibie record, @Param("example") TXibieExample example);

    int updateByExample(@Param("record") TXibie record, @Param("example") TXibieExample example);

    int updateByPrimaryKeySelective(TXibie record);

    int updateByPrimaryKey(TXibie record);
}