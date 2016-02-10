<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="content" fragment="true"%>
<%@attribute name="title" fragment="true"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Projet Oeuvres - <jsp:invoke fragment="title" /></title>
<link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-default navbar-fixed-top navbar-inverse"
			role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navbar-collapse-target">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp">Accueil</a>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse-target">
				</div>
			</div>
			<!-- /.container -->
		</nav>
		<div id="content">
			<jsp:invoke fragment="content" />
		</div>
		<footer class="footer">
			<strong>Projet Oeuvres</strong>, le site du TURFU !!
		</footer>
	</div>
</body>
</html>