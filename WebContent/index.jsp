<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:attribute name="title">Accueil</jsp:attribute>
	<jsp:attribute name="content">
      <h1>Médiathèque de POLYTECH</h1>
			<p align="center">
				<font color="#004080" face="Arial" size="4">Gestion de
					l'exposition 2016</font>
			</p>
			<p align="left">
				<font color="#004080" face="Arial"><u>Sélectionnez la
						fonctionnalité voulue:</u></font>
			</p>
			<ul>
				<li><a href="Controleur?action=ajouterAdherent"><font
					face="Arial">Ajout Adhérent</font></a></li>
				<li><a href="Controleur?action=listerAdherent"><font
					face="Arial">lister les adhérents</font></a><font face="Arial">
				</font></li>
				<li><a href="javascript:fermer()"><font face="Arial">Quitter</font></a><font
				face="Arial"> </font></li>
			</ul>
    </jsp:attribute>
</t:template>
