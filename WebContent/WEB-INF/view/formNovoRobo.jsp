
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/entrada" var="linkServletNovoRobo"/>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovoRobo}" method="post">

        Nome: <input type="text" name="nome" /><br><br>
        Marca: <input type="text" name="marca" /><br><br>
        Modelo: <input type="text" name="modelo" /><br><br><br>
			<input type="hidden" name="action" value="NovoRobo" />
        <input type="submit" />
    </form>
    
   


</body>

<c:import url="parcialLogout.jsp"/>
</html>