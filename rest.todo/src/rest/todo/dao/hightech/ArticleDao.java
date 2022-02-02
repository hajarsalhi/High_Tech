package rest.todo.dao.hightech;

import java.util.HashMap;
import java.util.Map;

import rest.todo.model.hightech.Article;

public enum ArticleDao {
    instance;

	private Map<String,Article> contentProviderArticle = new HashMap<>();
	


	private ArticleDao() {
		Article article = new Article("1", "clavier","Dell",12.99,"télécharger.jfif");
		contentProviderArticle.put("1", article);
   
	}
    public Map<String, Article> getModel(){
    	return contentProviderArticle;
    }

}
