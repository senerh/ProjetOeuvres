<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<t:template>
	<jsp:attribute name="title">Liste Adhérent</jsp:attribute>
	<jsp:attribute name="content">
      <h1>Médiathèque de POLYTECH</h1>
      <P align="center">
		<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
					Adhérents </STRONG></U></FONT>
	</P>

	<TABLE BORDER="1">
		<CAPTION>Tableau des Adhérents</CAPTION>
		<TR>
			<TH>Numero</TH>
			<TH>Nom</TH>
			<TH>Prénom</TH>
			<TH>Ville</TH>

		</TR>

		<c:forEach items="${mesAdherents}" var="item">
			<tr>
				<td>${item.idAdherent}</td>
				<td>${item.nomAdherent}</td>
				<td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
			</tr>
		</c:forEach>
	</TABLE>
    </jsp:attribute>
</t:template>