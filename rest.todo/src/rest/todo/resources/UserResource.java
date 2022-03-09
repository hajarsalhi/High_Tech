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

import rest.todo.dao.UserDao;
import rest.todo.model.User;

public class UserResource {
	
	@Context
    UriInfo uriInfo;
    @Context
    Request request;
    int id;
    
    public UserResource(UriInfo uriInfo, Request request,int id) {
    	this.uriInfo = uriInfo;
    	this.request = request;
    	this.id = id;
    }
    //Application integration
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public User getUser() {
    	User user = UserDao.instance.getModel().get(id);
    	if(user == null) {
    		throw new RuntimeException("Get: User with " + id +  " not found");
    	}
    	return user;
    }

    private Response putAndGetResponse(User user) {
        Response res;
        if(UserDao.instance.getModel().containsKey(user.getId())) {
            res = Response.noContent().build();
        } else {
            res = Response.created(uriInfo.getAbsolutePath()).build();
        }
        UserDao.instance.getModel().put(user.getId(), user);
        return res;
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response putUser(JAXBElement<User> user) {
        User u = user.getValue();
        return putAndGetResponse(u);
    }
    @DELETE
    public void deleteUser() {
        User u = UserDao.instance.getModel().remove(id);
        if(u==null)
            throw new RuntimeException("Delete: Todo with " + id +  " not found");
    }

}
