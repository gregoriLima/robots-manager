package br.com.gerenciador.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.dao.RoboDao;

public class MostraRobo implements Action{

	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Action mostra robo");
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Robo robo = new RoboDao().buscaPeloId(id);//Banco.buscaRoboPeloId(id);
		
		System.out.println(robo.getNome());
		
		request.setAttribute("robo", robo);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraRobo.jsp");
//		rd.forward(request, response);
		
		return "forward:formAlteraRobo.jsp";
		
	}

}
