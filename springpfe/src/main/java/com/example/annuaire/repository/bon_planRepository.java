package com.example.annuaire.repository;

import com.example.annuaire.entities.bon_plan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface bon_planRepository extends JpaRepository<bon_plan,Long > {


    List<bon_plan> findByCategorie(String nom);

    List<bon_plan> findBynomProduit(String nomProduit);
    
    List<bon_plan> findByReference(String reference);
}
