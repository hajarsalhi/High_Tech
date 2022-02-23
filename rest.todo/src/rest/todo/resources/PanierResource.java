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


import rest.todo.dao.PanierDao;

import rest.todo.model.Panier;

public class PanierResource {
	
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    
    public PanierResource(UriInfo uriInfo, Request request,int id) {
    	this.uriInfo = uriInfo;
    	this.request = request;
    	this.id = id;
    }
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Panier getPanier () {
    	Panier panier = PanierDao.instance.getModel().get(id);
    	if(panier  == null) {
    		throw new RuntimeException("Get: Categorie with " + id +  " not found");
    	}
    	return panier ;
    }
    
 // for the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public Panier getPanierHTML() {
    	Panier panier = PanierDao.instance.getModel().get(id);
        if(panier == null)
            throw new RuntimeException("Get: Todo with " + id +  " not found");
        return panier ;
    }

}
