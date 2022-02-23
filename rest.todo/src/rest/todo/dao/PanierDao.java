package rest.todo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Article;
import rest.todo.model.Panier;

public enum PanierDao {
instance;
	private Map<Integer, Panier> contentProvider = new HashMap<>();
	
	private PanierDao() {
		getModels();
	}
	public Map<Integer, Panier> getModel(){
        return contentProvider;
    }
	// afficher la liste des articles
	public void getModels() {
		try {
			Article m = null;
			Panier model = null;
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "SELECT * FROM panier, article, detailPA d where d.idP ="+model.getId()
			+"and d.idA="+m.getId();
			ResultSet rs = stmt.executeQuery(QUERY);
			// Extract data from result set
			while (rs.next()) {
			// Retrieve by column name
			System.out.println("ID: " + rs.getInt("ID"));
			Panier panier = new Panier(rs.getInt("id"),(ArrayList<Article>) rs.getArray("listeArticle"));
			contentProvider.put(rs.getInt("id"), panier);
		    }
		}	
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}

}
