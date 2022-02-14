package rest.todo.dao;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Article;
import rest.todo.model.Categorie;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum ArticleDao {
instance;
	private Map<String, Article> contentProvider = new HashMap<>();
	
	private ArticleDao() {
		getModels();
	}
	public Map<String, Article> getModel(){
        return contentProvider;
    }
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
			System.out.println("ID: " + rs.getString("ID"));
			Article article = new Article(rs.getString("id"),rs.getString("libelle"),rs.getString("marque"),
					rs.getDouble("prix"),rs.getString("categorie"),rs.getString("photo"));
			contentProvider.put(rs.getString("id"), article);
		    }
		}	
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
}
