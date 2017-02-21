package com.jiang.demo.service;

import java.util.List;

import com.jiang.demo.pojo.BaseDict;
import com.jiang.demo.pojo.Customer;
import com.jiang.demo.pojo.CustomerQueryVo;

/**
 * @author jiang
 */
public interface CustomerService {

	/**
	 * 通过code 查询字典信息
	 */
	List<BaseDict> findDictByCode(String code);

	/**
	 * 通过条件查询总数
	 */
	Integer findCustomerCountByVo(CustomerQueryVo vo);

	/**
	 * 通过条件查询所有
	 */
	List<Customer> findCustomerByVo(CustomerQueryVo vo);

	/**
	 * 通过id查询顾客
	 */
	Customer findCustomerById(String id);

	/**
	 * 更新用户信息
	 */
	void updateCustomer(Customer customer);

	
	/**
	 * 添加的方法
	 */
	void addCustomer(Customer customer);

	/**
	 * @param id
	 */
	void deleteCustomerById(String id);

	
	
}
