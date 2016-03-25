package com.register.entity;



/**
 * 
 * @Description:医院类
 * @author 张倩
 * @date:2016年3月25日上午9:41:55
 */
public class Hospital {
	private int id;//医院id
	private String name;//医院名称
	private String password;//医院登录密码
//	private List<Doctor> doctors;//医生列表
	
	
	public Hospital() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
