package Parser;

import Publication.Article;

/**
 * Created by alx on 2/20/16.
 */
public interface Parser {

	void loadArticle(Article article);
	int getWordCardinality();
	int getWordCount();
}
