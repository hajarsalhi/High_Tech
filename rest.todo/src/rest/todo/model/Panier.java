package rest.todo.model;

import java.util.ArrayList;
import java.util.List;

import rest.todo.model.Article;

public class Panier {
	private int id ;
	private ArrayList<Article> listeArticles ;
	private double prixTotal ;
	private int quantite;
	
	public Panier(int id, ArrayList<Article> listeArticles) {
		super();
		this.id = id;
		this.listeArticles = listeArticles;
		this.prixTotal = 0.0;
		this.quantite = 0;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public List<Article> getListeArticles() {
		return listeArticles;
	}

	public void setListeArticles(ArrayList<Article> listeArticles) {
		this.listeArticles = listeArticles;
	} 
	
	public double getPrixTotal () {
		for(Article art : listeArticles)
			prixTotal+= art.getPrix();
		return prixTotal ;
	}


	public int getQuantite() {
		for(Article art : listeArticles)
			quantite+= 1;
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
}
