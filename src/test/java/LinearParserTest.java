import Parser.LinearParser;
import Publication.Article;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by alx on 2/21/16.
 */
public class LinearParserTest {
	Article article;
	Db db;
	LinearParser parser;

	@Before
	public void initArticle() {
		Document doc;
		db = new Db();
		doc = db.getLastArticle();
		article = new Article.ArticleBuilder(doc.getDate("add_date"), doc.getString("text"))
			.publisher(doc.getString("publisher"))
			.title(doc.getString("title"))
			.build();

		parser = new LinearParser(article);
	}

	@Test
	public void testWithArticle() {
		int count = parser.getWordCount();
		assertTrue(count > 0);
		System.out.println("got lines: " + count);
	}

	@Test
	public void testCardinality() {

		int cardinality = parser.getWordCardinality();
		assertTrue(cardinality > 0);
		System.out.println("got distinct words: " + cardinality);
	}
}
