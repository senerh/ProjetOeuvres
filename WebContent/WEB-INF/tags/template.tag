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
<link rel="icon" href="images/favicon.ico" />
</head>
<body>
    <div class="container">
        <nav class="navbar navbar-default navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-target">
                        <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">Accueil</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse-target">
                    <ul class="nav navbar-nav navbar-left">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"> Adhérent <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="Controleur?action=ajouterAdherent">Ajouter</a>
                                </li>
                                <li>
                                    <a href="Controleur?action=listerAdherent">Consulter</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div id="content">
            <jsp:invoke fragment="content" />
        </div>
        <footer class="footer">
            <strong>Projet Oeuvres</strong>
        </footer>
    </div>

    <!-- jQuery -->
    <script src="lib/jquery/jquery-1.12.0.min.js"></script>
    <!-- JavaScript Boostrap plugin -->
    <script src="lib/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
