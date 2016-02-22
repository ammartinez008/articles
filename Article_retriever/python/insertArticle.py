from newspaper import Article
from pymongo import MongoClient
import time
import datetime
import sys

def getDB():
    mongoDB = MongoClient()
    return mongoDB.publishings


def printAuthors(article):
    for author in article.authors:
        print author
    return

def insertArticle(article):
    db = getDB()
    doc = {
            "add_date" : datetime.datetime.utcnow(),
            "authors" : article.authors,
            "publisher" : article_publisher,
            "url" : article_url,
            "title" : article.title,
            "text" : article.text
        }
    result = db.articles.insert_one(doc)
    return result.inserted_id


article_url = sys.argv[1]
article_publisher = sys.argv[2]

article = Article(article_url, language='en')
article.download()
article.parse()
#printAuthors(article)
db_id = insertArticle(article)
print db_id
