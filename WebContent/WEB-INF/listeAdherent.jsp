<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste des Adhérents
	</jsp:attribute>
	<jsp:attribute name="body">
		<h1 class="titrePage">Liste des adhérents</h1>
		<table id="tabProjet" class="table table-striped table-bordered" cellspacing="0" width="100%">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Prenom</th>
					<th>Ville</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${requestScope.adherents}" var="item">
				<tr class="ligneTabAdherent">
					<td>${item.idAdherent}</td>
					<td>${item.nomAdherent}</td>
					<td>${item.prenomAdherent}</td>
					<td>${item.villeAdherent}</td>
					<td>
						<a href="<c:url value="/adherent/supprimer"><c:param name="id" value="${ item.idAdherent }" /></c:url>">
							<span class="glyphicon glyphicon-remove" aria-hidden="true" ></span>
						</a>
						<a href="<c:url value="/adherent/editer"><c:param name="id" value="${ item.idAdherent }" /></c:url>">
							<span class="glyphicon glyphicon-edit" aria-hidden="true" ></span>
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</jsp:attribute>
</t:layout>
