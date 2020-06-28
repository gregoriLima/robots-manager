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
<title>Cadastro</title>


</head>
<body>


<c:import url="parcialLogout.jsp"/>


<div id="formularioEdicao" class="container">
    <h3 class="main-title center">Cadastrar Robo</h3>
    <div class="row">
      <form class="col s12" action="#" th:action="@{/aluno/salvar}" th:object="${aluno}" method="post">
        <div class="section">
          <h5>Dados Básicos</h5>
          <div class="row">
            <div class="input-field col s12">
<!--               <input id="nome" type="text" th:field="*{nome}" /> -->
				<input type="text" name="nome" required />
              <label for="nome">Nome</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
<!--               <input id="dataNascimento" type="date" class="datepicker" th:field="*{dataNascimento}"   /> -->
              <input type="text" name="marca" required />
              <label for="dataNascimento">Marca</label>
            </div>
          </div>
          <div class="row">
            <div class="input-field col s12">
<!--               <input id="curso" type="text" class="validate" th:field="*{curso.nome}"  /> -->
				<input type="text" name="modelo" required />
              <label for="curso">Modelo</label>
            </div>
          </div>

        </div> <!-- Fim SECTION Dados Basicos -->
        
<!--         <input type="hidden" name="action" value="NovoRobo" /> -->

        <div class="row">
          <div class="input-field col s12 center">
            <button class="btn waves-effect waves-light" type="submit" name="action" value="NovoRobo">Salvar Robo</button>
            <button class="btn waves-effect waves-light" type="submit" onclick="javascript:dashboard.submit()" value="Dashboard">Cancelar</button>
          </div>
        </div>
      </form>
      
      		    <form name='dashboard' action="${linkServletEntrada}" method="post" >
	          		<input type="hidden" name="action" value="Dashboard">
	            </form>

    </div>

  </div> <!-- Fim do formulario de edicao -->





<%-- 	<form action="${linkServletNovoRobo}" method="post"> --%>

<!--         Nome: <input type="text" name="nome" required /><br><br> -->
<!--         Marca: <input type="text" name="marca" required /><br><br> -->
<!--         Modelo: <input type="text" name="modelo" required /><br><br><br> -->
<!-- 			<input type="hidden" name="action" value="NovoRobo" /> -->
<!--         <input type="submit" /> -->
<!--     </form> -->
<!--     <br> -->
<%--     <form action="${linkServletEntrada}" method="post"> --%>
<!-- 		<input type="hidden" name="action" value="ListaRobos" readonly> -->
<!-- 		<input type="submit" value="Cancelar" /> -->
<!-- 	</form> -->
   



<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.100.2/js/materialize.min.js"></script>
</body>

</html>