
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL e Scriptlet</title>
</head>
<body>
	
	<br>

	<c:if test="${empty lista}">

		<br> Erro, nenhum robô cadastrado! <br>

	</c:if>

	<br>
	<c:if test="${not empty lista}">
	<!-- Com jstl: -->
	<br>Lista de todos os robôs já cadastrados:
	<br>
	<ul>
		<c:forEach items="${lista}" var="robo">
			<li>${robo.nome}<br> Criado em: ${robo.data} 
				<a href="/gerenciador/entrada?action=MostraRobo&id=${robo.id}"> modificar </a>
				<a href="/gerenciador/entrada?action=RemoveRobo&id=${robo.id}"> remover </a>
			</li>
			</br>
		</c:forEach>
	</ul>
</c:if>
</body>


<c:import url="parcialLogout.jsp"/>
    
    
   
</html>