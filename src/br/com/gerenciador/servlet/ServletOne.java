  package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//Servlet é uma forma de atrelar uma requisição HTTP a um objeto Java

//utilizando annotations para definir o nome da servlet na url
@WebServlet(urlPatterns = "/ola") //loadOnStartup=1 instancia esta classe na subida do servidor
public class ServletOne extends HttpServlet { //um Servlet deve extender HttpServlet

	//Singleton - somente uma instância é criada pelo tomcat a partir da primeira requisição do browser. O objeto é reaproveitado pelo tomcat
	//Singleton significa que o objeto vive para sempre. é o escopo
	
//	ioc - inversão de controle - quem trabalha com. Quem instancia as classses é o tomcat, por isso não precisa o instancialas com o main
	//apenas implementamos as regras de negócio
	
	//Servlet é um objeto que pode ser acionado através de uma requisição HTTP
	
	//quando este método é chamado, já aponta para a referência dos objetos que
	//contém a requisição e a resposta
	@Override
	public void service(ServletRequest req, ServletResponse res) throws IOException {
		
		PrintWriter out = res.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Olá, esta resposta foi gerada em um Servlet!");
        out.println("</body>");
        out.println("</html>");
        
        System.out.println("Servlet Olá foi chamado!");
		
	}
}
