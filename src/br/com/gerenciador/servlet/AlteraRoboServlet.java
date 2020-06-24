package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;

//Desabilitando para que o único servlet acessível seja o EntradaServlet e estes não estejam mais acessíveis
//@WebServlet("/alteraRobo")
public class AlteraRoboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Alterando Robo");
		

		String nomeRobo = request.getParameter("nome");
		String marcaRobo = request.getParameter("maraca");
		String modeloRobo = request.getParameter("modelo");
		Integer IdRobo = Integer.valueOf(request.getParameter("id"));
		
		Robo robo = Banco.buscaRoboPeloId(IdRobo);
		robo.setNome(nomeRobo);
		robo.setMarca(marcaRobo);
		robo.setModelo(modeloRobo);
		
		response.sendRedirect("listaRobos");
		
	}

}
