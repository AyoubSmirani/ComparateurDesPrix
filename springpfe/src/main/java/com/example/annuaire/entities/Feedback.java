package com.example.annuaire.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_feedback;
	
	
	private Long idUser;
	private Long idProduit;
	private String nom_produit;
	private String nomUser;
	private String commentaire;
	private String reponseCommentaire;
	
	
	
	public Long getId_feedback() {
		return id_feedback;
	}
	public void setId_feedback(Long id_feedback) {
		this.id_feedback = id_feedback;
	}
	public Long getId_user() {
		return idUser;
	}
	public void setId_user(Long idUser) {
		this.idUser = idUser;
	}
	public Long getIdProduit() {
		return idProduit;
	}
	public void setId_produit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getNom_produit() {
		return nom_produit;
	}
	public void setNom_produit(String nom_produit) {
		this.nom_produit = nom_produit;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	public String getReponseCommentaire() {
		return reponseCommentaire;
	}
	public void setReponseCommentaire(String reponseCommentaire) {
		this.reponseCommentaire = reponseCommentaire;
	}
	
	public String getNomUser() {
		return nomUser;
	}
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	public Feedback(Long id_feedback, Long idUser, Long idProduit, String nom_produit, String nomUser,
			String commentaire, String reponseCommentaire) {
		super();
		this.id_feedback = id_feedback;
		this.idUser = idUser;
		this.idProduit = idProduit;
		this.nom_produit = nom_produit;
		this.nomUser = nomUser;
		this.commentaire = commentaire;
		this.reponseCommentaire = reponseCommentaire;
	}
	@Override
	public String toString() {
		return "Feedback [id_feedback=" + id_feedback + ", id_user=" + idUser + ", id_produit=" + idProduit
				+ ", nom_produit=" + nom_produit + ", commentaire=" + commentaire + ", reponseCommentaire="
				+ reponseCommentaire + "]";
	}
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}




}
