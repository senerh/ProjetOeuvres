<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste Adhérents
	</jsp:attribute>
	<jsp:attribute name="body">
		<table id="tabAdherents" class="table table-striped table-bordered" cellspacing="0" width="90%">
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
						<!--<span class="editForm glyphicon glyphicon-edit"
							  data-nom="${item.nomAdherent}"
							  data-prenom="${item.prenomAdherent}"
							  data-ville="${item.villeAdherent}"
							  aria-hidden="true"
							  data-toggle="modal"
							  data-backdrop="false"
							  data-target="#myModal">
						</span>-->
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-body">
						<%@include file="/WEB-INF/formAdherent.jsp" %>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save changes</button>
					</div>
				</div>
			</div>
		</div>

	</jsp:attribute>
</t:layout>
