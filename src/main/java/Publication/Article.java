package Publication;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by alx on 1/24/16.
 */
public class Article implements Publication {
	private ArrayList<String> authors;
	private Date publishedDate;
	private String publisher;
	private String body;
	private String title;

	private Article(ArticleBuilder builder) {
		this.authors = builder.authors;
		this.publishedDate = builder.publishedDate;
		this.publisher = builder.publisher;
		this.body = builder.body;
		this.title = builder.title;
	}


	public String getBody() {
		return body;
	}

	public long getWordCount() {
		return 0;
	}

	public long getDistinctWords() {
		return 0;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public String getArticleText() {
		return body;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getTitle() { return title;}


	public static class ArticleBuilder {
		private ArrayList<String> authors;
		private final Date publishedDate;
		private final String body;
		private String publisher;
		private String title;

		public ArticleBuilder(Date publishedDate, String body) {
			this.publishedDate = publishedDate;
			this.body = body;
		}

		public ArticleBuilder publisher(String publisher) {
			this.publisher = publisher;
			return this;
		}

		public ArticleBuilder authors(ArrayList<String> authors) {
			this.authors = authors;
			return this;
		}

		public ArticleBuilder title(String title) {
			this.title = title;
			return this;
		}

		public Article build() {
			return new Article(this);
		}

	}
}
