package rest.todo.resources.hightech;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.hightech.ArticleDao;
import rest.todo.model.hightech.Article;


/// Will map the resource to the URL articles
@Path("/articles")
public class ArticlesRessource {
	

    // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of articles to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Article> getArticleBrowser() {
        List<Article> articles = new ArrayList<Article>();
       articles.addAll(ArticleDao.instance.getModel().values());
        return articles;
    }

    // Return the list of articles for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Article> getArticles() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(ArticleDao.instance.getModel().values());
        return articles;
    }

    // retuns the number of articles
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/articles/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ArticleDao.instance.getModel().size();
        return String.valueOf(count);
    }


}
