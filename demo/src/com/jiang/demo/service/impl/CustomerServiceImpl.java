/**
 * 
 */
package com.jiang.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jiang.demo.dao.CustomerMapper;
import com.jiang.demo.dao.DictMapper;
import com.jiang.demo.pojo.BaseDict;
import com.jiang.demo.pojo.Customer;
import com.jiang.demo.pojo.CustomerQueryVo;
import com.jiang.demo.service.CustomerService;
import com.jiang.demo.utils.UUIDUtils;

/**
 * @author jiang
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Resource
	private CustomerMapper customerMapper;
	@Resource
	private DictMapper dictMapper;
	
	/** 
	 * 通过字典id查询对应的字典信息
	 */
	@Override
	public List<BaseDict> findDictByCode(String code) {

		return dictMapper.findDictByCode(code);
	}

	/** 
	 * 通过vo按条件查询出总记录数
	 */
	@Override
	public Integer findCustomerCountByVo(CustomerQueryVo vo) {
		
		return customerMapper.findCustomerCountByVo(vo);
	}

	/** 
	 * 通过vo按条件查询对应的信息
	 */
	@Override
	public List<Customer> findCustomerByVo(CustomerQueryVo vo) {
		
		return customerMapper.findCustomerByVo(vo);
	}

	/** 
	 * 通过id查询用户信息
	 */
	@Override
	public Customer findCustomerById(String id) {
		
		return customerMapper.findCustomerById(id);
	}

	/** 
	 * 更新用户的方法
	 */
	@Override
	public void updateCustomer(Customer customer) {

		customerMapper.updateCustomer(customer);
	}

	/** 
	 * 通过Id删除用户信息
	 */
	@Override
	public void deleteCustomerById(String id) {
		
		customerMapper.deleteCustomerById(id);
		
	}

	/** 
	 * 添加顾客的方法
	 */
	@Override
	public void addCustomer(Customer customer) {
	
		customer.setCust_id(UUIDUtils.getUUID());
		customerMapper.addCustomer(customer);
	}


}
