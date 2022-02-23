package rest.todo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;

import rest.todo.dao.ArticleDao;
import rest.todo.dao.CategorieDao;
import rest.todo.model.Article;
import rest.todo.model.Categorie;

public class ArticleResource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    
    public ArticleResource(UriInfo uriInfo, Request request,int id) {
    	this.uriInfo = uriInfo;
    	this.request = request;
    	this.id = id;
    }
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article getArticle() {
    	Article article = ArticleDao.instance.getModel().get(id);
    	if(article == null) {
    		throw new RuntimeException("Get: Categorie with " + id +  " not found");
    	}
    	return article;
    }
    
    // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Article getArticleHTML() {
    	Article article = ArticleDao.instance.getModel().get(id);
        if(article == null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return article;
    }

    private Response putAndGetResponse(Article article) {
        Response res;
        if(ArticleDao.instance.getModel().containsKey(article.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        ArticleDao.instance.getModel().put(article.getId(), article);
        return res;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response put(JAXBElement<Article> article) {
    	Article a = article.getValue();
        return putAndGetResponse(a);
    }
    @DELETE
    public void deleteArticle() {
    	Article a = ArticleDao.instance.getModel().remove(id);
        if(a==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }
    
    

}
