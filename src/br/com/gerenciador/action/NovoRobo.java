package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;

public class NovoRobo implements Action{

	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Action Novo Robo");
		
		Robo robo = new Robo();
		
		String nome = request.getParameter("nome");
		String marca = request.getParameter("marca");
		String modelo = request.getParameter("modelo");
		
		robo.setNome(nome);
		robo.setMarca(marca);
		robo.setModelo(modelo);
		
		Banco banco = new Banco();
		banco.adiciona(robo);
		
		return "redirect:entrada?action=ListaRobos";
		
	}

}
