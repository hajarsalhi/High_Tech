package rest.todo.dao;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import rest.todo.model.Article;
import rest.todo.model.Categorie;
import rest.todo.model.User;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public enum UserDao {
instance;
private Map<Integer, User> contentProvider = new HashMap<>();
	
	private UserDao() {
		getModels();
	}
	public Map<Integer, User> getModel(){
        return contentProvider;
    }
	public void getModels() {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			
			String QUERY = "SELECT * FROM user";
			ResultSet rs = stmt.executeQuery(QUERY);
			// Extract data from result set
			while (rs.next()) {
			// Retrieve by column name
			System.out.println("ID: " + rs.getInt("ID"));
			User user = new User(rs.getInt("id"),rs.getString("nom"));
			contentProvider.put(rs.getInt("id"), user);
		    }
		}	
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	
	//insere un user
	public int put(User model) {
		try {
			DbManager db = new DbManager();
			Connection conn = db.getConnection();
			Statement stmt = conn.createStatement();
			String QUERY = "INSERT INTO user('id', 'nom','isAdmin')"+
			"VALUES ("+model.getId()+","+model.getNom()+","+model.isAdmin+")";
			stmt.executeUpdate(QUERY);
			return (1);
		}
		catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			return (0);
		} finally {}
	}
	
	

}
