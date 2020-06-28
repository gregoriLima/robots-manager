package br.com.gerenciador.model.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

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
	private MongoCollection<Document> mongoCollection;
	
	//construtor
	protected EntityDao(Class persistentClass){
		this.persistentClass = persistentClass;
		this.mongoDb = MongoConnection.getInstance().getDatabase("Factory");
		this.mongoCollection = mongoDb.getCollection(persistentClass.getSimpleName());
	}
	
	@Override
	public void save(Map mapEntity) {
			System.out.println("no EntityDao: " +mapEntity);
		mongoCollection.insertOne(new Document(mapEntity));

	}

	@Override
	public void update(long id, Map mapEntity) {

			////$set para indicar que é uma atualiação
		mongoCollection.updateOne(Filters.eq("_id", id), new Document("$set", new Document(mapEntity)));

	}

	@Override
	public void delete(Map mapEntity) {
			
		mongoCollection.deleteOne(new BasicDBObject(mapEntity));

	}

	@Override
	public Document findOne(Map mapEntity) {
	
		String key = mapEntity.keySet().iterator().next().toString(); //pega a primeira chave do mapa
		
		Document vraiDoc = mongoCollection.find(
			    Filters.eq(key, mapEntity.get(key) ) ///verifica se há algum documento onde exista key com o valor 
			).first();
			
		return vraiDoc;
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		List<Document> lista = new ArrayList<>();
		MongoCursor<Document> cursor =  mongoCollection.find().cursor();
//		cursor.forEachRemaining(System.out::println);
		
		cursor.forEachRemaining(n -> lista.add(n));
		//System.out.println(cursor.next());
		
		return lista;
	}

	@Override
	public List findKeyValue(Map keyValue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long getMongoDBSize() {
		return mongoCollection.countDocuments();
	}

	public void removeAll() {
		mongoDb.drop();
	}
	
}
