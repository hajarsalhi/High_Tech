package rest.todo.dao;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Article;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum ArticleDao {
instance;
	private Map<Integer, Article> contentProvider = new HashMap<>();
	
	private ArticleDao() {
		getModels();
	}
	public Map<Integer, Article> getModel(){
        return contentProvider;
    }
	// afficher la liste des articles
	public void getModels() {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			
			String QUERY = "SELECT * FROM article";
			ResultSet rs = stmt.executeQuery(QUERY);
			// Extract data from result set
			while (rs.next()) {
			// Retrieve by column name
			System.out.println("ID: " + rs.getInt("ID"));
			Article article = new Article(rs.getInt("id"),rs.getString("libelle"),rs.getString("marque"),
					rs.getDouble("prix"),rs.getInt("cat_id"),rs.getString("photo"));
			contentProvider.put(rs.getInt("id"), article);
		    }
		}	
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	// inserer un article
	public int put(Article model) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "INSERT INTO article('id', 'libelle','marque','prix','cat_id','photo')"+
			"VALUES ("+model.getId()+","+model.getLibelle()+","+model.getMarque()+","+model.getPrix()
			+","+model.getCategorie()+","+model.getPhoto()+")";
			stmt.executeUpdate(QUERY);
			return (1);
		}
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
		} finally {}
	}
	
	//modifier un article
	public int post(Article model) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY ="UPDATE article set" + "id=" + model.getId()+
					"," + "name=" + model.getLibelle() + "," + "marque=" + model.getMarque()+"," + "prix=" + model.getPrix() 
					+ "," + "categorie=" + model.getCategorie() +"," + "photo=" + model.getPhoto() +"WHERE id =" +model.getId();
			stmt.executeUpdate(QUERY);
			return 1;
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
		} finally {}
	}
	
	//supprimer un article
	public String delete(int id) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "DELETE FROM categorie WHERE id=" + id+" ";
			stmt.executeUpdate(QUERY);
			return "element "+ id+" bien supprimé";
		}catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return "erreur";
			} finally {
			}
	}
}
