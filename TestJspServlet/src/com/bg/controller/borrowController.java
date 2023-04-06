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

import com.bg.dto.BookDTO;
import com.bg.dto.BorrowDTO;
import com.bg.dto.StudentDTO;
import com.bg.service.BookServiceImpl;
import com.bg.service.BorrowService;
import com.bg.service.BorrowServiceImpl;
import com.bg.service.CommonService;
import com.bg.service.StudentServiceImpl;

/**
 * Servlet implementation class borrowController
 */
@WebServlet("/borrow")
public class borrowController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BorrowService<BorrowDTO> borrowService;
	private CommonService<StudentDTO> studentService;
	private CommonService<BookDTO> bookService;
	
	public void init() {
		this.borrowService = new BorrowServiceImpl();
		this.studentService = new StudentServiceImpl();
		this.bookService = new BookServiceImpl();
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public borrowController() {
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
				ArrayList<StudentDTO> dsStudent = this.studentService.List();
				ArrayList<BookDTO> dsBook = this.bookService.List();
				RequestDispatcher dispatcher = request.getRequestDispatcher("View/BorrowView/editBorrow.jsp");
				request.setAttribute("studentList", dsStudent);
				request.setAttribute("bookList", dsBook);
				dispatcher.forward(request, response);
				break;
			case "insert":
				this.addBorrow(request, response);
				break;
			case "search":
				this.searchList(request, response);
				break;
			default:
				this.showBorrowList(request, response);
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
	
	private void addBorrow(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
	
		BorrowDTO newBorrow = new BorrowDTO(studentId, bookId, quantity, date);
		this.borrowService.Add(newBorrow);
		response.sendRedirect("borrow");
	}
	
	private void showBorrowList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		ArrayList<BorrowDTO> ds = this.borrowService.List();
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/BorrowView/borrowManagement.jsp");
		request.setAttribute("borrowList", ds);
		dispatcher.forward(request, response);
	}
	
	private void searchList(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String sDay = request.getParameter("dateStart");
		String eDay = request.getParameter("dateEnd");
		String Word = request.getParameter("keyWord");
		if(sDay == "" || sDay==null) {
			sDay = "";
		}
		if(eDay == "" || eDay==null) {
			eDay = "";
		}
		if(Word == "" || Word==null) {
			Word = "";
		}
		System.out.println(sDay + " " + eDay + " " + Word);
		ArrayList<BorrowDTO> ds = this.borrowService.Search(eDay, sDay, Word);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("View/SearchView/index.jsp");
		request.setAttribute("borrowList", ds);
		request.setAttribute("startDay", sDay);
		request.setAttribute("endDay", eDay);
		request.setAttribute("keyWord", Word);
		dispatcher.forward(request, response);
	}

}
