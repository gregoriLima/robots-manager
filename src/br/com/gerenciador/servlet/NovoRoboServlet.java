package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;


//Desabilitando para que o �nico servlet acess�vel seja o EntradaServlet e estes n�o estejam mais acess�veis
//@WebServlet("/novoRobo")
public class NovoRoboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //vari�vel opcional

	
	
	//O m�todo doPost s� aceita Post. Caso alguem tente fazer um Get um erro 405 � retornado
		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			System.out.println("Cadastrando um novo robo na empresa!");
			
			Robo robo = new Robo();
			
			String nome = req.getParameter("nome");
			String marca = req.getParameter("marca");
			String modelo = req.getParameter("modelo");
			
			robo.setNome(nome);
			robo.setMarca(marca);
			robo.setModelo(modelo);
			
			Banco banco = new Banco();
			banco.adiciona(robo);
			
			
			
			
			
			//C�digo reescrito em uma JSP para separa��o de responsabilidades
//			PrintWriter response = resp.getWriter();
//			response.println("<html><body>Novo rob�: " + 
//					"<br><br> NOME: " + nome +
//					"<br> MARCA: " + marca +
//					"<br> MODELO: " + modelo + 
//					"<br><br> Cadastrado na empresa com sucesso!</body></html>");
			
			
			//Como a req j� possui um m�todo espec�fico para despachar a requisi��o para o JSP
			//o getRequestDispatcher(), � pegado o retorno dest m�todo que � um RequestDispatcher
			//e para prosseguir com a requisi��o � utilizado o m�todo forward
//			RequestDispatcher rd = req.getRequestDispatcher("/novoRoboCriado.jsp"); //aqui indica que a requisi��o deve ser enviada para a jsp
																					//� um Request Client Side, o navegador que far� um redirecionamento
//			RequestDispatcher rd = req.getRequestDispatcher("/listaRobos"); //intercomunicando com outro servlet, � um Request Server Side
			
//			req.setAttribute("nome", nome); //inserindo informa��es no request
//			req.setAttribute("marca", marca);
//			req.setAttribute("modelo", modelo);
//			rd.forward(req, resp);
			//a partir daqui toda requisi��o � redirecionada para outro servlet

			
			//n�o mais usando o despachador e sim devolvendo uma resposta ao navegador. 
			//Redirecionando o navegador:
			resp.sendRedirect("listaRobos"); //fazendo um redirecionamento no navegador para listaRobos
											//o navagador acessa formNovoRobo.jsp que redireciona para NovoRoboServlet e aqui
											//quando o navegador acessa, � respondido na requisi��o HTTP automaticamente o redirecionamento
											//para \listaRobos que o navegador deve fazer
			
		}
	
}
