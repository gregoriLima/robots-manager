package br.com.gerenciador.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.DBObject;

import br.com.gerenciador.model.Robo;

public class RoboDao extends EntityDao {

	public RoboDao() {
		super(Robo.class); // passa a classe de Robo para que a collection tenha este nome
	}

	public void adiciona(Robo robo) {

		robo.setId(getMongoDBSize() + 1); // define o ID como a quantidade de documentos +1

		// convertendo POJO para JSON
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(robo);
		// convertendo JSON para Map
		Map<String, String> result = new Gson().fromJson(json, Map.class);

		super.save(result);

	}

	public List<Robo> getListaRobos() {

		List<Robo> lista = new ArrayList<>();

		Document doc = new Document();
		Gson gson = new Gson();
		String jsonInString = new String();

		findAll().forEach(n -> {
			// transforma uma lista de Document para uma lista de Robo
			Robo r;
			lista.add(r = gson.fromJson(((Document) n).toJson(), Robo.class));
		});

		return lista;
	}

	public void removeRobo(long id) {

		Map map = new HashMap();
		map.put("_id", id);
		delete(map);

	}

	public Robo buscaPeloId(long id) {

		Map map = new HashMap();
		map.put("_id", id);

		Document doc = findOne(map);

		if (doc != null) {
			// passando de JSON para Robo
			Gson gson = new Gson();
			String jsonInString = doc.toJson();
			Robo r = gson.fromJson(jsonInString, Robo.class);

			return r;
		}

		return null;
	}

	public void alteraRobo(Robo robo) {

		// convertendo POJO para JSON
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(robo);
		// convertendo JSON para Map
		Map<String, String> result = new Gson().fromJson(json, Map.class);
		
		update(robo.getId(), result);
		
	}

}
