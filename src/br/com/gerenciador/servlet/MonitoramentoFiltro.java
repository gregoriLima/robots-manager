package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//mapeando a requisi��o para a execu��o deste objeto
//assim, todas as requisi��es que chegarem para EntradaServlet, passar�o por aqui antes
//@WebFilter(urlPatterns="/entrada") //urlPatterns= � opcional
//mapeamento definido no web.xml para garantir a ordem de execu��o dos filtros:

//<filter>
//<filter-name>MF</filter-name>
//<filter-class>br.com.gerenciador.servlet.MonitoramentoFiltro</filter-class>
//</filter>
//
//<filter-mapping>
//<filter-name>MF</filter-name>
//<url-pattern>/entrada</url-pattern>
//</filter-mapping>

public class MonitoramentoFiltro implements Filter { //Filtros devem implementar Filter de javax.servlet

	
	//a requisi��o passa pelo filtro, que faz a medi��o do tempo e delega a requisi��o para o pr�ximo passo
	//que ent�o volta pelo filtro, que salva novamente o tempo atual e imprime na tela.
	//tudo que pode ser feito em um Servlet, pode ser feito em um filtro
	
	@Override //Filtros recebem ServletRequest ao inv�s de HttpServletRequest.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Monitoramento filter");
		
		long antes = System.currentTimeMillis();

		String action = request.getParameter("action");
		
		//executa a a��o
		//caso este m�todo n�o seja chamado, a requisi��o para.
		//esta � a diferen�a entre filtros e servlets
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo de execu��o de " + action + " " + (depois - antes));

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
