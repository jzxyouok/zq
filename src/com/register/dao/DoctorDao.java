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
import com.register.entity.Doctor;

/**
 * 
 * @Description:医生的操作类
 * @author 张倩
 * @date:2016年3月25日上午8:54:30
 */
public class DoctorDao {
	
	/**
	 * 增加医生记录
	 * @param d
	 * @throws Exception
	 */
	public void addDoctor(Doctor d) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into doctor" +
				"(name,password,sex,department_id,hospital_id)" +
				"values(" +
				"?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, d.getName());
		ptmt.setString(2, d.getPassword());
		ptmt.setString(3, d.getSex());
		ptmt.setInt(4, d.getDepartmet_id());
		ptmt.setInt(5, d.getHospital_id());
		ptmt.execute();
	}
	
	/**
	 * 更新医生记录
	 * @param d
	 * @throws SQLException
	 */
	public void updateDoctor(Doctor d) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" update doctor " +
				" set name=?,password=?,sex=?,department_id=?,hospital_id=? " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, d.getName());
		ptmt.setString(2, d.getPassword());
		ptmt.setString(3, d.getSex());
		ptmt.setInt(4, d.getDepartmet_id());
		ptmt.setInt(5, d.getHospital_id());
		ptmt.setInt(6, d.getId());
		ptmt.execute();
	}
	
	/**
	 * 根据医生id删除医生记录
	 * @param id
	 * @throws SQLException
	 */
	public void delDoctor(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" delete from Doctor " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	
	/**
	 * 查询查询所有医生记录
	 * @return	List<Doctor>
	 * @throws Exception
	 */
	public List<Doctor> query() throws Exception{
		List<Doctor> result=new ArrayList<Doctor>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,name,department_id,hospital_id from doctor  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Doctor d=null;
		while(rs.next()){
			d=new Doctor();
			d.setId(rs.getInt("id"));
			d.setName(rs.getString("name"));
			d.setDepartmet_id(rs.getInt("department_id"));
			d.setHospital_id(rs.getInt("hospital_id"));
			result.add(d);
		}
		return result;
	}
	
	/**
	 * 根据姓名，医院，科室模糊查询医生记录
	 * @param name
	 * @param department_id
	 * @param hospital_id
	 * @return
	 * @throws Exception
	 */
	public List<Doctor> query(String name,int department_id,int hospital_id) throws Exception{
		List<Doctor> result=new ArrayList<Doctor>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from doctor  ");
		
		sb.append(" where name like ? and department_id=? and hospital_id=?");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		ptmt.setInt(2, department_id);
		ptmt.setInt(3, hospital_id);
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Doctor d=null;
		while(rs.next()){
			d=new Doctor();
			d.setId(rs.getInt("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setDepartmet_id(rs.getInt("department_id"));
			d.setHospital_id(rs.getInt("hospital_id"));
			
			result.add(d);
		}
		return result;
	}
	
	/**
	 * 
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Doctor> query(List<Map<String, Object>> params) throws Exception{
		List<Doctor> result=new ArrayList<Doctor>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from doctor where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Doctor d=null;
		while(rs.next()){
			d=new Doctor();
			d.setId(rs.getInt("id"));
			d.setName(rs.getString("name"));
			d.setSex(rs.getString("sex"));
			d.setDepartmet_id(rs.getInt("department_id"));
			d.setHospital_id(rs.getInt("hospital_id"));
			result.add(d);
		}
		return result;
	}
	
	/**
	 * 根据id获取医生记录
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Doctor get(Integer id) throws SQLException{
		Doctor d=null;
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" select * from doctor " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			d=new Doctor();
			d.setId(rs.getInt("id"));
			d.setName(rs.getString("name"));
			d.setPassword(rs.getString("password"));
			d.setSex(rs.getString("sex"));
			d.setDepartmet_id(rs.getInt("departmet_id"));
			d.setHospital_id(rs.getInt("hospital_id"));
		}
		return d;
	}
}
