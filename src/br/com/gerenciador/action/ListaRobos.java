package br.com.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;

//Este não é um servlet

public class ListaRobos {
 
	
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Action listando Robos");
		
		Banco banco = new Banco();
		List<Robo> lista = banco.getListaRobos();
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaRobos.jsp");
		request.setAttribute("lista", lista);
		rd.forward(request, response);
	
	}
	
}
