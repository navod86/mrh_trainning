package com.bg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bg.dto.BookDTO;


public class BookDAOImlp implements CommonDAO<BookDTO> {
	private Connection jdbcConnection;

	public BookDAOImlp() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<BookDTO> list() throws SQLException {
		ArrayList<BookDTO> ds = new ArrayList<BookDTO>();

		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select * from books";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
		while (resultSet.next()) {
			int bookId = resultSet.getInt("BookID");
			String name = resultSet.getString("Name");
			int totalPage = resultSet.getInt("TotalPage");
			String type = resultSet.getString("Type");
			int quantity = resultSet.getInt("Quantity");

			ds.add(new BookDTO(bookId, name, totalPage, type, quantity, InUsed(bookId)));
		}

		resultSet.close();
		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return ds;
	}

	@Override
	public boolean add(BookDTO data) throws SQLException {

		jdbcConnection = MySQLConnect.connectDb();
		String sql = "insert into books (Name, TotalPage, Type, Quantity) values (?, ?, ?, ?)";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getTotalPage());
		statement.setString(3, data.getType());
		statement.setInt(4, data.getQuantity());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public boolean update(BookDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "update books set Name = ?, TotalPage = ?, Type = ?, Quantity = ? where BooKID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, data.getName());
		statement.setInt(2, data.getTotalPage());
		statement.setString(3, data.getType());
		statement.setInt(4, data.getQuantity());
		statement.setInt(5, data.getBookID());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public boolean delete(BookDTO data) throws SQLException {
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "delete from books where  BooKID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);

		statement.setInt(1, data.getBookID());

		boolean result = statement.executeUpdate() > 0;

		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return result;
	}

	@Override
	public BookDTO getDataById(int id) throws SQLException {
		BookDTO book = null;

		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select * from books where BookID = ?";

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			int bookId = resultSet.getInt("BookID");
			String name = resultSet.getString("Name");
			int totalPage = resultSet.getInt("TotalPage");
			String type = resultSet.getString("Type");
			int quantity = resultSet.getInt("Quantity");

			book = new BookDTO(bookId, name, totalPage, type, quantity);
		}

		resultSet.close();
		statement.close();
		MySQLConnect.disconnect(jdbcConnection);
		return book;
	}

	@Override
	public boolean InUsed(int id) throws SQLException {
		int idCount = 0;
		jdbcConnection = MySQLConnect.connectDb();
		String sql = "select count(BookID) as soluong from borrows where BookID = ?";

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

	
//	public static void main(String[] args) {
//		BookDAOImlp boo = new BookDAOImlp();
//		try {
//			System.out.println(boo.InUsed(8));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
