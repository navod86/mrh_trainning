<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<table class="table table-striped "
				style="over-flow: auto; height: 100%; background: #ced4da;">
				<tr>
					<th class="text-center" scope="col">BookID</th>
					<th class="text-center" scope="col">BookName</th>
					<th class="text-center" scope="col">BorrowDate</th>
					<th class="text-center" scope="col">StudentID</th>
					<th class="text-center" scope="col">StudentName</th>
					<th class="text-center" scope="col">Quantity</th>

				</tr>
				<c:forEach var="borrow" items="${borrowList}">
					<tr>
						<td class="text-center" scope="row">${borrow.getBookID() }</td>
						<td class="text-center" scope="row">${borrow.getBookName() }</td>
						<td class="text-center" scope="row">${borrow.getBorrowDate() }</td>
						<td class="text-center" scope="row">${borrow.getStudentID() }</td>
						<td class="text-center" scope="row">${borrow.getStudentName() }</td>
						<td class="text-center" scope="row">${borrow.getQuantity() }</td>
					</tr>
				</c:forEach>
			</table>