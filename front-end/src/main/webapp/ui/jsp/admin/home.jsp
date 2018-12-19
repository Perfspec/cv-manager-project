<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="/admin.css">
<script type="text/javascript" src="/admin.js"></script>
<title>Admin</title>
</head>

<body onload="listAllUsers()">

	

	<security:authorize access="hasRole('ROLE_TRAINING_MANAGER')">
	<security:authorize access="isAuthenticated()">
    authenticated as <security:authentication
			property="principal.username" />
	</security:authorize>
		<div class="container">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-sm-5">
							<h2>
								User <b>Management</b>
							</h2>
						</div>
						<div class="col-sm-6">
							<a type="button" class="btn btn-dark btn-md"
								style="margin-right: -20%"
								href="<c:url value="/perform_logout" />"> <span
								class="glyphicon glyphicon-log-out"></span> &nbsp Logout
							</a> <a href="#" onclick=location.reload() class="btn btn-primary"
								style="margin-right: 20%"><i class="material-icons">&#xE863;</i>
								<span>Refresh List</span></a> <a href="#"
								onclick="tableToExcel('data_table', 'W3C Example Table')"
								class="btn btn-info"><i class="material-icons">&#xE24D;</i>
								<span>Export to Excel</span></a>
						</div>
					</div>
				</div>
				<table class="table table-striped table-hover" id="data_table">
					<thead>
						<tr>
							<th>Name</th>
							<th>Email</th>
							<th>Role</th>
							<th>Status</th>
							<th>Action</th>
						</tr>
						<tr>
							<td id="username"></td>
							<td id="email"></td>
							<td id="role"></td>
							<td id="status"></td>
							<td id="action"></td>
							<td></td>
						</tr>
					</thead>

				</table>
			</div>
		</div>


	</security:authorize>


</body>
</html>
