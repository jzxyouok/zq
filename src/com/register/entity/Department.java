package com.register.entity;

/**
 * 
 * @Description:科室类
 * @author 张倩
 * @date:2016年3月25日上午9:41:05
 */
public class Department {
	private int id;//科室id
	private String name;//科室名称
	
	public Department() {
		
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
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	

}
