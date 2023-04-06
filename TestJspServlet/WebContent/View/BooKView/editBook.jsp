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
<style>
input.error {
    border-color: red;
}
input{
   color:red;
}
</style>
</head>
<body>
	<div class="layout-sc bg-secondary text-dark">

		<jsp:include page="../CommonUI/Navbar.jsp" />
		<div
			class="container-fluid row d-flex flex-column justify-content-around align-items-center ">
			<c:choose>
				<c:when test="${book == null}">
					<h3 class="mt-4">Add New Book</h3>
				</c:when>
				<c:otherwise>
					<h3 class="mt-4">Edit Book</h3>
				</c:otherwise>
			</c:choose>
				<c:choose>
					<c:when test="${book == null}">
						<form id="myform" class="form-edit col-4 bg-light p-3 rounded" action="book?action=insert" method="post">
							<div class="form-group">
								<label for="email">Name:</label> <input type="text"
									class="form-control bg-light text-dark" name="name"
									placeholder="Enter Name" required="required">
							</div>
							<div class="form-group">
								<label for="">Total Page:</label> <input type="number" min=1
									class="form-control bg-light " name="totalPage"
									placeholder="Enter Total Page" required="required">
							</div>
							<div class="form-group">
								<label for="">Type:</label> <input type="text"
									class="form-control bg-ligth " name="type"
									placeholder="Enter Type" required="required">
							</div>
							<div class="form-group">
								<label for="">Quantity:</label> <input type="number" min=0
									class="form-control bg-light " name="quantity"
									placeholder="Enter Quantity" required="required">
							</div>
							<button type="submit" class="btn btn-success btn-lg">
								<i class="fa-solid fa-circle-plus"></i> Add
							</button>
							<a href="book" class="btn btn-info btn-lg"> 
							   <i class="fa-solid fa-left-long"></i> Back
							</a>
						</form>
					</c:when>
					<c:otherwise>
						<form class="form-edit col-4 bg-light p-3 rounded" action="book?action=update" method="post">
							<input type="hidden" name="id" value="${book.getBookID()}" />
							<div class="form-group">
								<label for="email">Name:</label> <input type="text"
									value="${book.getName()}"
									class="form-control bg-light" name="name"
									placeholder="Enter Name">
							</div>
							<div class="form-group">
								<label for="pwd">Total Page:</label> <input type="number" min=1
									value="${book.getTotalPage()}"
									class="form-control bg-light " name="totalPage"
									placeholder="Enter Total Page">
							</div>
							<div class="form-group">
								<label for="pwd">Type:</label> <input type="text"
									value="${book.getType()}"
									class="form-control bg-ligth " name="type"
									placeholder="Enter Type">
							</div>
							<div class="form-group">
								<label for="pwd">Quantity:</label> <input type="number" min=0
									value="${book.getQuantity()}"
									class="form-control bg-light " name="quantity"
									placeholder="Enter Quantity">
							</div>
							<button type="submit" class="btn btn-warning btn-lg">
								<i class="fa-sharp fa-solid fa-pen"></i> Update
							</button>
							<a href="book" class="btn btn-info btn-lg"> <i
								class="fa-solid fa-left-long"></i> Back
							</a>
						</form>
					</c:otherwise>
				</c:choose>
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
    // áp dụng validation cho biểu mẫu
    $("#myform").validate({
        // thiết lập các quy tắc validation cho từng trường
        rules: {
            name: {
                required: true,
                minlength: 3
            },
            totalPage: {
                required: true,
                digits: true
            },
            type: {
                required: true
            },
            quantity: {
                required: true,
                digits: true
            }
        },
        // thiết lập các thông báo lỗi tương ứng với từng trường
        messages: {
            name: {
                required: "Please enter your name",
                minlength: "Name must be at least 3 characters long"
            },
            totalPage: {
                required: "Please enter total pages",
                digits: "Total pages must be a number"
            },
            type: {
                required: "Please enter type"
            },
            quantity: {
                required: "Please enter quantity",
                digits: "Quantity must be a number"
            }
        }
    });
});
</script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- jQuery Validation plugin -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
</html>