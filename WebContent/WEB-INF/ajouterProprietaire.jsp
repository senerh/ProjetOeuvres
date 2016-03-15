<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="Javascript" type="text/javascript"></script>

<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Ajout Propriétaire
	</jsp:attribute>

	<jsp:attribute name="body">
        <h1 class="titrePage"> Ajout d'un propriétaire </h1>

        <div class="col-xs-8">
            <c:set var="action" scope="request" value="ajouter"/>
            <%@include file="/WEB-INF/formProprietaire.jsp" %>
        </div>
	</jsp:attribute>
</t:layout>
