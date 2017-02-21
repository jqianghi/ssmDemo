package com.jiang.demo.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiang.demo.pojo.BaseDict;
import com.jiang.demo.pojo.Customer;
import com.jiang.demo.pojo.CustomerQueryVo;

import com.jiang.demo.service.CustomerService;


/**
 * @author jiang
 * ssm增删改查测试
 */

@Controller
@RequestMapping("/customer")//(窄化请求)表示在这个类的所有方法上,都添加/customer访问路径
public class CusotmerController {

	@Resource
	private CustomerService customerService;
	
	@Value("${customer.dict.source}")//引入外部资源文件  spring配置文件
	private String custSource;
	@Value("${customer.dict.industry}")
	private String custIndustry;
	@Value("${customer.dict.level}")
	private String custLevel;
	
	@RequestMapping("/list")
	public String list(CustomerQueryVo vo , Model model){
		
		//客户来源
		List<BaseDict> fromType = customerService.findDictByCode(custSource);
		//客户所属行业
		List<BaseDict> industryType = customerService.findDictByCode(custIndustry);
		//客户级别
		List<BaseDict> levelType = customerService.findDictByCode(custLevel);
			
		//将对应的信息存入视图中
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//查询信息回显示
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		model.addAttribute("custSource", vo.getCustSource());
		
		List<Customer> list  = customerService.findCustomerByVo(vo);
		model.addAttribute("list", list);

		return "customer";
		
	}
	
	/**
	 * 根据id查询用于编辑的回显
	 * 
	 * */
	
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer toEdit(String id){	
		Customer customer = customerService.findCustomerById(id);
		return customer;
		
	}
	
	
	@RequestMapping("/updateCustomer")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomer(customer);
		return  "OK";
	}
	
	
	@RequestMapping("/deleteCustomer")
	@ResponseBody
	public String deleteCustomer(String id) {
		customerService.deleteCustomerById(id);
		return "OK";
	}
	
	@RequestMapping("/addCustomer")
	@ResponseBody
	public String addCustomer(Customer customer) {	
		customerService.addCustomer(customer);
		return "OK";
	}
	
	
}
