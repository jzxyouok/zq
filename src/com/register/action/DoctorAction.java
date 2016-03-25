package com.register.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.register.dao.DoctorDao;
import com.register.entity.Doctor;

public class DoctorAction {

	public void addDoctor(Doctor doctor) throws Exception{
		DoctorDao dao=new DoctorDao();
		dao.addDoctor(doctor);
	}
	
	public Doctor getDoctor(Integer id) throws SQLException{
		DoctorDao dao=new DoctorDao();
		return dao.get(id);
	}
	
	public void editDoctor(Doctor doctor) throws Exception{
		DoctorDao dao=new DoctorDao();
		dao.updateDoctor(doctor);
	}
	public void delDoctor(Integer id) throws SQLException{
		DoctorDao dao=new DoctorDao();
		dao.delDoctor(id);
	}
	
	public List<Doctor>  query() throws Exception{
		DoctorDao dao=new DoctorDao();
		return dao.query();
	}
	public List<Doctor> query(List<Map<String, Object>> params) throws Exception{
		DoctorDao dao=new DoctorDao();
		return dao.query(params);
	}
}
