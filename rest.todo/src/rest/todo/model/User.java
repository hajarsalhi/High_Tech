package rest.todo.model;

public class User {
	
	public int id ;
	public boolean isAdmin ;
	public String nom;
	
	
	public User(int id,String nom) {
		this.id = id ;
		this.nom = nom;
		this.isAdmin = false ;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

}
