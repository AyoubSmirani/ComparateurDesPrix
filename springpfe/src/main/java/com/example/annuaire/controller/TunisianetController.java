package com.example.annuaire.controller;

import com.example.annuaire.entities.bon_plan;

import com.example.annuaire.repository.bon_planRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("bon_plan/")
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class TunisianetController {
    @Autowired
    private bon_planRepository  repository;
  
    @GetMapping("/all")
    public List<bon_plan> getAll() {
        List<bon_plan> all = this.repository.findAll();
        return all;
    }

    @GetMapping("get/{id}")
    private bon_plan getById(@PathVariable("id") Long id){
        return this.repository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
    }

    @PostMapping("add")
    private bon_plan add(@RequestBody bon_plan bon_plan) {
        return this.repository.save(bon_plan);
    }
    @CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.PUT})
    @PutMapping("update/{id}")
    private ResponseEntity<bon_plan> update(@RequestBody bon_plan bon_plan, @PathVariable("id") Long id){
        if(this.getById(id)!=null){
            return new ResponseEntity<>(this.repository.save(bon_plan), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
    }
    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable("id") Long id){
        this.repository.deleteById(id);
    }
    @GetMapping("findNom/{nom}")
    private List<bon_plan> getByNom(@PathVariable("nom") String nom){
        return this.repository.findBynomProduit(nom);
    }
    @GetMapping("findReference/{reference}")
    private List<bon_plan> getByreference(@PathVariable("reference") String reference){
        return this.repository.findByReference(reference);
    }
    
    @GetMapping("findcat/{categorie}")
    private List<bon_plan> getBycat(@PathVariable("categorie") String nom){
        return this.repository.findByCategorie(nom);
    }
}
