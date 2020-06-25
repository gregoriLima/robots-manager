package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;

public class RemoveRobo implements Action{

	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("Action removendo Robo");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		Banco.removeRobo(id);
		
		//aqui é feito a requisição pelo navegador
//		response.sendRedirect("entrada?action=ListaRobos");
		
		return "redirect:entrada?action=ListaRobos";
		
		
	}

}
