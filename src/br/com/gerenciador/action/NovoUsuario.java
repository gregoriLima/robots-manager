package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Usuario;
import br.com.gerenciador.model.dao.UsuarioDao;

public class NovoUsuario implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("No NovoUsuario");
		
		Usuario usuario = new Usuario();
		usuario.setLogin(request.getParameter("login"));
		usuario.setSenha(request.getParameter("senha"));

		
		new UsuarioDao().adiciona(usuario);
		
		return "redirect:entrada?action=LoginForm";
	}

}
