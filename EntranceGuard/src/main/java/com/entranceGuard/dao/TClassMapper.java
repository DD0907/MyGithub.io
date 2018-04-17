package com.entranceGuard.dao;

import com.entranceGuard.pojo.TClass;
import com.entranceGuard.pojo.TClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TClassMapper {
    long countByExample(TClassExample example);

    int deleteByExample(TClassExample example);

    int deleteByPrimaryKey(Integer classid);

    int insert(TClass record);

    int insertSelective(TClass record);

    List<TClass> selectByExample(TClassExample example);

    TClass selectByPrimaryKey(Integer classid);

    int updateByExampleSelective(@Param("record") TClass record, @Param("example") TClassExample example);

    int updateByExample(@Param("record") TClass record, @Param("example") TClassExample example);

    int updateByPrimaryKeySelective(TClass record);

    int updateByPrimaryKey(TClass record);
}