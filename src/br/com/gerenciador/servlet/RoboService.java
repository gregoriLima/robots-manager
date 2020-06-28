package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gerenciador.model.Banco;
import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.dao.RoboDao;


@WebServlet("/robos")
public class RoboService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Webservice que devolve um Json
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		String valor = request.getHeader("accept");//pegando o valor do cabe�alho accept
		String valor = request.getHeader("Accept");
		
		List<Robo> robos = new RoboDao().getListaRobos();
		
//		if(valor.endsWith("json")) {
		if(valor.contains("json")) {
			//---Devolvendo a lista de rob�s em formato Json
			Gson gson = new Gson();
			String json = gson.toJson(robos);
			
//			response.setContentType("applicatoin/Json"); //definindo o tipo de conte�do que o usu�rio est� recebendo. Comentado para conseguir renderizar no navegador
			response.getWriter().println(json);//devolvendo a lista de rob�s em um Json
		} else if(valor.contains("xml")) {
			//---Devolvendo a lista de rob�s em formato XML
			XStream xstream = new XStream();
			xstream.alias("Robo", Robo.class);//definindo um alias para n�o apresenta o FQN da classe
			String xml = xstream.toXML(robos);
			
//			response.setContentType("applicatoin/XML"); //definindo o tipo de conte�do que o usu�rio est� recebendo. Comentado para conseguir renderizar no navegador
			response.getWriter().println(xml);//devolvendo a lista de rob�s em um Json
		}else { //caso o cliente n�o defina nem um xml nem um json
		    response.setContentType("application/json"); //definindo no cabe�alho do html o conte�do da resposta
		    response.getWriter().print("{'message':'no content'}");
		}
		
		
		
		

		
	}

}
