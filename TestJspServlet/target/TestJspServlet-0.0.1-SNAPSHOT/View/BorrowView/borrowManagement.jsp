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

<!-- live -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/css/bootstrap-select.min.css">

<link href="images/meoLogo.jpg" rel="shortcut icon" type="image/x-icon">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bookManager.css" />

<title>Borrow Management</title>
</head>
<body>
	<div class="layout-sc bg-secondary text-white">
		<jsp:include page="../CommonUI/Navbar.jsp" />

		<div class="container-fluid">
			<h3 class="p-3">Borrow Management</h3>

			<form class="row" action="borrow?action=search" method="post">
				<div class="form-group col-2">
					<input type="date" value="${startDay}" class="form-control date-start"
						name="dateStart">
				</div>
				<div class="form-group col-2">
					<input type="date" value="${endDay}" class="form-control date-end"
						name="dateEnd">
				</div>
				<div class="form-group col-6">
					<input type="text" class="form-control" name="keyWord"
						value="${keyWord}" placeholder="Enter Keyword(Id, Name) or Date">
				</div>
				<button type="submit" class="s-btn btn btn-primary col-1">Search</button>
			</form>

			<div
				class="p-3 mb-2 bg-secondary text-white d-flex justify-content-between">

				<a href="borrow?action=new" type="button"
					class="btn btn-success btn-lg"> <i
					class="fa-solid fa-circle-plus"></i> Add Borrow
				</a>
			</div>
			<table class="table table-dark scroll-lay"
				style="over-flow: auto; height: 100%">
				<tr>
					<th class="text-center" scope="col">BookID</th>
					<th class="text-center" scope="col">Bookname</th>
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
		</div>
	</div>
</body>

<!-- <script
	src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>

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
<script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}assets/js/borrowManagement.js"></script>
</html>