package rest.todo.model.hightech;

public class Article {

	private String id ;
	private String libelle ;
	private String marque ;
	private double prix ;
	
	private String photo ;
	
	public Article(String id , String libelle,String marque, Double prix,String photo) {
		this.id = id ;
		this.libelle=libelle;
		this.marque = marque ;
		this.prix = prix ;
		this.photo = photo ;
	}
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
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


	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	
	private String getLibelle() {
		return libelle;
	}

	private void setLibelle(String libelle) {
		this.libelle = libelle;
	}
}
