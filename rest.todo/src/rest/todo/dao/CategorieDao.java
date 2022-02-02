package rest.todo.dao;

import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Categorie;

public enum CategorieDao {
instance;
	
	private Map<String, Categorie> contentProvider = new HashMap<>();
	
	private CategorieDao() {
		 Categorie categorie = new Categorie("1", "Pattes");
		 contentProvider.put("1", categorie);
	     
	}
	public Map<String, Categorie> getModel(){
	        return contentProvider;
	    }
}
