package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoUsuarioForm implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Novo Usuario");
		return "forward:formNovoUsuario.jsp";
	}

}
