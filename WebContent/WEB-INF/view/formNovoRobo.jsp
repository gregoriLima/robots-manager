
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkServletNovoRobo"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<c:import url="parcialLogout.jsp"/>


	Cadastro de um novo robo:
	
	<br><br>

	<form action="${linkServletNovoRobo}" method="post">

        Nome: <input type="text" name="nome" required /><br><br>
        Marca: <input type="text" name="marca" required /><br><br>
        Modelo: <input type="text" name="modelo" required /><br><br><br>
			<input type="hidden" name="action" value="NovoRobo" />
        <input type="submit" />
    </form>
    <br>
    <form action="${linkServletEntrada}" method="post">
		<input type="hidden" name="action" value="ListaRobos" readonly>
		<input type="submit" value="Cancelar" />
	</form>
   


</body>

</html>