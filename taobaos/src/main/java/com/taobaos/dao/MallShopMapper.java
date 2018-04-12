package com.taobaos.dao;

import com.taobaos.pojo.MallShop;
import com.taobaos.pojo.MallShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallShopMapper {
    long countByExample(MallShopExample example);

    int deleteByExample(MallShopExample example);

    int insert(MallShop record);

    int insertSelective(MallShop record);

    List<MallShop> selectByExample(MallShopExample example);

    int updateByExampleSelective(@Param("record") MallShop record, @Param("example") MallShopExample example);

    int updateByExample(@Param("record") MallShop record, @Param("example") MallShopExample example);
}