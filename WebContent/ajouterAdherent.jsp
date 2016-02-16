<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>

<t:layout>
	<jsp:attribute name="body">
        <h1> Ajout d'un adhérent </h1>

        <div align="center">
            <form class="form-control"  name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
                <p align="left"><FONT face="Arial" color="#004080"></FONT>
                    <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Nom de l'adherent : </FONT>
                    <INPUT type="text" name="txtnom" value=""  id ="nom"> <BR>
                    <FONT face="Arial" color="#004080">
                        <BR>Prenom de l'adherent : </FONT>
                    <INPUT type="text" name="txtprenom"  id ="prenom"  > <BR>

                    <FONT face="Arial" color="#004080"> <BR>&nbsp;  &nbsp;  &nbsp; Ville de l'adherent :</FONT>
                    <INPUT type="text" name="txtville" id ="ville">
                    <FONT face="Arial" color="#004080">	<BR></FONT><BR>

                    <!-- Boutons Ajouter -->

                    <INPUT type="submit" name="bt"  value="Ajouter" >
                    <FONT face="Arial" color="#004080"></FONT>
                    &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                </p>
            </form>
        </div>
	</jsp:attribute>
</t:layout>
