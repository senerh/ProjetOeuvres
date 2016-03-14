<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Ajout Adhérent
	</jsp:attribute>



	<jsp:attribute name="body">
        <h1> Ajout d'une reservation </h1>

        <div class="col-xs-8">
            <form class="form-horizontal" method="post" action="/reservation/ajouter" role="form">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="listeAdherent">Propriétaire</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="adherent" id="listeAdherent">
                            <option value="">Choisissez un adhérent...</option>
                            <c:forEach items="${ sessionScope.adherents }" var="mapAdherent">
                                <option value="${ mapAdherent.value.idAdherent }">${ mapAdherent.value.nomAdherent }</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="listeOeuvre">Oeuvre</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="oeuvrevente" id="listeOeuvre">
                            <option value="">Choisissez une oeuvre...</option>
                            <c:forEach items="${ sessionScope.oeuvreventes }" var="mapOeuvreVente">
                                <option value="${ mapOeuvreVente.value.idOeuvrevente }">${ mapOeuvreVente.value.titreOeuvrevente }</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="date">Date</label>
                    <div class="col-sm-10">
                        <input type="text"
                               class="form-control"
                               id="date" name="date"
                               value="<c:out value="${reservation.date}"/>"
                               size="20" maxlength="60"
                               placeholder="Entrer date"
                        />
                        <span>${form.erreurs['date']}</span>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Ajouter</button>
                    </div>
                </div>
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </form>
        </div>

	</jsp:attribute>
</t:layout>
