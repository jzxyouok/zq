package com.register.entity;

/**
 * 
 * @Description:管理员类
 * @author 张倩
 * @date:2016年3月25日上午9:44:55
 */
public class Manager {

	private int id;//id
	private String name;//管理员账号
	private String password;//管理员密码
	
	
	public Manager() {
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
		return "Manager [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
