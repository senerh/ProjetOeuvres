<form class="form-horizontal customForm" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="titre">Propriétaire</label>
        <div class="col-sm-10">
            <select class="form-control" name="listeProprietaires" id="listeProprietaires">
                <option value="${ oeuvrevente.proprietaire.idProprietaire }">${ oeuvrevente.proprietaire.prenomProprietaire } ${ oeuvrevente.proprietaire.nomProprietaire }</option>
                <c:forEach items="${ sessionScope.proprietaires }" var="mapProprietaires">
                    <option value="${ mapProprietaires.value.idProprietaire }">${ mapProprietaires.value.prenomProprietaire } ${ mapProprietaires.value.nomProprietaire }</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="titre">Titre</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="titre" name="titre"
                   value="<c:out value="${oeuvrevente.titreOeuvrevente}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrer titre"
            />
            <span>${form.erreurs['titre']}</span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="prix">Prix</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="prix" name="prix"
                   value="<c:out value="${oeuvrevente.prixOeuvrevente}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrer prix"
            />
            <span>${form.erreurs['ville']}</span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Ajouter</button>
        </div>
    </div>
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>