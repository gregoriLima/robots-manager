package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.action.AlteraRobo;
import br.com.gerenciador.action.ListaRobos;
import br.com.gerenciador.action.MostraRobo;
import br.com.gerenciador.action.NovoRobo;
import br.com.gerenciador.action.RemoveRobo;


@WebServlet("/entrada")
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");
		
		switch (paramAction) {
		case "ListaRobos" ->{
			//delegando responsabilidade
			ListaRobos actionListaRobos = new ListaRobos();
			actionListaRobos.exec(request, response);
		}
		case "RemoveRobo" -> {
			RemoveRobo actionRemoveRobos = new RemoveRobo();
			actionRemoveRobos.exec(request, response);
		}
		case "AlteraRobo" -> {
			AlteraRobo actionAlteraRobo = new AlteraRobo();
			actionAlteraRobo.exec(request, response);
		}
		case "MostraRobo" -> {
			MostraRobo actionMostraRobo = new MostraRobo();
			actionMostraRobo.exec(request, response);
		}
		case "NovoRobo" -> {
			NovoRobo actionNovoRobo = new NovoRobo();
			actionNovoRobo.exec(request, response);
		}
		
		default ->
		throw new IllegalArgumentException("Unexpected value: " + paramAction);
		}
	
		
	}

}
