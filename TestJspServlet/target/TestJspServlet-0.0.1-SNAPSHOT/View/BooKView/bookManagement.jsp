<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

<link href="images/meoLogo.jpg" rel="shortcut icon" type="image/x-icon">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bookManager.css" />

<title>Book Management</title>
</head>
<body>
	<div class="layout-sc bg-secondary text-white pb-5">
		<jsp:include page="../CommonUI/Navbar.jsp" />
		<div class="container-fluid">
			<div
				class="p-3 mb-2 bg-secondary text-white d-flex justify-content-between">
				<h3>Book Management</h3>
				<a href="book?action=new" type="button"
					class="btn btn-success btn-lg"> <i
					class="fa-solid fa-circle-plus"></i> Add Book
				</a>
			</div>
			<table class="table table-dark scroll-lay"
				style="over-flow: auto; height: 100%">
				<tr>
					<th class="text-center" scope="col">BooKID</th>
					<th class="text-center" scope="col">Name</th>
					<th class="text-center" scope="col">Total Page</th>
					<th class="text-center" scope="col">Type</th>
					<th class="text-center" scope="col">Quantity</th>
					<th class="text-center" scope="col"></th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td class="text-center" scope="row">${book.getBookID() }</td>
						<td class="text-center" scope="row">${book.getName() }</td>
						<td class="text-center" scope="row">${book.getTotalPage() }</td>
						<td class="text-center" scope="row">${book.getType()}</td>
						<td class="text-center" scope="row">${book.getQuantity()}</td>
						<td class="text-center" scope="row"><a
							href="book?action=edit&id=${book.getBookID()}"
							class="btn btn-outline-warning">Edit</a> <c:choose>
								<c:when test="${book.isInUsed()}">
									<a href="book?action=delete&id=${book.getBookID()}"
										class="btn btn-outline-danger"
										onclick="return confirm('Xác nhận xóa')"> Delete </a>
								</c:when>
								<c:otherwise>
									<a href="book?action=delete&id=${book.getBookID()}"
										class="btn btn-outline-danger disabled">Delete</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</div>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</html>