<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Ajout Réservation
	</jsp:attribute>

	<jsp:attribute name="body">
        <h1 class="titrePage"> Ajout d'une reservation </h1>

        <div class="col-xs-8">
            <c:set var="action" scope="request" value="ajouter"/>
            <%@include file="/WEB-INF/formReservation.jsp" %>
        </div>

	</jsp:attribute>
</t:layout>
