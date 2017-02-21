package com.jiang.demo.pojo;

public class BleLocateData {
    private Integer id;

    private String userid;

    private String building;

    private String floor;

    private Double corx;

    private Double cory;

    private Long time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public Double getCorx() {
        return corx;
    }

    public void setCorx(Double corx) {
        this.corx = corx;
    }

    public Double getCory() {
        return cory;
    }

    public void setCory(Double cory) {
        this.cory = cory;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}