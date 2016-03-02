<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste Oeuvre Vente
	</jsp:attribute>
	<jsp:attribute name="body">
		<table id="tabProprietaires" class="table table-striped table-bordered" cellspacing="0" width="90%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Titre</th>
                <th>Etat</th>
                <th>Prix</th>
                <th>Proprietaire</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.oeuvreVentes}" var="oeuvre">
                <tr>
                    <td>${oeuvre.idOeuvrevente}</td>
                    <td>${oeuvre.titreOeuvrevente}</td>
                    <td>${oeuvre.etatOeuvrevente}</td>
                    <td>${oeuvre.prixOeuvrevente}</td>
                    <td>${oeuvre.proprietaire.nomProprietaire}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

	</jsp:attribute>
</t:layout>
