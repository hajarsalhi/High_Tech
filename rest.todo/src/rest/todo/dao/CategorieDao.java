package rest.todo.dao;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Categorie;

public enum CategorieDao {
instance;
	
	private Map<String, Categorie> contentProvider = new HashMap<>();
	
	private CategorieDao() {
		DbManager db = new DbManager();
		Connection conn = db.getConnection();
		if(conn == null) {
			System.out.println("connection failled");
		}
		else {
			System.out.println("connection successful");
		}
		 Categorie categorie = new Categorie("1", "Pattes");
		 contentProvider.put("1", categorie);
	     
	}
	public Map<String, Categorie> getModel(){
	        return contentProvider;
	    }
}
