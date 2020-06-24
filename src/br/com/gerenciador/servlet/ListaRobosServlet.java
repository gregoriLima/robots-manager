package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;

//Desabilitando para que o único servlet acessível seja o EntradaServlet e estes não estejam mais acessíveis
//@WebServlet("/listaRobos")
public class ListaRobosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Banco banco = new Banco();
		List<Robo> lista = banco.getListaRobos();
	
		
		
//		PrintWriter out = response.getWriter();
//	        out.println("<html><body>");
//	        out.println("<ul>");
//	        	for (Robo robo : lista) {
//					out.println("<li>" + robo.getNome() + "<li>");
//				}
//	        out.println("</ul>");
//	        out.println("</body></html>");
	
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaRobos.jsp");
		request.setAttribute("lista", lista);
		rd.forward(request, response);
		
	}

}
