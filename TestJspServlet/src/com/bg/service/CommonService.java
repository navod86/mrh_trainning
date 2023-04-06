package com.bg.service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CommonService<T> {
	ArrayList<T> List() throws SQLException;

	boolean Add(T data) throws SQLException;

	boolean Update(T data) throws SQLException;

	boolean Delete(T data) throws SQLException;

	T getDataById(int id) throws SQLException;
	
	boolean InUsed(int id) throws SQLException;
}

