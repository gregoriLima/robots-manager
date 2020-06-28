package br.com.gerenciador.model.dao;

import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.DBObject;

public interface IDao {

	void save(Map mapEntity);
	
	void update (long id, Map mapEntity);
	
	void delete(Map mapEntity);
	
	Document findOne(Map mapEntity);
	
	List findAll();
	
	List findKeyValue(Map keyValue);
	
}
