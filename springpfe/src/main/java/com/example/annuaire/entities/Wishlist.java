package com.example.annuaire.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "wishlist", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "id_produit"
        })
})
public class Wishlist implements Serializable {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id_wishlist;

private long idUser;
private long id_produit;
private String nom_produit;
private String image_produit;
private float prix_produit;
public Long getId_wishlist() {
	return id_wishlist;
}
public void setId_wishlist(Long id_wishlist) {
	this.id_wishlist = id_wishlist;
}
public long getId_user() {
	return idUser;
}
public void setId_user(long idUser) {
	this.idUser = idUser;
}
public long getId_produit() {
	return id_produit;
}
public void setId_produit(long id_produit) {
	this.id_produit = id_produit;
}
public String getNom_produit() {
	return nom_produit;
}
public void setNom_produit(String nom_produit) {
	this.nom_produit = nom_produit;
}
public String getImage_produit() {
	return image_produit;
}
public void setImage_produit(String image_produit) {
	this.image_produit = image_produit;
}
public float getPrix_produit() {
	return prix_produit;
}
public void setPrix_produit(float prix_produit) {
	this.prix_produit = prix_produit;
}
public Wishlist(Long id_wishlist, long idUser, long id_produit, String nom_produit, String image_produit,
		float prix_produit) {
	super();
	this.id_wishlist = id_wishlist;
	this.idUser = idUser;
	this.id_produit = id_produit;
	this.nom_produit = nom_produit;
	this.image_produit = image_produit;
	this.prix_produit = prix_produit;
}
public Wishlist() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Wishlist [id_wishlist=" + id_wishlist + ", id_user=" + idUser + ", id_produit=" + id_produit
			+ ", nom_produit=" + nom_produit + ", image_produit=" + image_produit + ", prix_produit=" + prix_produit
			+ "]";
}

}
