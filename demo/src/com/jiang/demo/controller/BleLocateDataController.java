package com.jiang.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jiang.demo.pojo.BLeLocateDataQueryVo;
import com.jiang.demo.pojo.BleLocateData;
import com.jiang.demo.service.BleLocateDataService;


/**
 * @author jiang
 * 大厦定位详情的Controller层
 */

@Controller  
@RequestMapping("/building")//窄化请求,相当于访问类下面方法 都需要加地址  /building.
public class BleLocateDataController {

	@Autowired  //自动注入,从容器中找到相应的对象,按照类型注入   。
	private BleLocateDataService service;
	
	/**
	 * 根据用户的Id查询对应的大厦信息
	 * */
	@RequestMapping("/{userId}")
	 public String showDetail(@PathVariable String userId, Model model){
		//根据用户的Id查询对应的大厦定位信息
		List<BleLocateData> list = service.findBleLocateDataByUserId(userId);
		//将查询的信息放入视图中,用于回显
		model.addAttribute("list",list);
		model.addAttribute("userId", userId);
		//返回页面地址     见配置文件 SpringMvc.xml  中的配置视图解析器  ,相当于地址 是/WEB-INF/jsp/building.jsp。
		return "building";
	}
		
	/**
	 * 通过查询条件查询对应的大厦定位信息 
	 * @param vo 查询条件分装(springMvc自动分装)
	 * @param model 模型，把查询到的数据放到model中，返回到页面  页面就可以通过El表达式进行获取。
	 * */
	@RequestMapping("/list")
	public String list(BLeLocateDataQueryVo vo , Model model){
			
		//查询信息回显示
		model.addAttribute("userId", vo.getUserid());
		model.addAttribute("floor", vo.getFloor());
		model.addAttribute("building", vo.getBuilding());
		model.addAttribute("time", vo.getTime());
		
		//通过查询条件查询大厦的定位信息
		List<BleLocateData> list  = service.findBleLocateDataByVo(vo);
		model.addAttribute("list", list);
		return "building";
		
	}
	
	/**
	 * 删除大厦的定位详情信息
	 * */
	@RequestMapping("/delBleLocateData")  //拦截请求地址    /building/delBleLocateData
	@ResponseBody
	public String delBleLocateData(Integer id) {	
		service.delBleLocateData(id);
		return "OK";
	}
	
	
	/**
	 * 添加大厦的定位详情信息
	 * */
	@RequestMapping("/addBleLocateData")
	@ResponseBody
	public String addBleLocateData(BleLocateData bleLocateData) {	
		service.addBleLocateData(bleLocateData);
		return "OK";
	}
	
	/**
	 * 根据id查询用于编辑的回显
	 * */
	@RequestMapping("/toEdit")
	@ResponseBody
	public BleLocateData toEdit(Integer id){	
		BleLocateData bleLocateData = service.findBleLocateDataById(id);
		return bleLocateData;
		
	}
	
	/**
	 * 更新大厦的定位详情信息
	 * */
	@RequestMapping("/updateBleLocateData")
	@ResponseBody
	public String updateCustomer(BleLocateData bleLocateData){
		service.updateBleLocateData(bleLocateData);
		return  "OK";
	}
	
}
