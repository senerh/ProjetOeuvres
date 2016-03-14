<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste reservation
	</jsp:attribute>
	<jsp:attribute name="body">
        <h1 class="titrePage">Liste des reservations</h1>
		<table id="tabProjet" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Adherent</th>
                <th>Oeuvre</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.reservations}" var="reservation">
                <tr>
                    <td>${reservation.adherent.nomAdherent}</td>
                    <td>${reservation.oeuvrevente.titreOeuvrevente}</td>
                    <td>${reservation.date}</td>
                    <td>
                        <a href="
                        <c:url value="/reservation/editer">
                        <c:param name="id-oeuvrevente" value="${ reservation.oeuvrevente.idOeuvrevente }" />
                        <c:param name="id-adherent" value="${ reservation.adherent.idAdherent }" />
                        </c:url>">
                                <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

	</jsp:attribute>
</t:layout>
