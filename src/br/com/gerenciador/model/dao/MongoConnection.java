package br.com.gerenciador.model.dao;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import br.com.gerenciador.model.Robo;

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

		RoboDao rdao = new RoboDao(); 
		Robo r = new Robo();
		r.setMarca("Fanuc");
		r.setModelo("2001");
		r.setNome("Robo novo");
		rdao.save(r);
		
//		EntityDao mongoDAO = new EntityDao(Robo.class);
//		Map<String, String> mapa = new HashMap<>();
//		mapa.put("testeff", "gregori");
//		mongoDAO.save(mapa);
//		System.out.println(mapa);
		System.out.println(rdao.findAll());
		
		
		
	}

}
