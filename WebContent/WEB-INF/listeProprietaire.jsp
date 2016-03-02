<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="headTitle">
		Liste Propriétaire
	</jsp:attribute>
	<jsp:attribute name="body">
		<table id="tabProprietaires" class="table table-striped table-bordered" cellspacing="0" width="90%">
            <thead>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.proprietaires}" var="propritaire">
                <tr>
                    <td>${propritaire.idProprietaire}</td>
                    <td>${propritaire.nomProprietaire}</td>
                    <td>${propritaire.prenomProprietaire}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

	</jsp:attribute>
</t:layout>
