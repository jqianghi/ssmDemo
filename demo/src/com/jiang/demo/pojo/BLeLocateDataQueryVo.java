package com.jiang.demo.pojo;

/**
 * 查询大厦的定位信息vo类
 * */
public class BLeLocateDataQueryVo {

	private String building;//大厦
	private String floor;//楼层
	private String corx;//x
	private String cory;//y
	private Long time;//时间
	private String userid;//用户的id

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getBuilding() {
		return building;
	}
	
	public void setBuilding(String building) {
		this.building = building;
	}
	
	public String getFloor() {
		return floor;
	}
	
	public void setFloor(String floor) {
		this.floor = floor;
	}
	
	public String getCorx() {
		return corx;
	}
	
	public void setCorx(String corx) {
		this.corx = corx;
	}
	
	public String getCory() {
		return cory;
	}
	
	public void setCory(String cory) {
		this.cory = cory;
	}

	

	public Long getTime() {
		return time;
	}


	public void setTime(Long time) {
		this.time = time;
	}
	
	
	
	
}
