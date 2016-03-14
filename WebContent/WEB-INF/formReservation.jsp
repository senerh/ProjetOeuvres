<form class="form-horizontal" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeAdherent">Propriétaire</label>
        <div class="col-sm-10">
            <select class="form-control" name="adherent" id="listeAdherent">
                <option value="${reservation.adherent.idAdherent}">${reservation.adherent.nomAdherent}</option>
                <c:forEach items="${reservations}" var="r">
                    <option value="${ r.adherent.idAdherent }">${ r.adherent.nomAdherent }</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeOeuvre">Oeuvre</label>
        <div class="col-sm-10">
            <select class="form-control" name="oeuvrevente" id="listeOeuvre">
                <option value="${reservation.oeuvrevente.idOeuvrevente}">${reservation.oeuvrevente.titreOeuvrevente}</option>
                <c:forEach items="${ reservations }" var="r">
                    <option value="${ r.oeuvrevente.idOeuvrevente }">${ r.oeuvrevente.titreOeuvrevente }</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="date">Date</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="date" name="date" value="<c:out value="${reservation.date}"/>" size="20" maxlength="60" placeholder="Entrer date" /> <span>${form.erreurs['date']}</span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Valider</button>
        </div>
    </div>
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>