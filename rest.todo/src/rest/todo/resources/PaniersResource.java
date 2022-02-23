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

import rest.todo.dao.PanierDao;
import rest.todo.model.Panier;

/// Will map the resource to the URL categories
@Path("/paniers")

public class PaniersResource {
	 // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;
    
    // Return the list of categories for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Panier> getPaniers() {
        List<Panier> paniers = new ArrayList<Panier>();
        paniers.addAll(PanierDao.instance.getModel().values());
        return paniers;
    }
    // Use http://localhost:8080/com.vogella.jersey/rest/hightech/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = PanierDao.instance.getModel().size();
        return String.valueOf(count);
    }
    
    // Defines that the next path parameter after todos is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
    // 1 will be treaded as parameter todo and passed to TodoResource
    @Path("{panier}")
    public PanierResource getPanier(@PathParam("panier") int id) {
        return new PanierResource(uriInfo, request, id);
    }
    
}
