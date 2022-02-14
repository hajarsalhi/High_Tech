package rest.todo.dao;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import rest.todo.model.Categorie;

public enum CategorieDao {
instance;
	
	private Map<String, Categorie> contentProvider = new HashMap<>();
	
	private CategorieDao() {
		getModels();
	}
	
	public Map<String, Categorie> getModel(){
	        return contentProvider;
	}
	//afficher les categories
	
	public void getModels() {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			if(conn == null) {
				System.out.println("connection failled");
			}
			else {
				System.out.println("connection successful");
			} 
			String QUERY = "SELECT * FROM categorie";
			ResultSet rs = stmt.executeQuery(QUERY);
			// Extract data from result set
			while (rs.next()) {
			// Retrieve by column name
			System.out.println("ID: " + rs.getString("ID"));
			Categorie cat = new Categorie(rs.getString("id"),rs.getString("libelle"));
			contentProvider.put(rs.getString("id"), cat);
		    }
	    }catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	//inserer une categorie
	
	public int put(Categorie model) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "INSERT INTO categorie('id', 'libelle')"+
			"VALUES ("+model.getId()+","+model.getLibelle()+")";
			stmt.executeUpdate(QUERY);
			return (1);
		}
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
		} finally {}
	}
	
	//modifier la categirie
	
	public int post(Categorie model) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY ="UPDATE categorie set" + "id=" + model.getId()+
					"," + "name=" + model.getLibelle() + "WHERE id =" +model.getId();
			stmt.executeUpdate(QUERY);
			return 1;
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
		} finally {}
	}
	
	//supprimer une categorie
	
	public int delete(String id) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "DELETE FROM categorie WHERE id=" + id+" ";
			stmt.executeUpdate(QUERY);
			return 1;
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
			} finally {
			}
	}
	
	
}
