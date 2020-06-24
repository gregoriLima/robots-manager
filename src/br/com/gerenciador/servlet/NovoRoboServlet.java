package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;


//Desabilitando para que o único servlet acessível seja o EntradaServlet e estes não estejam mais acessíveis
//@WebServlet("/novoRobo")
public class NovoRoboServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; //variável opcional

	
	
	//O método doPost só aceita Post. Caso alguem tente fazer um Get um erro 405 é retornado
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
			
			
			
			
			
			//Código reescrito em uma JSP para separação de responsabilidades
//			PrintWriter response = resp.getWriter();
//			response.println("<html><body>Novo robô: " + 
//					"<br><br> NOME: " + nome +
//					"<br> MARCA: " + marca +
//					"<br> MODELO: " + modelo + 
//					"<br><br> Cadastrado na empresa com sucesso!</body></html>");
			
			
			//Como a req já possui um método específico para despachar a requisição para o JSP
			//o getRequestDispatcher(), é pegado o retorno dest método que é um RequestDispatcher
			//e para prosseguir com a requisição é utilizado o método forward
//			RequestDispatcher rd = req.getRequestDispatcher("/novoRoboCriado.jsp"); //aqui indica que a requisição deve ser enviada para a jsp
																					//é um Request Client Side, o navegador que fará um redirecionamento
//			RequestDispatcher rd = req.getRequestDispatcher("/listaRobos"); //intercomunicando com outro servlet, é um Request Server Side
			
//			req.setAttribute("nome", nome); //inserindo informações no request
//			req.setAttribute("marca", marca);
//			req.setAttribute("modelo", modelo);
//			rd.forward(req, resp);
			//a partir daqui toda requisição é redirecionada para outro servlet

			
			//não mais usando o despachador e sim devolvendo uma resposta ao navegador. 
			//Redirecionando o navegador:
			resp.sendRedirect("listaRobos"); //fazendo um redirecionamento no navegador para listaRobos
											//o navagador acessa formNovoRobo.jsp que redireciona para NovoRoboServlet e aqui
											//quando o navegador acessa, é respondido na requisição HTTP automaticamente o redirecionamento
											//para \listaRobos que o navegador deve fazer
			
		}
	
}
