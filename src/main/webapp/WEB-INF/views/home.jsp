<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<c:import url="./layout/nav.jsp" />
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img alt="" src="./resources/images/4.jpg">
<a href="./test">Go Test</a>
<a href="./notice/noticeList">Notice List</a>
</body>
</html>
