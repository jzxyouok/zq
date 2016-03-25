package com.register.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.register.db.DBUtil;
import com.register.entity.Patient;

/**
 * 
 * @Description:病人操作类
 * @author 张倩
 * @date:2016年3月25日上午11:11:48
 */
public class PatientDao {

	public void addPatient(Patient p) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into patient" +
				"(name,password,sex,age,card_id,phone,allergen,create_date,update_date," +
				"values(" +
				"?,?,?,?,?,?,?,current_date(),current_date())";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, p.getName());
		ptmt.setString(2, p.getPassword());
		ptmt.setString(3, p.getSex());
		ptmt.setInt(4, p.getAge());
		ptmt.setString(5, p.getCardID());
		ptmt.setString(6, p.getPhone());
		ptmt.setString(7, p.getAllergen());
		ptmt.execute();
	}
	
	public void updatePatient(Patient p) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" update patient " +
				" set name=?,password=?,sex=?,age=?,card_id=?,phone=?,allergen=?, " +
				" update_date=current_date() " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, p.getName());
		ptmt.setString(2, p.getPassword());
		ptmt.setString(3, p.getSex());
		ptmt.setInt(4, p.getAge());
		ptmt.setString(5, p.getCardID());
		ptmt.setString(6, p.getPhone());
		ptmt.setString(7, p.getAllergen());
		ptmt.execute();
	}
	
	public void delPatient(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" delete from patient " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	public List<Patient> query() throws Exception{
		List<Patient> result=new ArrayList<Patient>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		//有问题，待解决
		sb.append("select id,name,age from patient  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		Patient p=null;
		while(rs.next()){
			p=new Patient();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setSex(rs.getString("sex"));
			p.setAge(rs.getInt("age"));
			p.setCardID(rs.getString("card_iD"));
			p.setPhone(rs.getString("phone"));
			p.setCreate_date(rs.getDate("create_date"));
			p.setUpdate_date(rs.getDate("update_date"));
			
			result.add(p);
		}
		return result;
	}
	public List<Patient> query(String name) throws Exception{
		List<Patient> result=new ArrayList<Patient>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from patient  ");
		
		sb.append(" where user_name like ? ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Patient p=null;
		while(rs.next()){
			p=new Patient();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setSex(rs.getString("sex"));
			p.setAge(rs.getInt("age"));
			p.setCardID(rs.getString("card_iD"));
			p.setPhone(rs.getString("phone"));
			p.setCreate_date(rs.getDate("create_date"));
			p.setUpdate_date(rs.getDate("update_date"));
			
			result.add(p);
		}
		return result;
	}
	public List<Patient> query(List<Map<String, Object>> params) throws Exception{
		List<Patient> result=new ArrayList<Patient>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from patient where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Patient p=null;
		while(rs.next()){
			p=new Patient();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setSex(rs.getString("sex"));
			p.setAge(rs.getInt("age"));
			p.setCardID(rs.getString("card_iD"));
			p.setPhone(rs.getString("phone"));
			p.setCreate_date(rs.getDate("create_date"));
			p.setUpdate_date(rs.getDate("update_date"));
			
			result.add(p);
		}
		return result;
	}

	public Patient get(Integer id) throws SQLException {
		Patient p = null;
		Connection conn = DBUtil.getConnection();
		String sql = "" + " select * from patient " + " where id=? ";
		PreparedStatement ptmt = conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			p=new Patient();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPassword(rs.getString("password"));
			p.setSex(rs.getString("sex"));
			p.setAge(rs.getInt("age"));
			p.setCardID(rs.getString("card_iD"));
			p.setPhone(rs.getString("phone"));
			p.setCreate_date(rs.getDate("create_date"));
			p.setUpdate_date(rs.getDate("update_date"));
		}
		return p;
	}
}
