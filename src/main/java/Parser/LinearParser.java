package Parser;

import Publication.Article;

import java.util.HashMap;

/**
 * Created by alx on 2/20/16.
 *
 *
 * TODO: clean splits, rm commas and other symbols that arent part of the word
 *  do cardinality
 **/

public class LinearParser implements Parser {
	Article article;

	public LinearParser(Article article) {
		this.article = article;
	}

	public void loadArticle(Article article) {
		this.article = article;
	}


	public int getWordCardinality() {
		String text = article.getBody();
		String[] byLine = text.split("[\\r?\\n]+");
		String[] currentLine;
		HashMap<String, Integer> wordMap = new HashMap<String, Integer>();

		for(String line : byLine) {
			currentLine = line.split("\\s");
			for(String word : currentLine) {
				if(wordMap.containsKey(word)) {
					int currentCount = wordMap.get(word);
					wordMap.put(word, ++ currentCount);
				}
				else {
					wordMap.put(word,1);
				}
			}
		}

		return wordMap.size();
	}

	public int getWordCount() {
		String[] currentLine;
		String text = article.getBody();
		String[] byLine = text.split("[\\r?\\n]+");
		int count = 0;

		for(String line : byLine) {
			currentLine = line.split("\\s");
			for(String word : currentLine) {
				count ++;
			}
		}
		return count;
	}
}
