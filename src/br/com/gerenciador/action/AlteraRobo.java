package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;

public class AlteraRobo {

	public void exec(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String nomeRobo = request.getParameter("nome");
		String marcaRobo = request.getParameter("maraca");
		String modeloRobo = request.getParameter("modelo");
		Integer IdRobo = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("Action Altera Robo" + IdRobo);
		
		Robo robo = Banco.buscaRoboPeloId(IdRobo);
		robo.setNome(nomeRobo);
		robo.setMarca(marcaRobo);
		robo.setModelo(modeloRobo);
		
		response.sendRedirect("entrada?action=ListaRobos");
		
	}

}
