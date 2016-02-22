
import com.mongodb.client.FindIterable;
import com.sun.javadoc.Doc;
import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by alx on 2/15/16.
 */
public class DbTest {
	Db db;


	@Before
	public void setup() {
		db = new Db();
	}

	@After
	public void close() {
		db.close();
	}

	@Test
	public void testConstruction() {
		assertEquals("Testing DB name", "publishings", db.getDatabaseName());
	}

	@Test
	public void getAllArticlesTest() {
		List<Document> list = db.getAllArticles();
		assertTrue("Got only article in db", list.size() == 1);
	}

	@Test
	public void getLastArticle() {
		Document doc = db.getLastArticle();
		assertNotNull(doc);
		System.out.println("Article date: " + doc.get("add_date"));
	}

	@Test
	public void testDateStorage() {
		Document doc = db.getLastArticle();
		Date addDate = doc.getDate("add_date");
		assertNotNull(addDate);
		System.out.println("Got date: " + addDate.toString());
	}

}
