<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	 <title>Trainer</title>
</head>

<body >
       <security:authorize access="hasRole('ROLE_TRAINER')">
        <h1>Trainer Page</h1>
    </security:authorize>
</body>
</html>
