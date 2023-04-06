package com.bg.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.bg.dto.BorrowDTO;

public interface CommonDAO<T> {
	ArrayList<T> list() throws SQLException;

	boolean add(T data) throws SQLException;

	boolean update(T data) throws SQLException;

	boolean delete(T data) throws SQLException;

	T getDataById(int id) throws SQLException;
	
	boolean InUsed(int id) throws SQLException;
	
}
