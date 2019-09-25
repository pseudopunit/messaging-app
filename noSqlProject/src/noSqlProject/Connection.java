package noSqlProject;


import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Connection {

	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) {

		
		MongoClientURI uri = new MongoClientURI(
			    "mongodb://punit:pass@cluster0-shard-00-00-lzgpr.gcp.mongodb.net:27017,cluster0-shard-00-01-lzgpr.gcp.mongodb.net:27017,cluster0-shard-00-02-lzgpr.gcp.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true");

			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("test");
	        MongoCollection<Document> collection = database.getCollection("data");	

			Document person = new Document("name", "Anmol")
	                .append("branch", "EC");
			collection.insertOne(person);		
		/*
		
		//Connecting With Server Please add the external jar file first
		MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	//	System.out.println("server connection successfully done");
		
		//Connecting with database
//		MongoDatabase dbs = mongoClient.getDatabase("college");
//        System.out.println("Connect to database successfully");
//        System.out.println("Database Name :"+dbs.getName());
//        
//        // To get all database names
//		List<String> dbNames=mongoClient.getDatabaseNames();
//        System.out.println(dbNames);
//        
        
        DB database = mongoClient.getDB("college");
        DBCollection collection = database.getCollection("student");		*/
        
//        DBObject person = new BasicDBObject("name", "Anmol")
//                .append("branch", "EC");
//        
//        collection.insert(person);   //inserting
        
//        DBObject query = new BasicDBObject("branch", "IT");
//        DBCursor cursor = collection.find(query);
//        
//        String ab = (String) cursor.one().get("name");
//        System.out.println(ab);
        
//        while(cursor.next() != null)   
//        	{
//        	System.out.println( (String) cursor.one().get("name"));
//        	
//        	}
//        
        //(String)cursor.one().get("name");     if we want to get a specific detail
        
        
//		BasicDBObject document = new BasicDBObject();               //dump
//		BasicDBObject documentDetail = new BasicDBObject();
//		documentDetail.put("sent", textField.getText());					
//		document.put(person, documentDetail);
//		collection1.insert(document);		
//		
//		
//		BasicDBObject document1 = new BasicDBObject();
//		BasicDBObject documentDetail1 = new BasicDBObject();
//		documentDetail1.put("rec", textField.getText());					
//		document1.put(user, documentDetail1);
//		collection2.insert(document1);
 
       
	}

}
