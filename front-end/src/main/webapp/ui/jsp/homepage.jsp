<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Home</title>
</head>

<body >
    <security:authorize access="hasRole('ROLE_TRAINEE')">
    	<c:redirect url="/trainee/home"/>
    </security:authorize>
    
       <security:authorize access="hasRole('ROLE_TRAINER')">
        <c:redirect url="/trainer/home"/>
    </security:authorize>
    
    <security:authorize access="hasRole('ROLE_TRAINING_MANAGER')">
		<c:redirect url="/admin/home"/>
    </security:authorize>
</body>
</html>
