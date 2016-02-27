import static org.mockito.Mockito.*;

import Parser.LinearParser;
import Publication.Article;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by alx on 2/21/16.
 */
public class LinearParserMockTest {
	Article mockedArticle;
	Db db;
	LinearParser parser;

	@Before
	public void setup() {
		mockedArticle = mock(Article.class);
		when(mockedArticle.getBody()).thenReturn("yoo yo o, yo\n\n\nagain second yo yoo\n\n");
		parser = new LinearParser(mockedArticle);
	}

	@Test
	public void testWithArticle() {
		int count = parser.getWordCount();
		assertTrue(count == 8);
	}

	@Test
	public void testCardinality() {
		int cardinality = parser.getWordCardinality();
		assertTrue(cardinality == 5);
	}
}
