<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
	Por favor, informe o usuário e a senha para prosseguir:

<br><br>
    <form action="${linkEntradaServlet }" method="post">

        Login: <input type="text" name="login"  /><br><br>
        Senha: <input type="password" name="senha"  /><br><br>

<!--         <input type="hidden" name="action" value="Login" />  -->

		
       &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
<!--        <input type="submit" name="action" value="Login" /> -->
			<button type="submit" name="action" value="Login">Entrar</button>
        &nbsp&nbsp
        <button type="submit" name="action" value="NovoUsuarioForm">Novo usuário</button>
      
    </form>

		
		
</body>
</html>