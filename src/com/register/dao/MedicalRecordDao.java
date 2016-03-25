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
import com.register.entity.MedicalRecord;

public class MedicalRecordDao {

	/**
	 * 增加病历
	 * @param m
	 * @throws Exception
	 */
	public void addMedicalRecord(MedicalRecord m) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into medicalrecord" +
				"(patient_id,doctor_name,hospital_name," +
				"create_date,context,note)" +
				"values(" +
				"?,?,?,current_date(),?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, m.getPatient_id());
		ptmt.setString(2, m.getDoctor_name());
		ptmt.setString(3, m.getHospital_name());
		ptmt.setDate(4, new Date(m.getCreate_date().getTime()));
		ptmt.setString(5, m.getContext());
		ptmt.setString(6, m.getNote());
		ptmt.execute();
	}
	
//	public void updateMedicalRecord(MedicalRecord m) throws SQLException{
//		Connection conn=DBUtil.getConnection();
//		String sql="" +
//				" update medicalrecord " +
//				" set patient_id=?,sex=?,age=?,birthday=?,email=?,mobile=?, " +
//				" update_user=?,update_date=current_date(),isdel=? " +
//				" where id=? ";
//		PreparedStatement ptmt=conn.prepareStatement(sql);
//		
//		ptmt.setString(1, g.getUser_name());
//		ptmt.setInt(2, g.getSex());
//		ptmt.setInt(3, g.getAge());
//		ptmt.setDate(4, new Date(g.getBirthday().getTime()));
//		ptmt.setString(5, g.getEmail());
//		ptmt.setString(6, g.getMobile());
//		ptmt.setString(7, g.getUpdate_user());
//		ptmt.setInt(8, g.getIsdel());
//		ptmt.setInt(9, g.getId());
//		ptmt.execute();
//	}
//	
	/**
	 * 删除指定病人病历（业务尚且不需要）
	 * @param id
	 * @throws SQLException
	 */
	public void delMedicalRecord(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" delete from medicalrecord " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
//	public List<MedicalRecord> query() throws Exception{
//		List<MedicalRecord> result=new ArrayList<MedicalRecord>();
//		
//		Connection conn=DBUtil.getConnection();
//		StringBuilder sb=new StringBuilder();
//		sb.append("select id,patient_id,doctor_name,age from medicalrecord  ");
//		
//		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
//		
//		ResultSet rs=ptmt.executeQuery();
//		
//		Goddess g=null;
//		while(rs.next()){
//			g=new Goddess();
//			g.setId(rs.getInt("id"));
//			g.setUser_name(rs.getString("user_name"));
//			g.setAge(rs.getInt("age"));
//			result.add(g);
//		}
//		return result;
//	}
	
	/**
	 * 查询指定病人的病历
	 * @param patient_id
	 * @return
	 * @throws Exception
	 */
	public List<MedicalRecord> query(int patient_id) throws Exception{
		List<MedicalRecord> result=new ArrayList<MedicalRecord>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from medicalrecord  ");
		
		sb.append(" where patient_id=?");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setInt(1, patient_id);
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		MedicalRecord m=null;
		while(rs.next()){
			m=new MedicalRecord();
			m.setId(rs.getInt("id"));
			m.setPatient_id(rs.getInt("patient_id"));
			m.setDoctor_name(rs.getString("doctor_name"));
			m.setHospital_name(rs.getString("hospital_name"));
			m.setCreate_date(rs.getDate("create_date"));
			m.setContext(rs.getString("context"));
			m.setNote(rs.getString("note"));
			
			result.add(m);
		}
		return result;
	}
	public List<MedicalRecord> query(List<Map<String, Object>> params) throws Exception{
		List<MedicalRecord> result=new ArrayList<MedicalRecord>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from medicalrecord where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		MedicalRecord m=null;
		while(rs.next()){
			m=new MedicalRecord();
			m.setId(rs.getInt("id"));
			m.setPatient_id(rs.getInt("patient_id"));
			m.setDoctor_name(rs.getString("doctor_name"));
			m.setHospital_name(rs.getString("hospital_name"));
			m.setCreate_date(rs.getDate("create_date"));
			m.setContext(rs.getString("context"));
			m.setNote(rs.getString("note"));
			
			result.add(m);
		}
		return result;
	}
	public MedicalRecord get(Integer id) throws SQLException{
		MedicalRecord m=null;
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" select * from medicalrecord " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			m=new MedicalRecord();
			m.setId(rs.getInt("id"));
			m.setPatient_id(rs.getInt("patient_id"));
			m.setDoctor_name(rs.getString("doctor_name"));
			m.setHospital_name(rs.getString("hospital_name"));
			m.setCreate_date(rs.getDate("create_date"));
			m.setContext(rs.getString("context"));
			m.setNote(rs.getString("note"));
		}
		return m;
	}
}
