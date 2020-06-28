<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	Cadastro de um novo usuario:
	
	<br><br>

	<form action="${linkServletNovoRobo}" method="post">

        Login: <input type="text" name="login" required /><br><br>
        Senha:  <input id="password" name="senha" type="password" pattern="^\S{4,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Deve ter no mínimo 4 caracteres' : ''); if(this.checkValidity()) form.password_two.pattern = this.value;" required><br><br>
        Repita a senha: <input id="password_two" name="senha_dois" type="password" pattern="^\S{4,}$" onchange="this.setCustomValidity(this.validity.patternMismatch ? 'Insira a mesma senha que você colocou acima' : '');" required><br><br><br>
       
     		<input type="hidden" name="action" value="NovoUsuario" />
        <input type="submit" />
    </form>
    <br>
    <form action="${linkServletEntrada}" method="post">
		<input type="hidden" name="action" value="ListaRobos" readonly>
		<input type="submit" value="Cancelar" />
	</form>
   

</body>
</html>