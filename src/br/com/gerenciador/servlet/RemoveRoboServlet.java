package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.dao.RoboDao;

//Desabilitando para que o único servlet acessível seja o EntradaServlet e estes não estejam mais acessíveis
//@WebServlet("/removeRobo")
@Deprecated
public class RemoveRoboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		System.out.println(id);
		new RoboDao().removeRobo(id);//Banco.removeRobo(id);
		
		response.sendRedirect("listaRobos");
	}

}
