package br.com.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.gerenciador.action.Action;

//Classe responsável por todo o fluxo de informações


//@WebServlet("/entrada") //removido mapeamento pois a lógica foi implementada em um filtro
@Deprecated
public class EntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramAction = request.getParameter("action");//verifica a ação solicitada pelo navegador
		
		
		/*/---LÓGICA DE AUTORIZAÇÃO IMPLEMENTADA EM UM FILTRO
		//determina se uma action é protegida ou não de acesso sem login
		boolean actionProtected = !(paramAction.equals("LoginForm") || paramAction.equals("Login")); 
		
		HttpSession sessao = request.getSession();
		boolean naoLogado = sessao.getAttribute("usuarioLogado")==null; //verifica se há um usuário logado na sessão
			if(naoLogado && actionProtected) {
				System.out.println("redirecionado");
				response.sendRedirect("http://localhost:8080/gerenciador/entrada?action=LoginForm"); //caso não, redireciona para tela de login
				return;
			}
		//---------*/	
		

		String nome = null;
		
//		switch (paramAction) {
//				case "ListaRobos" -> {
//					// delegando a responsabilidade
//					var actionListaRobos = new ListaRobos();
//					nome = actionListaRobos.exec(request, response);
//				}
//				case "RemoveRobo" -> {
//					var actionRemoveRobos = new RemoveRobo();
//					nome = actionRemoveRobos.exec(request, response);
//				}
//				case "AlteraRobo" -> {
//					var actionAlteraRobo = new AlteraRobo();
//					nome = actionAlteraRobo.exec(request, response);
//				}
//				case "MostraRobo" -> {
//					var actionMostraRobo = new MostraRobo();
//					nome = actionMostraRobo.exec(request, response);
//				}
//				case "NovoRobo" -> {
//					var actionNovoRobo = new NovoRobo();
//					nome = actionNovoRobo.exec(request, response);
//				}
//				case "NovoRoboForm" ->{
//					var actionNovoRoboForm = new NovoRoboForm();
//					nome = actionNovoRoboForm.exec(request, response);
//				}
//		
//				default -> throw new IllegalArgumentException("Unexpected value: " + paramAction);
//		}

		
		//refatorando o código acima utilizando Reflection:
		String nomeDaClasse = "br.com.gerenciador.action." + paramAction; //paramAction que vem do navegador
		
		try {
			System.out.println(nomeDaClasse);
			Class classe = Class.forName(nomeDaClasse); //Carregando a classe a partir do nome, apenas carrega a classe na memória, não instancia ela
			Constructor constructor = classe.getConstructor();
			Action action = (Action) constructor.newInstance();
			nome = action.exec(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
			throw new ServletException(e);
		} 
		
		
		
		
		String[] tipoDirecionamento = nome.split(":"); //tipoDirecionamento passado pelos Servlets
		
		//ou se chama o .jsp (forward) dentro da mesma requisição utilizando o Dispatcher
		//ou instrui o navegador a fazer uma nova requisição 
	
		//Request server side
		//else Request client side
		if(tipoDirecionamento[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDirecionamento[1]);
			rd.forward(request, response);
			} else {
				response.sendRedirect(tipoDirecionamento[1]); //entrada?action=... 
			}

		
		
		
		
	}

}
