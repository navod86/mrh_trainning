package com.bg.service;

import java.sql.SQLException;
import java.util.ArrayList;

public interface BorrowService<T> {
    ArrayList<T> List() throws SQLException;
	
	boolean Add(T data) throws SQLException;

	ArrayList<T> Search(String E, String S, String Word) throws SQLException;

	boolean UpdateQuantity(int quantity, int id) throws SQLException;
}
