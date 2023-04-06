package com.bg.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bg.dto.BookDTO;
import com.bg.dto.StudentDTO;

public class StudentDAOImlp implements CommonDAO<StudentDTO>{
	private Connection jdbcConnection;

	public StudentDAOImlp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<StudentDTO> list() throws SQLException {
		ArrayList<StudentDTO> ds = new ArrayList<StudentDTO>();

		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select * from students";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int studentId = resultSet.getInt("StudentID");
			String name = resultSet.getString("Name");
			int age = resultSet.getInt("Age");
			boolean gender = resultSet.getBoolean("Gender");

			ds.add(new StudentDTO(studentId, name, age, gender, InUsed(studentId)));
		}

		resultSet.close();
		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return ds;
	}

	@Override
	public boolean add(StudentDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "insert into Students (Name,Age,Gender) values(?,?,?)";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getAge());
		statement.setBoolean(3, data.isGender());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public boolean update(StudentDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "UPDATE students SET Name = ?, Age = ?, Gender = ?  WHERE StudentID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getAge());
		statement.setBoolean(3, data.isGender());
		statement.setInt(4, data.getStudentID());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public boolean delete(StudentDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "DELETE FROM students where StudentID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);

		statement.setInt(1, data.getStudentID());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public StudentDTO getDataById(int id) throws SQLException {
		// TODO Auto-generated method stub
		StudentDTO student = null;

	    jdbcConnection = MySQLConnect.connectDb();
	    String sql = "select * from students where StudentID = ?";

	    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    statement.setInt(1, id);
	    ResultSet resultSet = statement.executeQuery();

	    while (resultSet.next()) {
	      String name = resultSet.getString("Name");
	      int age = resultSet.getInt("Age");
	      boolean gender = resultSet.getBoolean("Gender");
	      

	      student = new StudentDTO(id, name, age, gender);
	    }

	    resultSet.close();
	    statement.close();
	    MySQLConnect.disconnect(jdbcConnection);
	    return student;
	}

	@Override
	public boolean InUsed(int id) throws SQLException{
		int idCount = 0;
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select count(StudentID) as soluong from borrows where StudentID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			idCount = resultSet.getInt("soluong");
		}

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);

		if (idCount == 0)
			return true;
		else
			return false;
	}

}
