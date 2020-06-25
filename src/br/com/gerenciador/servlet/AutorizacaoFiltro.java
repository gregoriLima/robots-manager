package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



//@WebFilter("/entrada") //mapeamento definido no web.xml para garantir a ordem de execu��o dos filtros em:
//<filter>
//<filter-name>AF</filter-name>
//<filter-class>br.com.gerenciador.servlet.AutorizacaoFiltro</filter-class>
//</filter>
//
//<filter-mapping>
//<filter-name>AF</filter-name>
//<url-pattern>/entrada</url-pattern>
//</filter-mapping>
public class AutorizacaoFiltro implements Filter {



	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

		System.out.println("Autoriza��o filter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String paramAction = request.getParameter("action");//verifica a a��o solicitada pelo navegador
		
		//determina se uma action � protegida ou n�o de acesso sem login
		boolean actionProtected = !(paramAction.equals("LoginForm") || paramAction.equals("Login")); 
		
		HttpSession sessao = request.getSession();
		
		boolean naoLogado = sessao.getAttribute("usuarioLogado")==null; //verifica se h� um usu�rio logado na sess�o
			if(naoLogado && actionProtected) {
				System.out.println("redirecionado");
				response.sendRedirect("http://localhost:8080/gerenciador/entrada?action=LoginForm"); //caso n�o, redireciona para tela de login
				return;
			}
		
		chain.doFilter(request, response);
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
