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
import com.register.entity.Department;
/**
 * 
 * @Description:科室类（数据库写死，业务暂不需要）
 * @author 张倩
 * @date:2016年3月25日上午9:38:14
 */
public class DepartmentDao {

//	public void addDepartment(Department d) throws Exception{
//		Connection conn=DBUtil.getConnection();
//		String sql="" +
//				"insert into Department" +
//				"(name)" +
//				"values(" +
//				"?)";
//		PreparedStatement ptmt=conn.prepareStatement(sql);
//		
//		ptmt.setString(1, d.getName());
//		
//		ptmt.execute();
//	}
//	
//	public void updateDepartment(Department d) throws SQLException{
//		Connection conn=DBUtil.getConnection();
//		String sql="" +
//				" update Department " +
//				" set name=? " +
//				" where id=? ";
//		PreparedStatement ptmt=conn.prepareStatement(sql);
//		
//		ptmt.setString(1, d.getName());
//		ptmt.setInt(2, d.getId());
//		ptmt.execute();
//	}
//	
//	public void delDepartmen(Integer id) throws SQLException{
//		Connection conn=DBUtil.getConnection();
//		String sql="" +
//				" delete from Departmen " +
//				" where id=? ";
//		PreparedStatement ptmt=conn.prepareStatement(sql);
//		
//		ptmt.setInt(1, id);
//		ptmt.execute();
//	}
//	
//	public List<Department> query() throws Exception{
//		List<Department> result=new ArrayList<Department>();
//		
//		Connection conn=DBUtil.getConnection();
//		StringBuilder sb=new StringBuilder();
//		sb.append("select id,name from Department  ");
//		
//		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
//		
//		ResultSet rs=ptmt.executeQuery();
//		
//		Department d=null;
//		while(rs.next()){
//			d=new Department();
//			d.setId(rs.getInt("id"));
//			d.setName(rs.getString("name"));
//			
//			result.add(d);
//		}
//		return result;
//	}
//	public List<Department> query(String name) throws Exception{
//		List<Department> result=new ArrayList<Department>();
//		
//		Connection conn=DBUtil.getConnection();
//		StringBuilder sb=new StringBuilder();
//		sb.append("select * from Department  ");
//		
//		sb.append(" where name like ? ");
//		
//		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
//		ptmt.setString(1, "%"+name+"%");
//		System.out.println(sb.toString());
//		ResultSet rs=ptmt.executeQuery();
//		
//		Department d=null;
//		while(rs.next()){
//			d=new Department();
//			d.setId(rs.getInt("id"));
//			d.setName(rs.getString("name"));
//			
//			result.add(d);
//		}
//		return result;
//	}
//	public List<Department> query(List<Map<String, Object>> params) throws Exception{
//		List<Department> result=new ArrayList<Department>();
//		
//		Connection conn=DBUtil.getConnection();
//		StringBuilder sb=new StringBuilder();
//		sb.append("select * from department where 1=1 ");
//		
//		if(params!=null&&params.size()>0){
//			for (int i = 0; i < params.size(); i++) {
//				Map<String, Object> map=params.get(i);
//				sb.append(" and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
//			}
//		}
//		
//		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
//		
//		System.out.println(sb.toString());
//		ResultSet rs=ptmt.executeQuery();
//		
//		Department d=null;
//		while(rs.next()){
//			d=new Department();
//			d.setId(rs.getInt("id"));
//			d.setName(rs.getString("name"));
//			result.add(d);
//		}
//		return result;
//	}
//	public Department get(Integer id) throws SQLException{
//		Department d=null;
//		Connection conn=DBUtil.getConnection();
//		String sql="" +
//				" select * from department " +
//				" where id=? ";
//		PreparedStatement ptmt=conn.prepareStatement(sql);
//		
//		ptmt.setInt(1, id);
//		ResultSet rs=ptmt.executeQuery();
//		while(rs.next()){
//			d=new Department();
//			d.setId(rs.getInt("id"));
//			d.setName(rs.getString("name"));
//	}
//		return d;
//	}
}
