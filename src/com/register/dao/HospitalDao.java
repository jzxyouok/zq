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
import com.register.entity.Hospital;
/**
 * 
 * @Description:医院操作类
 * @author 张倩
 * @date:2016年3月25日上午10:10:10
 */
public class HospitalDao {
	
	/**
	 * 增加医院记录
	 * @param h
	 * @throws Exception
	 */
	public void addHospital(Hospital h) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into hospital" +
				"(name,password)" +
				"values(" +
				"?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, h.getName());
		ptmt.setString(2, h.getPassword());
		
		ptmt.execute();
	}
	
	/**
	 * 更新医院记录
	 * @param h
	 * @throws SQLException
	 */
	public void updateHospital(Hospital h) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" update hospital " +
				" set name=?,password=? " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, h.getName());
		ptmt.setString(2, h.getPassword());
		ptmt.setInt(3, h.getId());
		ptmt.execute();
	}
	
	/**
	 * 删除医院记录
	 * @param id
	 * @throws SQLException
	 */
	public void delHospital(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" delete from Hospital " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	
	/**
	 * 查询医院记录
	 * @return
	 * @throws Exception
	 */
	public List<Hospital> query() throws Exception{
		List<Hospital> result=new ArrayList<Hospital>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,name, from hospital  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Hospital h=null;
		while(rs.next()){
			h=new Hospital();
			h.setId(rs.getInt("id"));
			h.setName(rs.getString("name"));
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 根据医院名称模糊查询医院记录
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public List<Hospital> query(String name) throws Exception{
		List<Hospital> result=new ArrayList<Hospital>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from hospital  ");
		
		sb.append(" where name like ? ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Hospital h=null;
		while(rs.next()){
			h=new Hospital();
			h.setId(rs.getInt("id"));
			h.setName(rs.getString("name"));
			
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 根据组合条件查询医院记录
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Hospital> query(List<Map<String, Object>> params) throws Exception{
		List<Hospital> result=new ArrayList<Hospital>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from hospital where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Hospital h=null;
		while(rs.next()){
			h=new Hospital();
			h.setId(rs.getInt("id"));
			h.setName(rs.getString("name"));
			result.add(h);
		}
		return result;
	}
	
	/**
	 * 通过id获得单个医院记录
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Hospital get(Integer id) throws SQLException{
		Hospital h=null;
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" select * from hospital " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			h=new Hospital();
			h.setId(rs.getInt("id"));
			h.setName(rs.getString("name"));
			h.setPassword(rs.getString("password"));
		}
		return h;
	}
}
