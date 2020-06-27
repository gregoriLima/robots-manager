package br.com.gerenciador.model.dao;

import java.util.List;
import java.util.Map;

import com.mongodb.DBObject;

public interface IDao {

	void save(Map mapEntity);
	
	void update (int id, Map mapEntity);
	
	void delete(Map mapEntity);
	
	DBObject findOne(Map mapEntity);
	
	List findAll();
	
	List findKeyValue(Map keyValue);
	
}
