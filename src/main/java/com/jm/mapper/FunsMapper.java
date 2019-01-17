package com.jm.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jm.pojo.Funs;
import com.jm.pojo.FunsExample;

public interface FunsMapper {
    int countByExample(FunsExample example);

    int deleteByExample(FunsExample example);

    int deleteByPrimaryKey(Integer funid);

    int insert(Funs record);

    int insertSelective(Funs record);

    List<Funs> selectByExample(FunsExample example);

    Funs selectByPrimaryKey(Integer funid);

    int updateByExampleSelective(@Param("record") Funs record, @Param("example") FunsExample example);

    int updateByExample(@Param("record") Funs record, @Param("example") FunsExample example);

    int updateByPrimaryKeySelective(Funs record);

    int updateByPrimaryKey(Funs record);
}