package com.register.entity;

import java.util.Date;
//import java.util.List;

/**
 * 
 * @Description:病人类
 * @author 张倩
 * @date:2016年3月25日上午10:01:08
 */
public class Patient {
	private Integer id;// 编号 
	private String cardID;//身份证
//	private List<MedicalRecord> records;// 病例
	private String allergen;// 过敏原
	private String name;//姓名
	private String password;//密码
	private String phone;//电话号码
	private String sex;//性别
	private Integer age;//年龄
	private Date create_date;//创建时间
	private Date update_date;//更改时间
	
	
	
    public Patient() {
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCardID() {
		return cardID;
	}
	public void setCardID(String cardID) {
		this.cardID = cardID;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

//	public List<MedicalRecord> getRecords() {
//		return records;
//	}
//
//	public void setRecords(List<MedicalRecord> records) {
//		this.records = records;
//	}

	public String getAllergen() {
		return allergen;
	}

	public void setAllergen(String allergen) {
		this.allergen = allergen;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", cardID=" + cardID + ", allergen=" + allergen + ", name=" + name + ", password="
				+ password + ", phone=" + phone + ", sex=" + sex + ", age=" + age + ", create_date=" + create_date
				+ ", update_date=" + update_date + "]";
	}

}
