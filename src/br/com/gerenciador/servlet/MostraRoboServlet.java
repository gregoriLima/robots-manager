package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.dao.RoboDao;

//Desabilitando para que o único servlet acessível seja o EntradaServlet e estes não estejam mais acessíveis
//@WebServlet("/mostraRobo")
@Deprecated
public class MostraRoboServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Robo robo = new RoboDao().buscaPeloId(id);// Banco.buscaRoboPeloId(id);
		
		System.out.println(robo.getNome());
		
		request.setAttribute("robo", robo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraRobo.jsp");
		rd.forward(request, response);
	}

	
}
