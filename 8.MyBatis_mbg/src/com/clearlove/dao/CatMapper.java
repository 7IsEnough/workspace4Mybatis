package com.clearlove.dao;

import com.clearlove.bean.Cat;
import com.clearlove.bean.CatExample;
import com.clearlove.bean.Cat;
import com.clearlove.bean.CatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatMapper {
    int countByExample(CatExample example);

    int deleteByExample(CatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cat record);

    int insertSelective(Cat record);

    List<Cat> selectByExample(CatExample example);

    Cat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByExample(@Param("record") Cat record, @Param("example") CatExample example);

    int updateByPrimaryKeySelective(Cat record);

    int updateByPrimaryKey(Cat record);
}