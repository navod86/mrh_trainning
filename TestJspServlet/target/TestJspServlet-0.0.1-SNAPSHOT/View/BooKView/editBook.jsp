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
	<div class="layout-sc bg-secondary text-white">
		<!-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="bookController">Book</a></li>
				<li class="nav-item"><a class="nav-link"
					href="studentController">Student</a></li>
				<li class="nav-item"><a class="nav-link"
					href="borrowController">Borrow</a></li>
				<li class="nav-item"><a class="nav-link"
					href="searchController">Search</a></li>
			</ul>
		</nav> -->
		<jsp:include page="../CommonUI/Navbar.jsp" />
		<div
			class="container-fluid row d-flex flex-column justify-content-around align-items-center ">
			<c:choose>
				<c:when test="${book == null}">
					<h3 class="mt-4">Add Book</h3>
				</c:when>
				<c:otherwise>
					<h3 class="mt-4">Edit Book</h3>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${book != null}">
					<form class="form-edit col-4 bg-dark p-3 rounded"
						action="book?action=update" method="post">
						<input type="hidden" name="id" value="${book.getBookID()}"/>
				</c:when>
				<c:otherwise>
					<form class="form-edit col-4 bg-dark p-3 rounded"
						action="book?action=insert" method="post">
				</c:otherwise>
			</c:choose>
			<div class="form-group">
				<label for="email">Name:</label> <input type="text" value="${book.getName()}"
					class="form-control bg-dark text-white" name="name" 
					placeholder="Enter Name">
				<p class="text-danger">*Please fill out this field.</p>
			</div>
			<div class="form-group">
				<label for="pwd">Total Page:</label> <input type="number" min=1 value="${book.getTotalPage()}"
					class="form-control bg-dark
					text-white" name="totalPage"
					placeholder="Enter Total Page">
			</div>

			<div class="form-group">
				<label for="pwd">Type</label> <input type="text" value="${book.getType()}"
					class="form-control bg-dark text-white" name="type"
					placeholder="Enter Total Page">
			</div>
			<div class="form-group">
				<label for="pwd">Quantity:</label> <input type="number" min=0 value="${book.getQuantity()}"
					class="form-control bg-dark text-white" name="quantity"
					placeholder="Enter Quantity">
			</div>
			<c:choose>
				<c:when test="${book == null}">
					<button type="submit" class="btn btn-outline-success btn-lg">
						<i class="fa-solid fa-circle-plus"></i> Add
					</button>
				</c:when>
				<c:otherwise>
					<button type="submit" class="btn btn-outline-warning btn-lg">
						<i class="fa-sharp fa-solid fa-pen"></i> Update
					</button>
				</c:otherwise>
			</c:choose>
			
			
			<a href="book" class="btn btn-outline-info btn-lg">
				<i class="fa-solid fa-left-long"></i> Back
			</a>
			</form>

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