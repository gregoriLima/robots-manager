  package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//Servlet � uma forma de atrelar uma requisi��o HTTP a um objeto Java

//utilizando annotations para definir o nome da servlet na url
@WebServlet(urlPatterns = "/ola") //loadOnStartup=1 instancia esta classe na subida do servidor
public class ServletOne extends HttpServlet { //um Servlet deve extender HttpServlet

	//Singleton - somente uma inst�ncia � criada pelo tomcat a partir da primeira requisi��o do browser. O objeto � reaproveitado pelo tomcat
	//Singleton significa que o objeto vive para sempre. � o escopo
	
//	ioc - invers�o de controle - quem trabalha com. Quem instancia as classses � o tomcat, por isso n�o precisa o instancialas com o main
	//apenas implementamos as regras de neg�cio
	
	//Servlet � um objeto que pode ser acionado atrav�s de uma requisi��o HTTP
	
	//quando este m�todo � chamado, j� aponta para a refer�ncia dos objetos que
	//cont�m a requisi��o e a resposta
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Ol�, esta resposta foi gerada em um Servlet!");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("Servlet Ol� foi chamado!");
		
	}
}
