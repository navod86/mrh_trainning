package com.bg.dto;

public class StudentDTO {
	private int StudentID;
	private String Name;
	private int Age;
	private boolean Gender;
	private boolean InUsed;
	
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDTO(int studentID, String name, int age, boolean gender) {
		super();
		StudentID = studentID;
		Name = name;
		Age = age;
		Gender = gender;
	}

	public StudentDTO(String name, int age, boolean gender) {
		super();
		Name = name;
		Age = age;
		Gender = gender;
	}
	
	public StudentDTO(int studentID, String name, int age, boolean gender, boolean inUsed) {
		super();
		StudentID = studentID;
		Name = name;
		Age = age;
		Gender = gender;
		InUsed = inUsed;
	}

	public int getStudentID() {
		return StudentID;
	}

	public void setStudentID(int studentID) {
		StudentID = studentID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public boolean isGender() {
		return Gender;
	}

	public void setGender(boolean gender) {
		Gender = gender;
	}

	public boolean isInUsed() {
		return InUsed;
	}

	public void setInUsed(boolean inUsed) {
		InUsed = inUsed;
	}

	
}
