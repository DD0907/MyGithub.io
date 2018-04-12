package com.taobaos.dao;

import com.taobaos.pojo.ItemImage;
import com.taobaos.pojo.ItemImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemImageMapper {
    long countByExample(ItemImageExample example);

    int deleteByExample(ItemImageExample example);

    int insert(ItemImage record);

    int insertSelective(ItemImage record);

    List<ItemImage> selectByExample(ItemImageExample example);

    int updateByExampleSelective(@Param("record") ItemImage record, @Param("example") ItemImageExample example);

    int updateByExample(@Param("record") ItemImage record, @Param("example") ItemImageExample example);
}