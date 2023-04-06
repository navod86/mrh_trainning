package com.bg.dto;

public class BookDTO {
	private int BookID;
	private String Name;
	private int TotalPage;
	private String type;
	private int Quantity;
	private boolean InUsed;

	public BookDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookDTO(int bookID, String name, int totalPage, String type, int quantity) {
		super();
		BookID = bookID;
		Name = name;
		TotalPage = totalPage;
		this.type = type;
		Quantity = quantity;
	}

	public BookDTO(String name, int totalPage, String type, int quantity) {
		super();
		Name = name;
		TotalPage = totalPage;
		this.type = type;
		Quantity = quantity;
	}

	public BookDTO(int bookID, String name, int totalPage, String type, int quantity, boolean inUsed) {
		super();
		BookID = bookID;
		Name = name;
		TotalPage = totalPage;
		this.type = type;
		Quantity = quantity;
		InUsed = inUsed;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getTotalPage() {
		return TotalPage;
	}

	public void setTotalPage(int totalPage) {
		TotalPage = totalPage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public boolean isInUsed() {
		return InUsed;
	}

	public void setInUsed(boolean inUsed) {
		InUsed = inUsed;
	}
}
	

