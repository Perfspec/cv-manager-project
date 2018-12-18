<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link href="/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/register.css">
<title>Register</title>
<script type="text/javascript" src="/register.js"></script>
</head>

<body>

	<div class="container__child signup__thumbnail">
		<div class="signup__overlay">
			<div class="thumbnail__logo">

				<h1 class="logo__text">Infosys & Malcolm</h1>
			</div>
			<div class="signup__container">
				
				<div class="container__child signup__form">
				<p style="color: red" id="message"></p>
					<form>
						<div class="form-group">
							<label for="username">Username</label> <input
								class="form-control" type="text" name="username" id="username"
								placeholder="Username" required />
						</div>
						
						<div class="form-group">
							<label for="email">Email</label> <input
								class="form-control" type="email" name="email" id="email"
								placeholder="user@example.com" required />
						</div>
					
						<div class="form-group">
							<label for="password">Password</label> <input
								class="form-control" type="password" name="password"
								id="password" placeholder="********" required />
						</div>
						<div class="form-group">
							<label for="passwordRepeat">Repeat Password</label> <input
								class="form-control" type="password" name="confirmPassword"
								id="confirmPassword" placeholder="********" required />
						</div>
						<div class="m-t-lg">
							<ul class="list-inline">
								<li><input class="btn btn--form" onclick="register()"
									type="submit" value="Register" /></li>
								<li><a class="signup__link" href="/login">I am already
										a user</a></li>
							</ul>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
