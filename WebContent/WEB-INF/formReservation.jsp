<form class="form-horizontal" method="post" action="${action}" role="form">
    <div class="form-group">
        <label class="control-label col-sm-2" for="listeAdherent">Adhérent</label>
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
            <input type="text" class="form-control" id="date" name="date" value="<fmt:formatDate value="${reservation.date}" pattern="dd/MM/yyyy" />" onclick="new calendar(this);" size="20" maxlength="60" placeholder="Entrer date" /> <span>${form.erreurs['date']}</span>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Valider</button>
        </div>
    </div>
    
    <input type="hidden" id="id-adherent-origin" name="id-adherent-origin" value="<c:out value="${reservation.adherent.idAdherent}"/>" />
    <input type="hidden" id="id-oeuvrevente-origin" name="id-oeuvrevente-origin" value="<c:out value="${reservation.oeuvrevente.idOeuvrevente}"/>" />
    
    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
</form>