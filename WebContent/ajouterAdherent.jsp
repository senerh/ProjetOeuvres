<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:template>
	<jsp:attribute name="title">Accueil</jsp:attribute>
	<jsp:attribute name="content">
	
	<SCRIPT language="Javascript" type="text/javascript">
<script type="text/javascript" src="js/foncControle.js"></script>

	<H1> Ajout d'un adhérent </H1> 

<DIV align="center">
<FORM  name='identification' method="post" action="Controleur?action=insererAdherent" onsubmit="return teste()">
     <P align="left"><FONT face="Arial" color="#004080"></FONT>     
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
      
</P></FORM>
</DIV>
	
    </jsp:attribute>
</t:template>