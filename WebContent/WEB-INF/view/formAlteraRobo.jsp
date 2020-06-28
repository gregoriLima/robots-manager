
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url value="/entrada" var="linkServletEntrada" />


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Robo</title>
</head>

<body>

	Modificar o robô:
	<br>
	<form action="${linkServletEntrada }" method="post">
		<br> <input type="hidden" name="action" value="AlteraRobo" readonly> 
		
			 Nome: <input type="text" name="nome" value="${robo.nome }" /><br>
		<br> Marca: <input type="text" name="marca" value="${robo.marca }" /><br>
		<br> Modelo: <input type="text" name="modelo" value="${robo.modelo }"><br>
		<br> ID: <input type="text" name="id" value="${robo.id }" readonly><br>
		<br> Data Criação: ${robo.data}<br>
		<br> <input type="submit" />
		<input type="hidden" name="action" value="ListaRobos" readonly>
		<input type="submit" value="Cancelar" />
	</form>

	

</body>

<c:import url="parcialLogout.jsp" />

</html>