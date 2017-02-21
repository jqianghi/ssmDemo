package com.jiang.demo.dao;

import com.jiang.demo.pojo.BleLocateData;
import com.jiang.demo.pojo.BleLocateDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BleLocateDataMapper {
    int countByExample(BleLocateDataExample example);

    int deleteByExample(BleLocateDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BleLocateData record);

    int insertSelective(BleLocateData record);

    List<BleLocateData> selectByExample(BleLocateDataExample example);

    BleLocateData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BleLocateData record, @Param("example") BleLocateDataExample example);

    int updateByExample(@Param("record") BleLocateData record, @Param("example") BleLocateDataExample example);

    int updateByPrimaryKeySelective(BleLocateData record);

    int updateByPrimaryKey(BleLocateData record);
}