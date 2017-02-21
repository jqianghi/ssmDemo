package com.jiang.demo.dao;

import java.util.List;

import com.jiang.demo.pojo.BaseDict;
import com.jiang.demo.pojo.Customer;
import com.jiang.demo.pojo.CustomerQueryVo;

public interface CustomerMapper {

	public List<BaseDict> findDictByCode(String code);

	/**
	 * @param vo
	 * @return
	 * 通过查询条件查询出对应信息的总数
	 */
	public Integer findCustomerCountByVo(CustomerQueryVo vo);

	/**
	 * @param vo
	 * @return
	 *通过查询条件查询出对应的信息
	 */
	public List<Customer> findCustomerByVo(CustomerQueryVo vo);

	/**
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(String id);

	/**
	 * @param customer
	 */
	public void updateCustomer(Customer customer);

	/**
	 * @param id
	 */
	public void deleteCustomerById(String id);

	/**
	 * @param customer
	 */
	public void addCustomer(Customer customer);
}
