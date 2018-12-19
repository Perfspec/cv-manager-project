<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<link rel="stylesheet" href="/trainer_home.css" />
<head>
  <link rel="stylesheet" type="text/css" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
	 <title>Trainer</title>
	 <script type="text/javascript" src="/trainer.js"></script>
</head>

<body >
       <security:authorize access="hasRole('ROLE_TRAINER')">
        <h1>Trainer Page</h1>
    </security:authorize>
    
    <button onclick="getAllCVs()">Get All CVs</button>
    <button onclick="getAllFlaggedCVs()">Show All Flagged CVs</button>
    <button onclick="getAllMediumFlaggedCVs()">Show All Medium Flagged CVs</button>
    <button onclick="getAllBadFlaggedCVs()">Show All Bad Flagged CVs</button>
    <p></p>
    <div id="cvList"></div>
        
</body>
</html>
