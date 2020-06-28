<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/entrada" var="linkServletEntrada" />

<!DOCTYPE html>
<html>
<head>
<link href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/css/materialize.min.css" rel="stylesheet"/>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Sistema de Cadastro de Robos</title>
</head>
<body class="grey lighten-3">
	
	<c:import url="parcialLogout.jsp"/>
	
	<form action="${linkServletEntrada}" method="post">
		<input type="hidden" name="action" value="NovoRoboForm" readonly>
		<input type="submit" value="Cadastrar novo robo" />
	</form>
	
	
	<c:if test="${empty lista}">

		<br> Erro, nenhum robô cadastrado! <br>

	</c:if>

	<br>
	<c:if test="${not empty lista}">
	
	
	<div id="listaDeAlunos">
    <h3 class="main-title center">Lista de Robos</h3>
    <div class="container">
      <table class="striped responsive-table">
        <thead>
          <tr>
            <th style="text-align: center;">Nome</th>
            <th style="text-align: center;">Marca</th>
            <th style="text-align: center;">Modelo</th>
            <th style="text-align: center;">Data de Criação</th>
            <th style="text-align: center;">ID</th>
          </tr>
        </thead>
        
        <c:forEach items="${lista}" var="robo">
       		 <tr>
          <td style="text-align: center;"><span th:text="${robo.nome}"></span>${robo.nome}</td>
          <td style="text-align: center;"><span th:text="${robo.marca}"></span>${robo.marca}</td>
          <td style="text-align: center;"><span th:text="${robo.modelo}"></span>${robo.modelo}</td>
          <td style="text-align: center;"><span th:text="${robo.data}"></span>${robo.data}</td>
          <td style="text-align: center;"><span th:text="${robo.id}"></span>${robo.id}</td> 
           <td style="text-align: center;">
            <a href="/gerenciador/entrada?action=MostraRobo&id=${robo.id}" title="Editar">
              <i class="tiny material-icons ">edit</i>
            </a>
            &nbsp&nbsp
            <a href="/gerenciador/entrada?action=RemoveRobo&id=${robo.id}" title="Excluir">
              <i class="tiny material-icons ">delete_forever </i>
            </a>
          </td>
         
         
        </tr>
     	</c:forEach>
      </table>
    </div>
  </div><!-- Fim DIV listar robos -->
	
<!-- 	<br>Lista de todos os robôs já cadastrados: -->
<!-- 	<br> -->
<!-- 	<ul> -->
<%-- 		<c:forEach items="${lista}" var="robo"> --%>
<%-- 			<li>Robo: ${robo.nome}<br>  --%>
<%-- 				Marca: ${robo.marca } <br> --%>
<%-- 				Modelo: ${robo.modelo } <br> --%>
<%-- 				Criado em: ${robo.data}  --%>
<%-- 				<a href="/gerenciador/entrada?action=MostraRobo&id=${robo.id}"> modificar </a> --%>
<%-- 				<a href="/gerenciador/entrada?action=RemoveRobo&id=${robo.id}"> remover </a> --%>
<!-- 			</li> -->
<!-- 			</br> -->
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
</c:if>

	


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>



    
    
   
</html>