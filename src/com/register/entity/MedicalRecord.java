package com.register.entity;

import java.util.Date;

/**
 * 
 * @Description:病例类
 * @author 张倩
 * @date:2016年3月25日上午9:46:51
 */
public class MedicalRecord {
	private int id;// 病例id
	private String context;// 病例内容
	private int patient_id;// 患者id
	private String doctor_name;// 医生姓名
	private String hospital_name;// 医院
	private Date create_date;//创建时间

	private String note;// 处方
	

	public Date getCreate_date() {
		return create_date;
	}
	
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	
	public MedicalRecord() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "MedicalRecord [id=" + id + ", context=" + context + ", patient_id=" + patient_id + ", doctor_name="
				+ doctor_name + ", hospital_name=" + hospital_name + ", create_date=" + create_date + ", note=" + note
				+ "]";
	}

}
