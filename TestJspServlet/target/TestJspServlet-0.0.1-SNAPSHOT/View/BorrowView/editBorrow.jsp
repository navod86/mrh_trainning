<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link rel="stylesheet" href="../../assets/Css/base.css">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<link href="images/meoLogo.jpg" rel="shortcut icon" type="image/x-icon">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bookManager.css" />
<title>Borrow Management</title>
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

			<h3 class="mt-4">Add Borrow</h3>


			<form class="form-edit col-4 bg-dark p-3 rounded"
				action="borrow?action=insert" method="post">

				<div class="row">
					<div class="form-group bg-dark text-white col-6">
						<label for="email">Mã sinh viên:</label> <select id="StudentID"
							class="selectpicker form-control bg-dark text-white" data-live-search="true"
							name="studentId">
							<c:forEach var="stu" items="${studentList}">
								<option class="opt" value="${stu.getStudentID()}" 
										data-name ="${stu.getName()}"
								>${stu.getStudentID()}</option>
							</c:forEach>
						</select>
					</div>

					<div class="form-group col-6">
						<label for="email">Tên sinh viên:</label> <input id="StudentName" type="text"
							value="" class="form-control"
							placeholder="Student Name">
						<p class="text-danger">*Please fill out this field.</p>
					</div>
				</div>

				<div class="form-group bg-dark text-white">
					<label for="email">Tên sách:</label> <select
						class="selectpicker form-control" data-live-search="true"
						name="bookId">
						<c:forEach var="boo" items="${bookList}">
							<option value="${boo.getBookID()}">${boo.getName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group">
					<label for="pwd">Quantity:</label> <input type="number" min=0
						value="0" class="form-control" name="quantity"
						placeholder="Enter Quantity">
				</div>

				<button type="submit" class="btn btn-outline-success btn-lg">
					<i class="fa-solid fa-circle-plus"></i> Add
				</button>
				<a href="borrow" class="btn btn-outline-info btn-lg"> <i
					class="fa-solid fa-left-long"></i> Back
				</a>
			</form>

		</div>

	</div>
</body>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script> -->

<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}assets/js/editBorrow.js"></script>
</html>