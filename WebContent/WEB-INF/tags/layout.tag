<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="stylesheet" fragment="true" %>
<%@attribute name="headeTitle" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="refresh" content="0;URL=javascript:fermer();">

        <link href="css/base.css" rel="stylesheet" type="text/css">
        <link href="css/base.css" rel="stylesheet" media="screen and (max-width: 800px)">
        <link href="lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" href="images/favicon.ico" />

        <jsp:invoke fragment="stylesheet"/>

        <title>
            <jsp:invoke fragment="headeTitle"/>
        </title>


    </head>

    <body class="h100 w100 BackGroundGris NoMargin">

        <div id="pageheader">
            <%@include file="/header.jsp" %>
        </div>

        <div id="menu">
            <ul class="ulmenu">
                <li>
                    <a href="Controleur?action=ajouterAdherent">
                        <p>Ajouter</p>
                    </a>
                </li>
                <li>
                    <a href="Controleur?action=listerAdherent">
                        <p>Liste</p>
                    </a>
                </li>
                <li>
                    <a href="javascript:fermer()">
                        <p>Quitter</p>
                    </a>
                </li>
            </ul>
        </div>

        <div id="body" class="col-xs-4">
            <jsp:invoke fragment="body"/>
        </div>

        <div id="pagefooter">
            <%@include file="/footer.jsp" %>
        </div>

    </body>
</html>