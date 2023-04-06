package com.bg.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bg.dto.BookDTO;
import com.bg.service.BookServiceImpl;
import com.bg.service.CommonService;

/**
 * Servlet implementation class bookController
 */
@WebServlet("/book")
public class bookController extends HttpServlet {
		private static final long serialVersionUID = 1L;

		private CommonService<BookDTO> bookService;

		public void init() {
			this.bookService = new BookServiceImpl();
		}

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public bookController() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");
		    response.setCharacterEncoding("UTF-8");

			String action = request.getParameter("action") != null ? request.getParameter("action") : "none";
			try {
				switch (action) {
				case "new":
					RequestDispatcher dispatcher = request.getRequestDispatcher("View/BooKView/editBook.jsp");
					dispatcher.forward(request, response);
					break;
				case "insert":
					this.addBook(request, response);
					break;
				case "delete":
					this.deleteBook(request, response);
					break;
				case "edit":
					this.showEditForm(request, response);
					break;
				case "update":
					this.updateBook(request, response);
					break;
				default:
					this.showBookList(request, response);
					break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

		private void addBook(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			String name = request.getParameter("name");
			int totalPage = Integer.parseInt(request.getParameter("totalPage"));
			String type = request.getParameter("type");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			BookDTO newBook = new BookDTO(name, totalPage, type, quantity);
			List<BookDTO> books = this.bookService.List();
			boolean hasDuplicateName = false;
			// Loop through all books to check for duplicate names
			for (BookDTO book : books) {
			    if (book.getName().equals(newBook.getName())) {
			        hasDuplicateName = true;
			        break;
			    }
			}
			if (hasDuplicateName) {
			    // Display error message if duplicate name is found
			    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Book name already exists");
			} else {
			    // Add new book to book service if no duplicate name is found
			    this.bookService.Add(newBook);
			    response.sendRedirect("book");
			}
			/*
			 * this.bookService.Add(newBook); response.sendRedirect("book");
			 */
		}

		private void updateBook(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int totalPage = Integer.parseInt(request.getParameter("totalPage"));
			String type = request.getParameter("type");
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			System.out.println(id + " " + name + " " + totalPage + " " + type + " " + quantity);
			BookDTO bookUpdate = new BookDTO(id, name, totalPage, type, quantity);
			this.bookService.Update(bookUpdate);
			response.sendRedirect("book");
		}

		private void deleteBook(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id"));
			BookDTO booKDel = bookService.getDataById(id);
			if (bookService.InUsed(id)) {
				this.bookService.Delete(booKDel);
			}
			response.sendRedirect("book");
		}

		private void showBookList(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			ArrayList<BookDTO> ds = this.bookService.List();
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/BooKView/bookManagement.jsp");
			request.setAttribute("bookList", ds);
			dispatcher.forward(request, response);
		}


		private void showEditForm(HttpServletRequest request, HttpServletResponse response)
				throws SQLException, ServletException, IOException {
			int bookId = Integer.valueOf(request.getParameter("id"));
			BookDTO book = this.bookService.getDataById(bookId);
			RequestDispatcher dispatcher = request.getRequestDispatcher("View/BooKView/editBook.jsp");
			request.setAttribute("book", book);
			dispatcher.forward(request, response);
		}


}
