<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%@ page isELIgnored="false"%>
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Comanda On-line - Login</title>

<tiles:importAttribute name="cssList" />
<tiles:importAttribute name="jsList" />
<!-- CSS -->
<c:forEach var="css" items="${cssList}">
	<link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
	<link href="<c:url value="${css}" />" rel="stylesheet">
</c:forEach>

</head>
<body>
	<div class="page">
		<tiles:insertAttribute name="header" />
		<div class="content">
			<tiles:insertAttribute name="body" />
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- scripts -->
	<c:forEach var="script" items="${jsList}">
		<script src="<c:url value="${script}"/>"></script>
	</c:forEach>
</body>
</html>