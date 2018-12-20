<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
   <title>Trainee</title>
    <script type="text/javascript" src="/trainee.js"></script>
</head>

<body >
     <security:authorize access="hasRole('ROLE_TRAINEE')">
        <h1>Trainee Page</h1>
    </security:authorize>
    
  <button>
  <a href="http://localhost:8086/cv/addcv">Upload CV</a>
  </button>  
  
  <button onclick="getAllCVs()">Get All CV's</button>
  
  <div id="cvList"></div>
</body>
</html>
