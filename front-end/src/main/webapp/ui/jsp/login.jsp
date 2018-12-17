<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/login.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />


<title>Home Page</title>
</head>
<body>
	<div class="login-box">
		<form action="/perform_login" method="post">
			<c:if test="${param.error ne null}">
				<div style="color: red">Invalid Credentials</div>
			</c:if>
			<div class="input-section">
		    <input type="text"
					class="input-area" id="username" name="username" placeholder="Username">
				<i class="far fa-user"></i>
			</div>
			<div class="input-section">
			<input type="password"
					class="input-area" id="pwd" name="password" placeholder="Password">
				<i class="fas fa-lock"></i> 
			</div>
			<button type="submit" class="btn" id="login-btn">Login</button>
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<div class="question-box">
				<p class="question">Not a member?</p>
				<a class="reg-btn" href="/register" >Register</a>
			</div>

		</form>
	</div>
</body>
</html>
