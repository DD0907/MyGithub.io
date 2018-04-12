package com.taobaos.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.taobaos.pojo.Mall;
import com.taobaos.pojo.MallExample;

public interface MallMapper {
	
	 //改变状态
    int deleteMallStatus(Mall mall);
    //用shop存数据
    Mall updateSelectMallByName(String name);
	
    long countByExample(MallExample example);

    int deleteByExample(MallExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mall record);

    int insertSelective(Mall record);

    List<Mall> selectByExampleWithBLOBs(MallExample example);

    List<Mall> selectByExample(MallExample example);

    Mall selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExampleWithBLOBs(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByExample(@Param("record") Mall record, @Param("example") MallExample example);

    int updateByPrimaryKeySelective(Mall record);

    int updateByPrimaryKeyWithBLOBs(Mall record);

    int updateByPrimaryKey(Mall record);
    
}