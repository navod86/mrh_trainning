package com.bg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.dto.StudentDTO;
import com.bg.service.CommonService;
import com.bg.service.StudentServiceImpl;

/**
 * Servlet implementation class studentController
 */
@WebServlet("/student")
public class studentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private CommonService<StudentDTO> studentService;

	public void init() {
		this.studentService = new StudentServiceImpl();
	}
    public studentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");

	    String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
		try {
			switch (action) {
			case "new":
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/StudentView/editStudent.jsp");
				dispatcher.forward(request, response);
				break;
			case "insert":
				this.addStudent(request, response);
				break;
			case "delete":
				this.deleteStudent(request, response);
				break;
			case "edit":
				this.showEditForm(request, response);
				break;
			case "update":
				this.updateStudent(request, response);
				break;
			default:
				this.showStudentList(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		boolean gen = true;
		if(gender.equals("0")) 
			gen = false;
		StudentDTO newStudent = new StudentDTO(name, age, gen);
		this.studentService.Add(newStudent);
		response.sendRedirect("student");
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		boolean gen = true;
		if(gender == "0") 
			gen = false;

		StudentDTO newStudent = new StudentDTO(id, name, age, gen);
		this.studentService.Update(newStudent);
		response.sendRedirect("student");
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		StudentDTO studentDel = studentService.getDataById(id);
		if (studentService.InUsed(id)) {
			this.studentService.Delete(studentDel);
		}
		response.sendRedirect("student");
	}

	private void showStudentList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		ArrayList<StudentDTO> ds = this.studentService.List();
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/StudentView/studentManagement.jsp");
		request.setAttribute("studentList", ds);
		dispatcher.forward(request, response);
	}


	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int studentId = Integer.valueOf(request.getParameter("id"));
		StudentDTO student = this.studentService.getDataById(studentId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/StudentView/editStudent.jsp");
		request.setAttribute("student", student);
		dispatcher.forward(request, response);
	}

}
