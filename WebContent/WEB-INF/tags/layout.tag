<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@attribute name="stylesheet" fragment="true" %>
<%@attribute name="headTitle" fragment="true" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@attribute name="body" fragment="true" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<%=request.getContextPath()%>/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <script src="<%=request.getContextPath()%>/lib/jquery/jquery-1.12.1.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath()%>/lib/bootstrap/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.11/css/dataTables.bootstrap.min.css">
        <script src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>



        <link rel="icon" href="<%=request.getContextPath()%>/images/favicon.ico" />
        <script type="text/javascript" src="<%=request.getContextPath()%>/js/fonctControle.js"></script>
        <link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet" type="text/css">
        <link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet" media="screen and (max-width: 800px)">
        <link href="<%=request.getContextPath()%>/css/base.css" rel="stylesheet" media="screen and (max-height: 500px)">


        <jsp:invoke fragment="stylesheet"/>

        <title>
            <jsp:invoke fragment="headTitle"/>
        </title>
    </head>

    <body class="h100 w100 BackGroundGris NoMargin">
        <div class="backgroundBody"></div>
            <div id="pageheader">
                <%@include file="/WEB-INF/header.jsp" %>
            </div>

            <div id="menu">
                <ul class="ulmenu">
                    <li>
                        <a href="<c:url value="/adherent/ajouter"> </c:url>">
                            <p>+ Adhérent</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/adherent/"> </c:url>">
                            <p>Adherents</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/proprietaire/"> </c:url>">
                            <p>Proprietaires</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/oeuvre/vente"> </c:url>">
                            <p>Ventes</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/oeuvre/vente/ajouter"> </c:url>">
                            <p>+ Oeuvre</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/proprietaire/ajouter"> </c:url>">
                            <p>+ Proprietaire</p>
                        </a>
                    </li>
                    <li>
                        <a href="<c:url value="/reservation/ajouter"> </c:url>">
                            <p>+ Reservation</p>
                        </a>
                    </li>
                </ul>
            </div>

            <div id="body">
                <jsp:invoke fragment="body"/>
            </div>

            <div id="pagefooter">
                <%@include file="/WEB-INF/footer.jsp" %>

        </div>


    </body>
</html>