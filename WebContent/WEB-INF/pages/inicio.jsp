<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Insert title here</title>
		<link href="<c:url value="/css/lib/bootstrap/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h1>Y ahora estas en el inicio</h1>
		
		Sección de la página de inicio
		
		Username: <sec:authentication property="principal.username" /><br />
		Authorities: <sec:authentication property="principal.authorities"/><br />
		
		<script src="<c:url value="/js/lib/jquery/jquery-1.11.3.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/jquery/jquery.validate.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/jquery/additional-methods.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/bootstrap/bootstrap.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/angular/angular.min.js"/>" type="text/javascript"></script>
	</body>
</html>