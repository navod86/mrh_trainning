package com.bg.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.bg.dao.BorrowDAO;
import com.bg.dao.BorrowDAOImlp;
import com.bg.dto.BorrowDTO;

public class BorrowServiceImpl implements BorrowService<BorrowDTO> {

	private BorrowDAO<BorrowDTO> borrowDao;
	

	public BorrowServiceImpl() {
		this.borrowDao = new BorrowDAOImlp();
	}

	@Override
	public ArrayList<BorrowDTO> List() throws SQLException {
		return this.borrowDao.list();
	}

	@Override
	public boolean Add(BorrowDTO data) throws SQLException {
		return this.borrowDao.add(data);
	}

	@Override
	public ArrayList<BorrowDTO> Search(String E, String S, String Word) throws SQLException {
		return this.borrowDao.search(E, S, Word);
	}

	@Override
	public boolean UpdateQuantity(int quantity, int id) throws SQLException {
		return this.borrowDao.updateQuantity(quantity, id);
	}
}

