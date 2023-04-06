package com.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
//import java.util.Date;
import java.sql.Date;
import java.text.SimpleDateFormat;

import com.bg.converter.Converter;
import com.bg.dto.BorrowDTO;
import com.bg.dto.StudentDTO;


public class BorrowDAOImlp implements BorrowDAO<BorrowDTO> {

	private Connection jdbcConnection;
	

	public BorrowDAOImlp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BorrowDTO> list() throws SQLException {
		ArrayList<BorrowDTO> ds = new ArrayList<BorrowDTO>();
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select br.BorrowID, bo.BookID, bo.Name as BookName, br.BorrowDate, st.StudentID, st.Name as StudentName, br.Quantity\r\n"
				+ "from borrows as br left join books as bo on br.BookID = bo.BooKID\r\n"
				+ "	left join students as st on br.StudentID = st.StudentID;";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int borrowId = resultSet.getInt("BorrowID");
			int studentId = resultSet.getInt("StudentID");
			String BookName = resultSet.getString("BookName");
			String StudentName = resultSet.getString("StudentName");
			int bookId = resultSet.getInt("BooKID");
			int quantity = resultSet.getInt("Quantity");
			Date dateBorrow = resultSet.getDate("BorrowDate");

			ds.add(new BorrowDTO(borrowId, studentId, bookId, quantity, dateBorrow, StudentName, BookName));
		}

		resultSet.close();
		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return ds;
	}

	@Override
	public boolean add(BorrowDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "insert into borrows (StudentID,BookID,Quantity,BorrowDate) values(?,?,?,?)";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, data.getStudentID());
		statement.setInt(2, data.getBookID());
		statement.setInt(3, data.getQuantity());
		statement.setDate(4, (java.sql.Date) data.getBorrowDate());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public ArrayList<BorrowDTO> search(String E, String S, String Word) throws SQLException {
		ArrayList<BorrowDTO> ds = new ArrayList<BorrowDTO>();
		jdbcConnection = MySQLConnect.connectDb();
		String sql1 = "select br.BorrowID, bo.BookID, bo.Name as BookName, br.BorrowDate, \r\n"
				+ "	st.StudentID, st.Name as StudentName, br.Quantity\r\n"
				+ "from borrows as br left join books as bo on br.BookID = bo.BookID\r\n"
				+ "	left join students as st on br.StudentID = st.StudentID\r\n"
				+ "where (st.StudentID like ? or st.Name like ? or bo.BookID like ? or bo.Name like ?) \r\n"
				+ "and (br.BorrowDate between ? AND ?)";

		String sql2 = "select br.BorrowID, bo.BookID, bo.Name as BookName, br.BorrowDate, \r\n"
				+ "	st.StudentID, st.Name as StudentName, br.Quantity\r\n"
				+ "from borrows as br left join books as bo on br.BookID = bo.BookID\r\n"
				+ "	left join students as st on br.StudentID = st.StudentID\r\n"
				+ "where (st.StudentID like ? or st.Name like ? or bo.BookID like ? or bo.Name like ?) \r\n"
				+ "or br.BorrowDate = ?";

		String sql3 = "select br.BorrowID, bo.BookID, bo.Name as BookName, br.BorrowDate, \r\n"
				+ "	st.StudentID, st.Name as StudentName, br.Quantity\r\n"
				+ "from borrows as br left join books as bo on br.BookID = bo.BookID\r\n"
				+ "	left join students as st on br.StudentID = st.StudentID\r\n" + "where "
				+ "(st.StudentID like ? or st.Name like ? or bo.BookID like ? or bo.Name like ?) "
				+ "and (br.BorrowDate like ?) ";

		if (E == "" && S == "") {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql2);
			statement.setString(1, Word);
			statement.setString(2, "%" + Word + "%");
			statement.setString(3, Word);
			statement.setString(4, "%" + Word + "%");
//			if (isValidDate(keyWord))
			if(Converter.isValidDate(Word))
				statement.setString(5, Word);
			else
				statement.setString(5, null);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int borrowId = resultSet.getInt("BorrowID");
				int studentId = resultSet.getInt("StudentID");
				String BookName = resultSet.getString("BookName");
				String StudentName = resultSet.getString("StudentName");
				int bookId = resultSet.getInt("BooKID");
				int quantity = resultSet.getInt("Quantity");
				Date dateBorrow = resultSet.getDate("BorrowDate");

				ds.add(new BorrowDTO(borrowId, studentId, bookId, quantity, dateBorrow, StudentName, BookName));
			}

			resultSet.close();
			statement.close();

		} else if (E == "") {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql3);
			statement.setString(1, Word);
			statement.setString(2, "%" + Word + "%");
			statement.setString(3, Word);
			statement.setString(4, "%" + Word + "%");
			statement.setString(5, S);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int borrowId = resultSet.getInt("BorrowID");
				int studentId = resultSet.getInt("StudentID");
				String BookName = resultSet.getString("BookName");
				String StudentName = resultSet.getString("StudentName");
				int bookId = resultSet.getInt("BooKID");
				int quantity = resultSet.getInt("Quantity");
				Date dateBorrow = resultSet.getDate("BorrowDate");

				ds.add(new BorrowDTO(borrowId, studentId, bookId, quantity, dateBorrow, StudentName, BookName));
			}

			resultSet.close();
			statement.close();
		} else {
			PreparedStatement statement = jdbcConnection.prepareStatement(sql1);
			statement.setString(1, Word);
			statement.setString(2, "%" + Word + "%");
			statement.setString(3, Word);
			statement.setString(4, "%" + Word + "%");
			statement.setString(5, S);
			statement.setString(6, E);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int borrowId = resultSet.getInt("BorrowID");
				int studentId = resultSet.getInt("StudentID");
				String BookName = resultSet.getString("BookName");
				String StudentName = resultSet.getString("StudentName");
				int bookId = resultSet.getInt("BooKID");
				int quantity = resultSet.getInt("Quantity");
				Date dateBorrow = resultSet.getDate("BorrowDate");

				ds.add(new BorrowDTO(borrowId, studentId, bookId, quantity, dateBorrow, StudentName, BookName));
			}
			resultSet.close();
			statement.close();
		}

		MySQLConnect.disconnect(jdbcConnection);
		return ds;
	}

	@Override
	public boolean updateQuantity(int quantity, int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}



}
