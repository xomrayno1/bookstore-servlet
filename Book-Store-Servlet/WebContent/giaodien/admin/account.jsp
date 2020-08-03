<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>

<title>Admin</title>
<script type="text/script" src='<c:url value="/js/bootstrap.min.js"></c:url>'></script>
<script type="text/script" src='<c:url value="/js/jquery.min.js"></c:url>'></script>
<link rel="stylesheet" href='<c:url value="/css/bootstrap.min.css"></c:url>'>
<link rel="stylesheet" href='<c:url value="/fonts/glyphicons-halflings-regular.eot"></c:url>'>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet" href='<c:url value="/css/style1.css"></c:url>'>
</head>

<body>
<jsp:include page="/giaodien/admin/header.jsp"></jsp:include>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-2">
				<div class="list-group">		
					<a class="list-group-item " href='<c:url value="/admin/home"></c:url>'>Trang Chủ</a>
					<a class="list-group-item active" href='<c:url value="/admin/account"></c:url>'>Quản lý tài khoản</a>
					<a class="list-group-item"  href='<c:url value="/admin/book"></c:url>'>Quản lý sách</a>
					<a class="list-group-item"  href='<c:url value="/admin/category"></c:url>'>Quản lý danh mục</a>
					<a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý tác giả</a>
					<a class="list-group-item"  href='<c:url value="/admin/order"></c:url>'>Quản lý đơn hàng</a>
					<a class="list-group-item"  href='<c:url value="/admin/news"></c:url>'>Quản lý tin tức</a>
					<a class="list-group-item"  href='<c:url value="/admin/contact"></c:url>'>Quản lý liên hệ</a>
					<a class="list-group-item"  href='<c:url value="#"></c:url>'>Quản lý mã coupon</a>
					<a class="list-group-item"  href='<c:url value="/logout"></c:url>'>Thoát</a>
				</div>
			</div>
			<div class="col-sm-10">
			
			<table class="table table-bordered table-hover text-center ">
					<tr>
						<td colspan="3"> 
							<input class="form-control" type="text" name="role"  placeholder="Tìm kiếm"> 							
						</td >
						<td colspan="1">
							<select class="form-control" name="role" >
								<option value="0">Chọn Role </option>
								<option value="1">Role_User</option>
								<option value="2">Role_Admin</option>
							</select>
						</td>
						<td colspan="1">
							<button class="btn">Tìm kiếm</button>
						</td>
						
										
					</tr>
					<tr >
						<th >STT</th>
						<th>Username</th>
						<th>Tên</th>
						<th>Email</th>
						<th>Điện Thoại</th>
						<th>Role</th>
						<th>Ngày Tạo</th>
						<th>Ngày Sửa</th>
						<th>+</th>
					</tr>
					<c:forEach items="${listUser}" var="item" varStatus="i">
						<tr>
							<td width="3">${i.index + 1 + (pageCurrent - 1) * 5}</td>	
							<td width="15%">${item.userName}</td>													
							<td width="12%">${item.name}</td>
							<td width="15%">${item.email}</td>
							<td width="10%">${item.phone}</td>
							<td width="10%">${item.role}</td>
							<td width="10%">${item.create_Date}</td>
							<td width="10%">${item.modify_Date}</td>							
							<td width="15%">
							<a href="#"><button class="btn" title="Xem Địa Chỉ" data-toggle="modal" data-target="#modal-info">!</button></a>
							<a href="#"><button class="btn btn btn-danger" title="Xóa Tài Khoản" data-toggle="modal" data-target="#modal-info">Xóa</button></a>
							<a href="#"><button class="btn btn btn-warning" title="Sửa Tài Khoản">Sửa</button></a>							
							</td>							
						</tr>
					</c:forEach>
					<tr>
						<td colspan="9">
							<ul class="pagination">
								<c:set value="${pageCurrent - 1}"  var="pre" />
								<c:if test="${pre < 1}">
									<c:set value="1"  var="pre" />
								</c:if>
								<li><a href='<c:url value="/admin/account?page=${pre}"></c:url>'>&laquo;</a>
								<c:forEach begin="1" end="${soPage}" var="item">
									<c:if test="${item == pageCurrent}">
										<li class="active"><a href='<c:url value="/admin/account?page=${item}"></c:url>'>${item}</a></li>
									</c:if>
									<c:if test="${item != pageCurrent}">
										<li ><a href='<c:url value="/admin/account?page=${item}"></c:url>'>${item}</a> </li>
									</c:if>
								</c:forEach>
								<c:set value="${pageCurrent + 1}"  var="next" />	
								<c:if test="${next >= soPage}">
									<c:set value="${soPage}"  var="next" />
								</c:if>
								<li><a href='<c:url value="/admin/account?page=${next}"></c:url>'>&raquo;</a>
							</ul>
						</td>
					</tr>
					<tr>
						<td colspan="9">
							<button data-toggle="modal" data-target="#mymodal" class="btn btn-primary">Thêm</button>
						</td>
					</tr>
				</table>		
			
			</div>
		</div>
		
		
	<div class="modal fade " id="modal-info">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<p class="modal-title">Thông Tin</p>		
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="panel panel-primary">
								<div class="panel-body">
									Địa Chỉ :
								</div>
						</div>
					</div>									
				</div>
				<div class="modal-footer">
					<button class="btn btn-danger"  type="button" data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	
	</div>	
		
		
		
	</div>




<jsp:include page="/giaodien/admin/footer.jsp"></jsp:include>




</body>
</html>