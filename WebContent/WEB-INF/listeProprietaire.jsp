<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste des propriétaires
	</jsp:attribute>
	<jsp:attribute name="body">
        <h1 class="titrePage">Liste des propriétaires</h1>
		<table id="tabProjet" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.proprietaires}" var="propritaire">
                <tr>
                    <td>${propritaire.idProprietaire}</td>
                    <td>${propritaire.nomProprietaire}</td>
                    <td>${propritaire.prenomProprietaire}</td>
                    <td>
                        <a href="<c:url value="/proprietaire/supprimer"><c:param name="id" value="${ propritaire.idProprietaire }" /></c:url>">
                            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                        </a>
                        <a href="<c:url value="/proprietaire/editer"><c:param name="id" value="${ propritaire.idProprietaire }" /></c:url>">
                            <span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

	</jsp:attribute>
</t:layout>
