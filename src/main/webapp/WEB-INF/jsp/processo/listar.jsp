<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container">
	<div id="listaProcesso">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Nº de pub</th>
					<th>Nº do pedido Intenacional</th>
					<th>Data de Publicação</th>
					<th>Requerentes</th>
					<th>Título</th>
				</tr>
			</thead>
			<c:forEach var="processo" items="${processos}">
				<tr>
					<td>${processo.numPub}</td>
					<td>${processo.numInternacional}</td>
					<fmt:formatDate pattern="dd/MM/yyyy" value="${processo.dataPublicacao}" var="dataFormatada" />
					<td>${dataFormatada}</td>
					<td>${processo.requerentes}</td>
					<td>${processo.titulo}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</div>