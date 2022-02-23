package rest.todo.model;

import rest.todo.model.Categorie;

public class Article {
	private int id ;
	private String libelle ;
	private String marque ;
	private double prix ;
	private int categorie ;
	private String photo ;
	
	public Article(int id , String libelle,String marque, Double prix,int categorie,String photo) {
		this.id = id ;
		this.libelle=libelle;
		this.marque = marque ;
		this.prix = prix ;
		this.categorie = categorie;
		this.photo = photo ;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
