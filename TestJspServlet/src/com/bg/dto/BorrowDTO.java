package com.bg.dto;

import java.util.Date;

public class BorrowDTO {
	private int BorrowID;
	private int StudentID;
	private int BookID;
	private int Quantity;
	private Date BorrowDate;
	private String StudentName;
	private String BookName;
	

	public BorrowDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BorrowDTO(int borrowID, int studentID, int bookID, int quantity, Date borrowDate) {
		super();
		BorrowID = borrowID;
		StudentID = studentID;
		BookID = bookID;
		Quantity = quantity;
		BorrowDate = borrowDate;
	}

	public BorrowDTO(int studentID, int bookID, int quantity, Date borrowDate) {
		super();
		StudentID = studentID;
		BookID = bookID;
		Quantity = quantity;
		BorrowDate = borrowDate;
	}
	
	

	public BorrowDTO(int borrowID, int studentID, int bookID, int quantity, Date borrowDate, String studentName,
			String bookName) {
		super();
		BorrowID = borrowID;
		StudentID = studentID;
		BookID = bookID;
		Quantity = quantity;
		BorrowDate = borrowDate;
		StudentName = studentName;
		BookName = bookName;
	}

	public int getBorrowID() {
		return BorrowID;
	}

	public void setBorrowID(int borrowID) {
		BorrowID = borrowID;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public Date getBorrowDate() {
		return BorrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		BorrowDate = borrowDate;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	
}
