<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<t:template>
    <jsp:attribute name="title">Adhérents</jsp:attribute>
    <jsp:attribute name="content">
        <h2>Liste des adhérents</h2>

        <table class="table table-striped">
    		<tr>
    			<th>Numero</th>
    			<th>Nom</th>
    			<th>Prénom</th>
    			<th>Ville</th>
    		</tr>
    		<c:forEach items="${mesAdherents}" var="item">
    			<tr>
    				<td>${item.idAdherent}</td>
    				<td>${item.nomAdherent}</td>
    				<td>${item.prenomAdherent}</td>
                    <td>${item.villeAdherent}</td>
    			</tr>
    		</c:forEach>
    	</table>
    </jsp:attribute>
</t:template>
