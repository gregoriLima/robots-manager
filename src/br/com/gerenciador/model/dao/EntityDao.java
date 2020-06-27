package br.com.gerenciador.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.InsertOneOptions;

import br.com.gerenciador.model.Robo;

public class EntityDao implements IDao {

	private Class persistentClass; //para recuperar o nome da classe e criar a coleção com este nome
//	private DBCollection dbCollection;
	private MongoDatabase mongoDb;
	private MongoCollection<Document> robosCollection;
	
	//construtor
	protected EntityDao(Class persistentClass){
		this.persistentClass = persistentClass;
		this.mongoDb = MongoConnection.getInstance().getDatabase("Factory");
		this.robosCollection = mongoDb.getCollection(persistentClass.getSimpleName());
	}
	
	@Override
	public void save(Map mapEntity) {
			System.out.println("no EntityDao: " +mapEntity);
		robosCollection.insertOne(new Document(mapEntity));

	}

	@Override
	public void update(int id, Map mapEntity) {

			////$set para indicar que é uma atualiação
		robosCollection.updateOne(Filters.eq("id", id), new Document("$set", new Document(mapEntity)));

	}

	@Override
	public void delete(Map mapEntity) {
			
		robosCollection.deleteOne(new BasicDBObject(mapEntity));

	}

	@Override
	public DBObject findOne(Map mapEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
							
		MongoCursor<Document> cursor =  robosCollection.find().cursor();
		cursor.forEachRemaining(System.out::println);
		//System.out.println(cursor.next());
		
		return null;
	}

	@Override
	public List findKeyValue(Map keyValue) {
		// TODO Auto-generated method stub
		return null;
	}

}
