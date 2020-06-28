package br.com.gerenciador.servlet;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.action.Action;

//ultimo filtro da lista definido no web.xml

//No Spring, os filtros chamam-se 'interceptadores'

@WebFilter("/entrada")
public class ControladorFiltro implements Filter {

	//Filtro que substitui EntradaServlet.java
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("#Controlador filter");
		
		//parsing dos objetos argumentos do m�todo
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");//verifica a a��o solicitada pelo navegador
		
		System.out.println("action vindo do cliente" + paramAction);
		
		String nome = null;
	String nomeDaClasse = "br.com.gerenciador.action." + paramAction; //paramAction que vem do navegador
		
		try {
			System.out.println(nomeDaClasse);
			Class classe = Class.forName(nomeDaClasse); //Carregando a classe a partir do nome, apenas carrega a classe na mem�ria, n�o instancia ela
			Constructor constructor = classe.getConstructor();
			Action action = (Action) constructor.newInstance();
			nome = action.exec(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e) {
			throw new ServletException(e);
		} 
		
		String[] tipoDirecionamento = nome.split(":"); //tipoDirecionamento passado pelos Servlets
	
		if(tipoDirecionamento[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoDirecionamento[1]);
			rd.forward(request, response);
			} else {
				response.sendRedirect(tipoDirecionamento[1]); //entrada?action=... 
			}
		
//		chain.doFilter(request, response); //linha comentada, pois este � o �ltimo filtro da cadeia de tr�s filtros e n�o 
												//queremos que ele chame o pr�ximo
	}

	
	//m�todos para tornar o filtro compat�vel com o Jetty e com vers�es antigas do TomCat
		@Override
		public void init(FilterConfig filterConfig) throws ServletException {
			// TODO Auto-generated method stub
			Filter.super.init(filterConfig);
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			Filter.super.destroy();
		}

}
