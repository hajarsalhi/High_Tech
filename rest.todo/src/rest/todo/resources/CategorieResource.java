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

import rest.todo.dao.CategorieDao;
import rest.todo.dao.TodoDao;
import rest.todo.model.Categorie;
import rest.todo.model.Todo;

public class CategorieResource {
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    String id;
    
    public CategorieResource(UriInfo uriInfo, Request request, String id) {
    	this.uriInfo = uriInfo;
    	this.request = request;
    	this.id = id;
    }
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie getCategorie() {
    	Categorie categorie = CategorieDao.instance.getModel().get(id);
    	if(categorie == null) {
    		throw new RuntimeException("Get: Categorie with " + id +  " not found");
    	}
    	return categorie;
    }
    
 // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Categorie getCategorieHTML() {
    	Categorie categorie = CategorieDao.instance.getModel().get(id);
        if(categorie == null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return categorie;
    }

    private Response putAndGetResponse(Categorie categorie) {
        Response res;
        if(CategorieDao.instance.getModel().containsKey(categorie.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        CategorieDao.instance.getModel().put(categorie.getId(), categorie);
        return res;
    }
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public Response putCategorie(JAXBElement<Categorie> categorie) {
        Categorie c = categorie.getValue();
        return putAndGetResponse(c);
    }
    @DELETE
    public void deleteTodo() {
        Categorie c = CategorieDao.instance.getModel().remove(id);
        if(c==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }
}
