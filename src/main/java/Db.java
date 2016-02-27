import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.BSON;
import org.bson.Document;
import org.w3c.dom.views.DocumentView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by alx on 2/14/16.
 */
public class Db {
	private MongoClient client;
	private MongoDatabase db;
	private Logger logger;

	// constructor
	public Db() {
		this.client = new MongoClient();
		this.db = client.getDatabase("publishings");
		logger = Logger.getLogger("com.mongodb.diagnostics.logging.JULLogger");
		logger.setLevel(Level.WARNING);
	}

	//get last recent article inserted into DB
	public Document getLastArticle() {
		BasicDBObject sortBy = new BasicDBObject("add_date", 1);
		FindIterable<Document> doc = db.getCollection("articles").find().sort(sortBy).limit(1);
		return doc.first();
	}

	//get all articles stored
	public List<Document> getAllArticles() {
		MongoCursor<Document> cursor = db.getCollection("articles").find().iterator();
		List<Document> articles = new ArrayList<Document>();

		while(cursor.hasNext()) {
			articles.add(cursor.next());
		}

		return articles;
	}


	//close connection
	public void close() {
		client.close();
	}


	//get database name. Mostly for testing
	public String getDatabaseName() {
		return db.getName();
	}
}
