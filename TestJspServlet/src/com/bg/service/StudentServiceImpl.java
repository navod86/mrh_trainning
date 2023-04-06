package com.bg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bg.dao.CommonDAO;
import com.bg.dao.StudentDAOImlp;
import com.bg.dto.StudentDTO;

public class StudentServiceImpl implements CommonService<StudentDTO>{
	
	private CommonDAO<StudentDTO> studentDao;
	
	public StudentServiceImpl() {
		this.studentDao = new StudentDAOImlp();
	}

	@Override
	public ArrayList<StudentDTO> List() throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.list();
	}

	@Override
	public boolean Add(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.add(data);
	}

	@Override
	public boolean Update(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.update(data);
	}

	@Override
	public boolean Delete(StudentDTO data) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.delete(data);
	}

	@Override
	public StudentDTO getDataById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.getDataById(id);
	}

	@Override
	public boolean InUsed(int id) throws SQLException {
		// TODO Auto-generated method stub
		return this.studentDao.InUsed(id);
	}
}

