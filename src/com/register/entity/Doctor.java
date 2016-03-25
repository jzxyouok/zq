package com.register.entity;

//import java.util.List;

/**
 * 医生类
 * 
 * @author 张倩
 *
 */
public class Doctor {

	private int id;//医生编号
	private String name;//医生姓名
	private String password;//登录密码
	private String sex;//性别
	private int departmet_id;//科室id
	private int hospital_id;// 所属医院id
	
	

	public Doctor() {
		
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getDepartmet_id() {
		return departmet_id;
	}

	public void setDepartmet_id(int departmet_id) {
		this.departmet_id = departmet_id;
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

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}
//
//	public List<MedicalRecord> getRecords() {
//		return records;
//	}
//
//	public void setRecords(List<MedicalRecord> records) {
//		this.records = records;
//	}
//
//	public String getArrangement() {
//		return arrangement;
//	}
//
//	public void setArrangement(String arrangement) {
//		this.arrangement = arrangement;
//	}
//
//	private List<MedicalRecord> records;// 以往病例
//	private String arrangement;// 安排
//


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", password=" + password + ", sex=" + sex + ", departmet_id="
				+ departmet_id + ", hospital_id=" + hospital_id + "]";
	}
	
}
