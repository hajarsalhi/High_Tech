package rest.todo.model;

public class User {
	
	public int id ;
	public boolean isAdmin ;
	
	public User(int id) {
		this.id = id ;
		this.isAdmin = false ;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
