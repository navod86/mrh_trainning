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

<title>Student Management</title>
</head>
<body>
	<div class="layout-sc bg-secondary text-white">
		<!-- <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="bookController">Book</a>
				</li>
				<li class="nav-item active"><a class="nav-link" href="studentController">Student</a></li>
				<li class="nav-item"><a class="nav-link" href="borrowController">Borrow</a></li>
				<li class="nav-item"><a class="nav-link" href="searchController">Search</a>
				</li>
			</ul>
		</nav> -->
		<jsp:include page="../CommonUI/Navbar.jsp" />
		<div class="container-fluid">
			<div
				class="p-3 mb-2 bg-secondary text-white d-flex justify-content-between">
				<h3>Student Management</h3>
				<a href="student?action=new" type="button"
					class="btn btn-success btn-lg"> <i
					class="fa-solid fa-circle-plus"></i> Add Student
				</a>
			</div>
			<table class="table table-dark scroll-lay"
				style="over-flow: auto; height: 100%">
				<tr>
					<th class="text-center" scope="col">StudentID</th>
					<th class="text-center" scope="col">Name</th>
					<th class="text-center" scope="col">Age</th>
					<th class="text-center" scope="col">Gender</th>
					<th class="text-center" scope="col"></th>
				</tr>
				<c:forEach var="student" items="${studentList}">
					<tr>
						<td class="text-center" scope="row">${student.getStudentID() }</td>
						<td class="text-center" scope="row">${student.getName() }</td>
						<td class="text-center" scope="row">${student.getAge() }</td>
						<td class="text-center" scope="row"><c:choose>
								<c:when test="${student.isGender()}">
									Nam
								</c:when>
								<c:otherwise>
									Nữ
								</c:otherwise>
							</c:choose></td>

						<td class="text-center" scope="row"><a
							href="student?action=edit&id=${student.getStudentID()}"
							class="btn btn-outline-warning">Edit</a> <c:choose>
								<c:when test="${student.isInUsed()}">
									<a href="student?action=delete&id=${student.getStudentID()}"
										class="btn btn-outline-danger"
										onclick="return confirm('Xác nhận xóa')">Delete</a>
								</c:when>
								<c:otherwise>
									<a href="student?action=delete&id=${student.getStudentID()}"
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