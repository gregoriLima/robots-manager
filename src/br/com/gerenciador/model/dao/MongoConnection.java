package br.com.gerenciador.model.dao;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.gerenciador.model.Robo;
import br.com.gerenciador.model.Usuario;

public class MongoConnection{
	
//	private static final String HOST = "localhost";
//	private static final int PORT = 27017;
	private static final String DB_NAME = "robots";
	
	//padr�o Singleton para utilizar um �nico objeto em toda aplica��o para conex�o com o MongoDB
//	private static MongoConnection uniqInstance;
//	private static int mongoInstance = 1;
	private static MongoClient client;
	
//	private Mongo mongo;
//	private DB db;
	
	private MongoConnection() { //construtor privado
		//para permitir que esta classe n�o seja herdada ou instanciada por
		//outras classes
	}
	
	
//	//garante que apenas uma �nica mesma inst�ncia ser� utilizada
//	public static synchronized MongoConnection getInstance() {
//		
//		if(uniqInstance==null)
//			uniqInstance = new MongoConnection();
//		
//		return uniqInstance;
//	}
//
//	//garante um �nico objeto Mongo
//	public DB getDB() {
//		if(mongo==null) {
//			mongo = new Mongo(HOST, PORT);
//			db = mongo.getDB(DB_NAME);
//		}
//		return db;
//	}
	
	public static synchronized MongoClient getInstance() {
		if(client == null)
			client = new MongoClient();
		
		return client;
	}

	public static void main(String[] args) {
		
//		RoboDao rdao = new RoboDao(); 
//		Robo r = new Robo();
//		r.setMarca("Fanuc");
//		r.setModelo("2001");
//		r.setNome("Robo novo");
//		rdao.adiciona(r);
		
//		UsuarioDao udao = new UsuarioDao();
//		Usuario usuario = new Usuario();
//		usuario.setLogin("gregori");
//		usuario.setSenha("1234");
//		udao.adiciona(usuario);
		
//		System.out.println(udao.getListaUsuarios());
//		
//		System.out.println(rdao.findAll());
//		
//		Robo rob = rdao.getListaRobos().get(0);
//		System.out.println(rob.getNome());
//		rob.setNome("FFFFFFFFFF");
//		rdao.alteraRobo(rob);
//		rob = rdao.getListaRobos().get(0);
//		System.out.println(rob.getNome());
		
	}

}
