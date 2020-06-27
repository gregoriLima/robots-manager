package br.com.gerenciador.model.dao;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.gerenciador.model.Robo;

public class RoboDao extends EntityDao{

	public RoboDao() {
		super(Robo.class); //passa a classe de Robo para que a collection tenha este nome
	}
	
	public void save(Robo robo) {

		//convertendo POJO para JSON
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(robo);// obj is your object 
		//convertendo JSON para Map
		Map<String,String> result = new Gson().fromJson(json, Map.class);
		System.out.println("no roboDao: " + result);
		
		super.save(result);
		
	}

}
