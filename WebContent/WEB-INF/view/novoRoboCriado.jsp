
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<c:if test="${not empty nome}">

	Novo robô: 
	
	<br><!--Exemplo em EL e scriptlet-->
	<br> NOME: ${ nome }
	<br> MARCA: ${ marca }
	<br> MODELO: ${ modelo } 
	<br>
	<br> Cadastrado na empresa com sucesso!

</c:if>

<c:if test="${empty nome}">

	<br> Erro, nenhum robô cadastrado!

</c:if>

</body>

<c:import url="parcialLogout.jsp"/>


</html>
