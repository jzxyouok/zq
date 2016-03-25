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
import com.register.entity.Manager;

public class ManagerDao {

	public void addManager(Manager m) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into manager" +
				"(name,password)" +
				"values(" +
				"?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, m.getName());
		ptmt.setString(2, m.getPassword());
		
		ptmt.execute();
	}
	
	public void updateManager(Manager m) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" update manager " +
				" set name=?,password=? " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, m.getName());
		ptmt.setString(2, m.getPassword());
		ptmt.setInt(3, m.getId());
		ptmt.execute();
	}
	
	public void delManager(Integer id) throws SQLException{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" delete from Manager " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ptmt.execute();
	}
	
	public List<Manager> query() throws Exception{
		List<Manager> result=new ArrayList<Manager>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,name, from manager  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		Manager m=null;
		while(rs.next()){
			m=new Manager();
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			result.add(m);
		}
		return result;
	}
	public List<Manager> query(String name) throws Exception{
		List<Manager> result=new ArrayList<Manager>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from manager  ");
		
		sb.append(" where name like ? ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, "%"+name+"%");
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Manager m=null;
		while(rs.next()){
			m=new Manager();
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			
			result.add(m);
		}
		return result;
	}
	public List<Manager> query(List<Map<String, Object>> params) throws Exception{
		List<Manager> result=new ArrayList<Manager>();
		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select * from manager where 1=1 ");
		
		if(params!=null&&params.size()>0){
			for (int i = 0; i < params.size(); i++) {
				Map<String, Object> map=params.get(i);
				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
			}
		}
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		System.out.println(sb.toString());
		ResultSet rs=ptmt.executeQuery();
		
		Manager m=null;
		while(rs.next()){
			m=new Manager();
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			result.add(m);
		}
		return result;
	}
	public Manager get(Integer id) throws SQLException{
		Manager m=null;
		Connection conn=DBUtil.getConnection();
		String sql="" +
				" select * from manager " +
				" where id=? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()){
			m=new Manager();
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			m.setPassword(rs.getString("password"));
		}
		return m;
	}
}
