import Publication.Article;
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
 * Created by alx on 2/17/16.
 */

public class ArticleTest {
	Date paramDate;
	String paramBody;

	Article article;

	@Before
	public void setupParams() {
		paramDate = new Date();
		paramBody = "TEST TEST ETST";
	}

	@Test
	public void testConstruction() {
		article = new Article.ArticleBuilder(paramDate, paramBody)
			.publisher("The Guardian")
			.build();
		assertNotNull(article);
		assertEquals("checking date", article.getPublishedDate(), paramDate);
	}



}
