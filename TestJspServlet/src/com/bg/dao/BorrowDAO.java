package com.bg.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BorrowDAO<T> {
	ArrayList<T> list() throws SQLException;
	
	boolean add(T data) throws SQLException;

	ArrayList<T> search(String E, String S, String Word) throws SQLException;

	boolean updateQuantity(int quantity, int id) throws SQLException;
}
