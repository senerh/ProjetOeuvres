<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste des Oeuvres
	</jsp:attribute>
	<jsp:attribute name="body">
        <h1 class="titrePage">Liste des oeuvres en vente</h1>
		<table id="tabProjet" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Titre</th>
                <th>Etat</th>
                <th>Prix</th>
                <th>Proprietaire</th>
                <th>Actions</th>
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
                    <td>
                        <a href="<c:url value="/oeuvre/vente/supprimer"><c:param name="id" value="${ oeuvre.idOeuvrevente }" /></c:url>" class="deleteA">
                            <span class="confirmation glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a>
                        <a href="<c:url value="/oeuvre/vente/editer"><c:param name="id" value="${ oeuvre.idOeuvrevente }" /></c:url>">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true" ></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
	</jsp:attribute>
</t:layout>
