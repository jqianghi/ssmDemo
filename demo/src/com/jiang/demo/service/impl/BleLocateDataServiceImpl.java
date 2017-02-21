package com.jiang.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.jiang.demo.dao.BleLocateDataExample;
import com.jiang.demo.dao.BleLocateDataMapper;
import com.jiang.demo.dao.BleLocateDataExample.Criteria;
import com.jiang.demo.pojo.BLeLocateDataQueryVo;
import com.jiang.demo.pojo.BleLocateData;
import com.jiang.demo.service.BleLocateDataService;

/**
 * @author jiang
 */
@Service
public class BleLocateDataServiceImpl implements BleLocateDataService{

	@Resource
	private BleLocateDataMapper mapper;
	
	/** 
	 * 通过用户信息查询用户对应的定位信息 
	 */
	@Override
	public List<BleLocateData> findBleLocateDataByUserId(String userId) {
		
		BleLocateDataExample example = new BleLocateDataExample();
		
		Criteria criteria = example.createCriteria();
		
		criteria.andUseridEqualTo(userId);
		
		List<BleLocateData> list  = mapper.selectByExample(example);

		return list;
	}
	
	/** 
	 * 通过查询条件查询出对应的大厦定位信息
	 */
	@Override
	public List<BleLocateData> findBleLocateDataByVo(BLeLocateDataQueryVo vo) {
		
		BleLocateDataExample example = new BleLocateDataExample();
		Criteria criteria = example.createCriteria();
		
		if (StringUtils.isNotBlank(vo.getBuilding())) {
			criteria.andBuildingEqualTo(vo.getBuilding());			
		}
		
		if (StringUtils.isNotBlank(vo.getFloor())) {
			criteria.andFloorEqualTo(vo.getFloor());
		}
		
		if (vo.getTime()!=null && vo.getTime()!=0) {			
			criteria.andTimeEqualTo(vo.getTime());
		}
		
		if (StringUtils.isNotBlank(vo.getUserid())) {			
			criteria.andUseridEqualTo(vo.getUserid());
		}
		
		List<BleLocateData> list = mapper.selectByExample(example);
		
		return list;
	}

	/** 
	 * 添加大厦定位信息的方法
	 */
	@Override
	public void addBleLocateData(BleLocateData bleLocateData) {
		mapper.insert(bleLocateData);
	}

	/**
	 * 删除大厦定位信息的方法
	 * */
	@Override
	public void delBleLocateData(Integer id) {
		
		mapper.deleteByPrimaryKey(id);
		
	}

	/**
	 * 更新大厦定位信息的方法
	 * */
	@Override
	public void updateBleLocateData(BleLocateData bleLocateData) {
		
		mapper.updateByPrimaryKeySelective(bleLocateData);	
	}

	/** 
	 * 通过主键查询信息回显
	 */
	@Override
	public BleLocateData findBleLocateDataById(Integer id) {
		
		return mapper.selectByPrimaryKey(id);
	}
	

}
