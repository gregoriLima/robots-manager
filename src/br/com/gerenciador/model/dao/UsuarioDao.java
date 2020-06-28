package br.com.gerenciador.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.DBObject;

import br.com.gerenciador.model.Usuario;
import br.com.gerenciador.model.Usuario;

public class UsuarioDao extends EntityDao {

	public UsuarioDao() {
		super(Usuario.class); // passa a classe de Usuario para que a collection tenha este nome
	}

	public void adiciona(Usuario usuario) {

		usuario.setId(getMongoDBSize() + 1); // define o ID como a quantidade de documentos +1

		// convertendo POJO para JSON
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(usuario);// obj is your object
		// convertendo JSON para Map
		Map<String, String> result = new Gson().fromJson(json, Map.class);
		System.out.println("no UsuarioDao: " + result);

		super.save(result);

	}

	public List<Usuario> getListaUsuarios() {
		return findAll();
	}

	public void removeUsuario(long id) {

		Map map = new HashMap();
		map.put("_id", id);
		delete(map);

	}

	public Usuario buscaPeloId(long id) {

		Map map = new HashMap();
		map.put("_id", id);

		Document doc = findOne(map);

		if(doc != null) {
		// passando de JSON para Usuario
		Gson gson = new Gson();
		String jsonInString = doc.toJson();
		Usuario r = gson.fromJson(jsonInString, Usuario.class);

		return r;}
		
		return null;
	}

	public Usuario existeUsuario(String nomeUsuario, String senhaUsuario) {

		Map mapa = new HashMap();
		mapa.put("login", nomeUsuario);
		
		Document doc = findOne(mapa);
		
		
		if(doc!=null) {
			
			// passando de JSON para Usuario
			Gson gson = new Gson();
			String jsonInString = doc.toJson();
			Usuario r = gson.fromJson(jsonInString, Usuario.class);
				
			if(r.getSenha().equals(senhaUsuario))
			return r;
		}
		
		return null;
	}


}
