<%@ page language="java" contentType="text/html; charset=UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="<c:url value="/login"></c:url>" method="post">
	UserName: <input  type="text" name="username" />
	Password: <input  type="text" name="password" />
	<button>Login</button>
</form>

</body>
</html>