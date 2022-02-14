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

import rest.todo.dao.CategorieDao;
import rest.todo.dao.TodoDao;
import rest.todo.model.Categorie;
import rest.todo.model.Todo;

/// Will map the resource to the URL categories
@Path("/categories")

public class CategoriesResource {
	 // Allows to insert contextual objects into the class,
    // e.g. ServletContext, Request, Response, UriInfo
    @Context
    UriInfo uriInfo;
    @Context
    Request request;

    // Return the list of todos to the user in the browser
    @GET
    @Produces(MediaType.TEXT_XML)
    public List<Categorie> getTodosBrowser() {
        List<Categorie> categories = new ArrayList<Categorie>();
        categories.addAll(CategorieDao.instance.getModel().values());
        return categories ;
    }
    
    // Return the list of todos for applications
    @GET
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public List<Categorie> getTodos() {
        List<Categorie> categories = new ArrayList<Categorie>();
        categories.addAll(CategorieDao.instance.getModel().values());
        return categories;
    }
    // retuns the number of todos
    // Use http://localhost:8080/com.vogella.jersey.todo/rest/todos/count
    // to get the total number of records
    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCount() {
        int count = CategorieDao.instance.getModel().size();
        return String.valueOf(count);
    }
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void newCategorie(@FormParam("id") String id,
            @FormParam("libelle") String libelle,
            @Context HttpServletResponse servletResponse) throws IOException {
        Categorie categorie = new Categorie(id, libelle);
        CategorieDao.instance.getModel().put(id, categorie);

        servletResponse.sendRedirect("../create_categorie.html");
    }
    
    // Defines that the next path parameter after todos is
    // treated as a parameter and passed to the TodoResources
    // Allows to type http://localhost:8080/rest.todo/rest/todos/1
    // 1 will be treaded as parameter todo and passed to TodoResource
    @Path("{categorie}")
    public CategorieResource getCategorie(@PathParam("categorie") String id) {
        return new CategorieResource(uriInfo, request, id);
    }

}
