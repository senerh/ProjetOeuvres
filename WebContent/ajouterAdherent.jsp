<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
    <jsp:attribute name="title">Accueil</jsp:attribute>
    <jsp:attribute name="content">

	<script type="text/javascript" src="js/foncControle.js"></script>

	<h2>Ajouter un adhérent</h2> 

    <form class="form-horizontal" role="form" name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
    
        <div class="form-group">
            <label class="control-label col-sm-2" for="nom">Nom:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="nom" name="txtnom" placeholder="Entrer le nom de l'adhérent" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-2" for="prenom">Prénom:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="prenom" name="txtprenom" placeholder="Entrer le prénom de l'adhérent" />
            </div>
        </div>
        
        <div class="form-group">
            <label class="control-label col-sm-2" for="ville">Ville de l'adherent:</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="ville" name="txtville" placeholder="Entrer la ville de l'adhérent" />
            </div>
        </div>
        
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" name="bt" class="btn btn-default">Ajouter</button>
            </div>
        </div>
    
    </form>
	
    </jsp:attribute>
</t:template>
