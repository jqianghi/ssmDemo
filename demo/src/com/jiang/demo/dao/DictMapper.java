package com.jiang.demo.dao;

import java.util.List;

import com.jiang.demo.pojo.BaseDict;

public interface DictMapper {

	/**
	 * @param code
	 * @return
	 * 通过字典id查询对应的信息
	 */
	List<BaseDict> findDictByCode(String code);

}
