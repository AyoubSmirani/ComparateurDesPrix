package com.example.annuaire.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.annuaire.entities.Universite;


@Repository
public interface IUniversiteRepository extends JpaRepository<Universite, Long> {

}
