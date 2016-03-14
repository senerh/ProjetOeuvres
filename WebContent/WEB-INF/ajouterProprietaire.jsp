<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script language="Javascript" type="text/javascript"></script>

<t:layout>
    <jsp:attribute name="stylesheet">
	</jsp:attribute>

	<jsp:attribute name="headTitle">
		Ajout Adhérent
	</jsp:attribute>

	<jsp:attribute name="body">
        <h1 class="titrePage"> Ajout d'un propriétaire </h1>

        <div class="col-xs-8">
            <form class="form-horizontal" method="post" action="ajouter" role="form">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="nom">Nom</label>
                    <div class="col-sm-10">
                        <input type="text"
                               class="form-control"
                               id="nom" name="nom"
                               value="<c:out value="${proprietaire.nomProprietaire}"/>"
                               size="20" maxlength="60"
                               placeholder="Entrer nom"
                        />
                        <span>${form.erreurs['nom']}</span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="prenom">Prenom</label>
                    <div class="col-sm-10">
                        <input type="text"
                               class="form-control"
                               id="prenom" name="prenom"
                               value="<c:out value="${proprietaire.prenomProprietaire}"/>"
                               size="20" maxlength="60"
                               placeholder="Entrer prénom"
                        />
                        <span>${form.erreurs['prenom']}</span>
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
