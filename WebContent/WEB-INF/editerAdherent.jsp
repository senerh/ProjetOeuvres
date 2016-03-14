<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="Javascript" type="text/javascript"></script>

<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Ajout Adhérent
	</jsp:attribute>

	<jsp:attribute name="body">
        <h1 class="titrePage"> Editer un adhérent </h1>

        <div class="col-xs-8">
			<c:set var="action" scope="request" value="editer?id=${adherent.idAdherent}"/>
			<%@include file="/WEB-INF/formAdherent.jsp" %>
        </div>
	</jsp:attribute>
</t:layout>
