<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:layout>
	<jsp:attribute name="body">
        <P>
			<A href="index.jsp"><FONT face="Arial" color="#004080">Retour Accueil</FONT></A>
		</P>
		<P align="center">
			<FONT face="Arial" size="5" color="#004080"><U> <STRONG>Listing&nbsp;des
				Adhérents </STRONG></U></FONT>
		</P>

		<TABLE class="table-responsive" BORDER="1">
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
</t:layout>
