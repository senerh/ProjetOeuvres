<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script language="Javascript" type="text/javascript"></script>

<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Editer Réservation
	</jsp:attribute>

	<jsp:attribute name="body">
        <h1 class="titrePage">Editer une réservation</h1>

        <div class="col-xs-8">
			<c:set var="action"
            scope="request"
            value="editer?id-oeuvrevente=${ reservation.oeuvrevente.idOeuvrevente }&id-adherent=${ reservation.adherent.idAdherent }"
            />
			<%@include file="/WEB-INF/formReservation.jsp" %>
        </div>
	</jsp:attribute>
</t:layout>
