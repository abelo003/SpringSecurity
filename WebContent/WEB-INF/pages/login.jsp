<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>iniciar sesión</title>
		<link href="<c:url value="/css/lib/bootstrap/bootstrap.min.css"/>" rel="stylesheet" type="text/css" />
		<link href="<c:url value="/css/login/login.css"/>" rel="stylesheet" type="text/css" />
		<c:if test="${not empty ERRORSESSION}">
			<script type="text/javascript">
				window.history.pushState("object or string", "Hola mundo", "login");//Se reescribe la url
			</script>
		</c:if>
	</head>
	<body ng-app="LoginCtrl" ng-controller="LoginCtrl.loginctrl">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12" style="margin-bottom: 30px;height: 250px;">
					<div class="row" style="background-color: orange;height: 100%;width: 100%;margin: 0px !important;">
						<div class="col-sm-12">
							<div style="text-align: center;text-align: center;margin-top: 50px;">
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-5 col-md-5">
					<div class="row" style="margin-bottom: 30px;">
						<div class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
							<h3>!Bienvenidos¡</h3>
							<p class="p-text">
								Inicio de sesión
							</p>
							<p class="p-text">
								Con
								<span class="negritaM">Spring Security</span>
								
							</p>
							<button type="button" class="btn btn-default" ng-show="!showFormLogin" ng-click="clickBtnIS(true)">
						    	<span class="glyphicon glyphicon-user" style="margin-right: 5px;"></span>Iniciar sesión
						    </button>
						</div>
					</div>
					<div class="row" ng-show="showFormLogin">
						<div id="loginbox" class="col-md-10 col-md-offset-1 col-sm-10 col-sm-offset-1">
							<div class="panel panel-default">
								<div class="panel-body">
									<form name='formLogin' action="<c:url value="/_login"/>" method="post" id="formLogin" class="form-horizontal" method="POST">
										<p>Ingresa a tu usuario</p>
										<div class="input-group">
											<span class="input-group-addon">
												<i class="glyphicon glyphicon-user"></i>
											</span> <input id="username" type="tel" maxlength="10" class="form-control" name="username" value="" placeholder="Usuario">
										</div>
										<div class="input-group">
											<span class="input-group-addon">
												<i class="glyphicon glyphicon-lock"></i>
											</span>
											<input id="password" type="password" maxlength="35" class="form-control" name="password" placeholder="Contraseña">
										</div>
										<div class="">
											<!-- Button -->
											<div class="col-sm-6 controls">
												<button type="button" class="btn btn-default pull-left" ng-click="clickBtnIS(false)">
													Atr&aacute;s
												</button>
											</div>
											<div class="col-sm-6 controls">
												<button type="submit" class="btn btn-primary pull-right"> 
													<i class="glyphicon glyphicon-log-in"></i>
													Entrar
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
        		</div>
        		<div class="col-lg-7 col-md-7">
					<div id="carousel-login" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ol class="carousel-indicators">
							<li data-target="#carousel-login" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-login" data-slide-to="1"></li>
							<li data-target="#carousel-login" data-slide-to="2"></li>
							<li data-target="#carousel-login" data-slide-to="3"></li>
						</ol>
						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<div class="item active">
								<img src="https://www.att.com/es-us/shopcms/media/att/2016/mrqs/1100x514/1Q/261420-mrq-home-lg-f8-free-1100x514.jpg">
	<!-- 							<div class="carousel-caption"> -->
	<!-- 								<h3>Ou...</h3> -->
	<!-- 							</div> -->
							</div>
							<div class="item">
								<img src="https://www.att.com/es-us/shopcms/media/att/2016/mrqs/1100x514/1Q/264518-mrq-s7-bogo-1100x514.jpg">
							</div>
							<div class="item">
								<img src="https://www.att.com/es-us/shopcms/media/att/2016/mrqs/1100x514/1Q/262879-savescore-homepage-100.jpg">
							</div>
							<div class="item">
								<img src="https://www.att.com/es-us/shopcms/media/att/2016/mrqs/1100x514/1Q/267172-mrq-home-iphone6se-pre-order-1100x514.jpg">
							</div>
						</div>
						<!-- Left and right controls -->
						<a class="left carousel-control" href="#carousel-login"
							role="button" data-slide="prev"> <span
							class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> 
						<a class="right carousel-control" href="#carousel-login"
							role="button" data-slide="next"> <span
							class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					
					
					
					
					
					
					
					<c:choose>
		                <c:when test="${not empty ERRORSESSION}">
		                    ${ERRORSESSION}
		                </c:when>
		                <c:otherwise></c:otherwise>
		            </c:choose>
					
				</div>
			</div>
		</div>
		<script src="<c:url value="/js/lib/jquery/jquery-1.11.3.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/jquery/jquery.validate.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/jquery/additional-methods.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/bootstrap/bootstrap.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/lib/angular/angular.min.js"/>" type="text/javascript"></script>
		<script src="<c:url value="/js/login/login.js"/>" type="text/javascript"></script>
		
		
	</body>
</html>