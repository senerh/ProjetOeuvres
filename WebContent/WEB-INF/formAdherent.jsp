<form class="form-horizontal" method="post" action="${action}">
    <div class="form-group">
        <label class="control-label col-sm-2" for="nom">Nom</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="nom" name="nom"
                   value="<c:out value="${adherent.nomAdherent}"/>"
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
                   value="<c:out value="${adherent.prenomAdherent}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrer prénom"
            />
            <span>${form.erreurs['prenom']}</span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="ville">Ville</label>
        <div class="col-sm-10">
            <input type="text"
                   class="form-control"
                   id="ville" name="ville"
                   value="<c:out value="${adherent.villeAdherent}"/>"
                   size="20" maxlength="60"
                   placeholder="Entrer ville"
            />
            <span>${form.erreurs['ville']}</span>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button id="ajoutAdherentBtn" type="submit" class="btn btn-default">Ajouter</button>
        </div>
    </div>
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>