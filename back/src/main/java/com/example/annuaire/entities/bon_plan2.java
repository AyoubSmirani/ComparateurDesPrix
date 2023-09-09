package com.example.annuaire.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class bon_plan2 {

	@Id 
    private Long id_produit;
    
    private String reference;
    private String nom_produit;
    private float prix_produit;
    private String prix_avant_promo;
    private String remise;
    private String image_produit;
    private String description;
    private String table_description;
    private String categorie;
    private String sous_categorie;
    private String sous_sous_categorie;
    private String nom_site;
    private String lien_produit;
    private String disponibilite;
    private int counteur;
    private boolean download_img ;
    private boolean a_la_une;
    private boolean desactiver;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_ajout;
    
    
    

	
	public Long getId_produit() {
		return this.id_produit;
	}





	public void setId_produit(Long id_produit) {
		this.id_produit = id_produit;
	}





	public String getReference() {
		return reference;
	}





	public void setReference(String reference) {
		this.reference = reference;
	}





	public String getNom_produit() {
		return nom_produit;
	}





	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}





	public float getPrix_produit() {
		return prix_produit;
	}





	public void setPrix_produit(float prix_produit) {
		this.prix_produit = prix_produit;
	}





	public String getPrix_avant_promo() {
		return prix_avant_promo;
	}





	public void setPrix_avant_promo(String prix_avant_promo) {
		this.prix_avant_promo = prix_avant_promo;
	}





	public String getRemise() {
		return remise;
	}





	public void setRemise(String remise) {
		this.remise = remise;
	}





	public String getImage_produit() {
		return image_produit;
	}





	public void setImage_produit(String image_produit) {
		this.image_produit = image_produit;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public String getTable_description() {
		return table_description;
	}





	public void setTable_description(String table_description) {
		this.table_description = table_description;
	}





	public String getCategorie() {
		return categorie;
	}





	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}





	public String getSous_categorie() {
		return sous_categorie;
	}





	public void setSous_categorie(String sous_categorie) {
		this.sous_categorie = sous_categorie;
	}





	public String getSous_sous_categorie() {
		return sous_sous_categorie;
	}





	public void setSous_sous_categorie(String sous_sous_categorie) {
		this.sous_sous_categorie = sous_sous_categorie;
	}





	public String getNom_site() {
		return nom_site;
	}





	public void setNom_site(String nom_site) {
		this.nom_site = nom_site;
	}





	public String getLien_produit() {
		return lien_produit;
	}





	public void setLien_produit(String lien_produit) {
		this.lien_produit = lien_produit;
	}





	public String getDisponibilite() {
		return disponibilite;
	}





	public void setDisponibilite(String disponibilite) {
		this.disponibilite = disponibilite;
	}





	public int getCounteur() {
		return counteur;
	}





	public void setCounteur(int counteur) {
		this.counteur = counteur;
	}





	public boolean isDownload_img() {
		return download_img;
	}





	public void setDownload_img(boolean download_img) {
		this.download_img = download_img;
	}





	public boolean isA_la_une() {
		return a_la_une;
	}





	public void setA_la_une(boolean a_la_une) {
		this.a_la_une = a_la_une;
	}





	public boolean isDesactiver() {
		return desactiver;
	}





	public void setDesactiver(boolean desactiver) {
		this.desactiver = desactiver;
	}





	public Date getDate_ajout() {
		return date_ajout;
	}





	public void setDate_ajout(Date date_ajout) {
		this.date_ajout = date_ajout;
	}





	public bon_plan2(Long id_produit, String reference, String nom_produit, float prix_produit,
			String prix_avant_promo, String remise, String image_produit, String description, String table_description,
			String categorie, String sous_categorie, String sous_sous_categorie, String nom_site, String lien_produit,
			String disponibilite, int counteur, boolean download_img, boolean a_la_une, boolean desactiver,
			Date date_ajout) {
		super();
		this.id_produit = id_produit;
		this.reference = reference;
		this.nom_produit = nom_produit;
		this.prix_produit = prix_produit;
		this.prix_avant_promo = prix_avant_promo;
		this.remise = remise;
		this.image_produit = image_produit;
		this.description = description;
		this.table_description = table_description;
		this.categorie = categorie;
		this.sous_categorie = sous_categorie;
		this.sous_sous_categorie = sous_sous_categorie;
		this.nom_site = nom_site;
		this.lien_produit = lien_produit;
		this.disponibilite = disponibilite;
		this.counteur = counteur;
		this.download_img = download_img;
		this.a_la_une = a_la_une;
		this.desactiver = desactiver;
		this.date_ajout = date_ajout;
	}





	public bon_plan2() {
		super();
		// TODO Auto-generated constructor stub
	}




}
