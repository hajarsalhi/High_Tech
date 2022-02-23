package rest.todo.resources;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import rest.todo.dao.ArticleDao;
import rest.todo.dao.CategorieDao;
import rest.todo.model.Article;
import rest.todo.model.Categorie;

/// Will map the resource to the URL categories
@Path("/articles")

public class ArticlesResource {

    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Article> getArticle() {
        List<Article> articles = new ArrayList<Article>();
        articles.addAll(ArticleDao.instance.getModel().values());
        return articles;
    }
    
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = ArticleDao.instance.getModel().size();
        return String.valueOf(count);
    }
    @Path("article}")
    public ArticleResource getArticle(@PathParam("article") int id) {
        return new ArticleResource(uriInfo, request, id);
    }
}
