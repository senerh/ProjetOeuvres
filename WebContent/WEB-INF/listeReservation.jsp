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
		<table id="tabProprietaires" class="table table-striped table-bordered" cellspacing="0" width="90%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Adherent</th>
                <th>Oeuvre</th>
                <th>Date</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.reservation}" var="reservation">
                <tr>
                    <td>${reservation.idReservation}</td>
                    <td>${reservation.adherent.nomAdherent}</td>
                    <td>${reservation.oeuvrevente.titreOeuvrevente}</td>
                    <td>${reservation.date}</td>
                    <td>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

	</jsp:attribute>
</t:layout>
