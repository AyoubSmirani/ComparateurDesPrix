package com.example.annuaire.repository;

import com.example.annuaire.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist,Long> {


   // List<Wishlist> findByCategorie(String nom);

	List<Wishlist> findByidUser(Long idUser);
}
