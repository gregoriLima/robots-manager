
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, java.util.ArrayList, br.com.gerenciador.model.Robo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL e Scriptlet</title>
</head>
<body>



	<c:if test="${not empty nome}">

	Novo robô: 
	
	<br>
		<!--Exemplo em EL e scriptlet-->
		<br> NOME: ${ nome }
	<br> MARCA: ${ marca }
	<br> MODELO: ${modelo} 
	<br>
		<br> Cadastrado na empresa com sucesso!<br>

	</c:if>

	<c:if test="${empty nome}">

		<br> Erro, nenhum robô cadastrado! <br>

	</c:if>


	<%
		//List<Robo> lista = (List<Robo>)request.getAttribute("lista");
	%>




	<br>



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

</body>
</html>