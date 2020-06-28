package br.com.gerenciador.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.dao.RoboDao;

//Este não é um servlet

public class ListaRobos implements Action{
 
	
	public String exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
//		HttpSession sessao = request.getSession();
//		if(sessao.getAttribute("usuarioLogado")==null) //verifica se há um usuário logado na sessão
//			return "redirect:entrada?action=LoginForm";
		
		System.out.println("Action listando Robos");
		
		//Banco banco = new Banco();
		List<Robo> lista = new RoboDao().getListaRobos(); //banco.getListaRobos();
		
		request.setAttribute("lista", lista);
		
//		RequestDispatcher rd = request.getRequestDispatcher("/listaRobos.jsp");
//		
//		rd.forward(request, response);
		System.out.println(request.getAttribute("usuarioLogado"));
		
		return "forward:listaRobos.jsp";
		
	}
	
}
