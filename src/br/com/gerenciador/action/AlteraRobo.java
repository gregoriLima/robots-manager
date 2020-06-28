package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.dao.RoboDao;

public class AlteraRobo implements Action {

	public String exec(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		String nomeRobo = request.getParameter("nome");
		String marcaRobo = request.getParameter("marca");
		String modeloRobo = request.getParameter("modelo");
		Integer IdRobo = Integer.valueOf(request.getParameter("id"));
		
		System.out.println("Action Altera Robo" + IdRobo);
		
		RoboDao rdao = new RoboDao();
		
		Robo robo = rdao.buscaPeloId(IdRobo);//Banco.buscaRoboPeloId(IdRobo);
		robo.setNome(nomeRobo);
		robo.setMarca(marcaRobo);
		robo.setModelo(modeloRobo);
		
		rdao.alteraRobo(robo);
		
		return "redirect:entrada?action=ListaRobos";
		
	}

}
