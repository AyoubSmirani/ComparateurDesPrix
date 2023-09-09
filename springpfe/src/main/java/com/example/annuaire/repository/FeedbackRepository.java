package com.example.annuaire.repository;

import com.example.annuaire.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

	List<Feedback> findByIdUser(long idUser);
	List<Feedback> findByIdProduit(long idProduit);
   // List<Feedback> findByCategorie(String nom);

    // List<Feedback> findByNom__produit(String nom);
}
