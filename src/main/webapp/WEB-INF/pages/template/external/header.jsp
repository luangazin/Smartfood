<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="menuBar">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>

				<!-- 				<a class="navbar-brand" href="#">Smartfood</a> -->
				<div class="navbar-brand">
					<spring:message code="hello.message" />
				</div>

				<spring:message code="locale.portuguese" var="portuguese" />
				<spring:message code="locale.english" var="english" />
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

				</ul>

				<ul class="nav navbar-nav navbar-right">

					<li><a href="#"> <span class="label label-default">
								Create a New Account <span class="glyphicon glyphicon-user"
								onClick="$('#loginbox').hide(); $('#signupbox').show()"></span>
						</span>
					</a></li>

				</ul>
			</div>
			<div>
				<div style="text-align: right;">
					<a href="<spring:url value="/login/main?language=en_US"/>"> <img
						title="${english}"
						src="<spring:url value="/resources/img/usa_24x24.png"/>" /></a> <a
						href="<spring:url value="/login/main?language=pt_BR"/>"> <img
						title="${portuguese}"
						src="<spring:url value="/resources/img/brazil_24x24.png"/>" /></a>
				</div>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>