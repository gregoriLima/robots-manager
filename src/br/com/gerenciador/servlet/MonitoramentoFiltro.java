package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//mapeando a requisição para a execução deste objeto
//assim, todas as requisições que chegarem para EntradaServlet, passarão por aqui antes
//@WebFilter(urlPatterns="/entrada") //urlPatterns= é opcional
//mapeamento definido no web.xml para garantir a ordem de execução dos filtros:

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

	
	//a requisição passa pelo filtro, que faz a medição do tempo e delega a requisição para o próximo passo
	//que então volta pelo filtro, que salva novamente o tempo atual e imprime na tela.
	//tudo que pode ser feito em um Servlet, pode ser feito em um filtro
	
	@Override //Filtros recebem ServletRequest ao invés de HttpServletRequest.
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("Monitoramento filter");
		
		long antes = System.currentTimeMillis();

		String action = request.getParameter("action");
		
		//executa a ação
		//caso este método não seja chamado, a requisição para.
		//esta é a diferença entre filtros e servlets
		chain.doFilter(request, response);

		long depois = System.currentTimeMillis();

		System.out.println("Tempo de execução de " + action + " " + (depois - antes));

	}

	//métodos para tornar o filtro compatível com o Jetty e com versões antigas do TomCat
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
