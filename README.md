# Articles
### parsing and analyzing articles from different sources

- Uses python's newspaper library to pull articles from a given url, and parses the HTML into readable text.
- Uses MongoClient to store the text and other relevant information into a MongoDB database.
- Analysis of the articles are done in Java, and a Mongo Client is also used to retrieve our articles from the DB



### Structure
Article Retriever: contains the front end that pulls articles from the web

src/main/java: contains all of the java classes 

Parser: different implementations of parsing methods

Publication: instatiates an article or piece of publication pulled from the database




### Contributors
Alex Martinez

