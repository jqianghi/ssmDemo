/**
 * 
 */
package com.jiang.demo.service;

import java.util.List;

import com.jiang.demo.pojo.BLeLocateDataQueryVo;
import com.jiang.demo.pojo.BleLocateData;
/**
 * @author jiang
 */
public interface BleLocateDataService {

	
	/**
	 * 通过用户的id查询对应的大厦定位信息
	 * */
	List<BleLocateData> findBleLocateDataByUserId(String userId);

	

	/**
	 * 通过查询条件查询出对应的大厦定位信息
	 */
	List<BleLocateData> findBleLocateDataByVo(BLeLocateDataQueryVo vo);

	/**
	 * 添加大厦定位信息的方法
	 * @param bleLocateData
	 */
	void addBleLocateData(BleLocateData bleLocateData);

	/**
	 * 删除大厦定位信息的方法
	 * @param id
	 */
	void delBleLocateData(Integer id);

	/**
	 * 更新大厦定位信息
	 * @param bleLocateData
	 */
	void updateBleLocateData(BleLocateData bleLocateData);

	/**
	 * 通过id查询信息的方法
	 * @param id
	 * @return
	 */
	BleLocateData findBleLocateDataById(Integer id);
	
	
}
