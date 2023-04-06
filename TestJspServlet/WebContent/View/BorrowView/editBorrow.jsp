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
<style>
input{
   color:red;
   border-color: red;
}
select{
  color:red;
  border-color: red;
}
</style>
</head>
<body>
	<div class="layout-sc bg-secondary text-white">
		<jsp:include page="../CommonUI/Navbar.jsp" />
		<div
			class="container-fluid row d-flex flex-column justify-content-around align-items-center ">
			<h3 class="mt-4">Add Borrow</h3>
			<form id="myform" class="form-edit col-4 bg-light p-3 rounded"
				action="borrow?action=insert" method="post">
				<div class="row">
					<div class="form-group bg-light text-dark col-6">
						<label for="email">Mã sinh viên:</label> <select id="StudentID"
							class="selectpicker form-control bg-light"
							data-live-search="true" name="studentId">
							<c:forEach var="stu" items="${studentList}">
								<option class="opt" value="${stu.getStudentID()}"
									data-name="${stu.getName()}">${stu.getStudentID()}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group text-dark col-6">
						<label for="email">Tên sinh viên:</label> <input id="StudentName"
							type="text" value="" class="form-control"
							placeholder="Student Name" required="required">
					</div>
				</div>
				<div class="form-group bg-light text-dark">
					<label for="email">Tên sách:</label> <select
						class="selectpicker form-control" data-live-search="true"
						name="bookId">
						<c:forEach var="book" items="${bookList}">
							<option value="${book.getBookID()}">${book.getName()}</option>
						</c:forEach>
					</select>
				</div>

				<div class="form-group text-dark">
					<label for="pwd">Quantity:</label> <input type="number" min=0
						value="0" class="form-control" name="quantity"
						placeholder="Enter Quantity" required="required">
				</div>

				<button type="submit" class="btn btn-success btn-lg">
					<i class="fa-solid fa-circle-plus"></i> Add
				</button>
				<a href="borrow" class="btn btn-info btn-lg"> <i
					class="fa-solid fa-left-long"></i> Back
				</a>
			</form>
		</div>
	</div>
</body>
<script>
$(document).ready(function() {
    // áp dụng validation cho biểu mẫu
    $("#myform").validate({
        // thiết lập các quy tắc validation cho từng trường
        rules: {
            StudentId: {
                required: true
            },
            quantity: {
                required: true,
                digits: true
            }
        },
        // thiết lập các thông báo lỗi tương ứng với từng trường
        messages: {
            StudentId: {
                required: "Please select a student"
            },
            quantity: {
                required: "Please enter quantity",
                digits: "Quantity must be a number"
            }
        }
    });

    // cập nhật tên sinh viên khi chọn mã sinh viên
    $('#StudentID').on('change', function() {
        var studentName = $(this).find(':selected').data('name');
        $('#StudentName').val(studentName);
    });
});
</script>
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.13.14/dist/js/bootstrap-select.min.js"></script>
<script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}assets/js/editBorrow.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!-- jQuery Validation plugin -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
</html>