package com.example.annuaire.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annuaire.entities.Wishlist;
import com.example.annuaire.repository.WishlistRepository;


@RequestMapping("wishlist/")
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class WishlistController {
	@Autowired
    private WishlistRepository repository;
	@GetMapping("all")
    private List<Wishlist> getAll(){
        return this.repository.findAll();}
        
        @GetMapping("get/{id}")
        private Wishlist getById(@PathVariable("id") Long id){
            return this.repository.findById(id).orElseThrow(()-> new RuntimeException("product not found"));
        }
        
        @PostMapping("add")
        private Wishlist add(@RequestBody 	Wishlist wishlist){
            return this.repository.save(wishlist);
        }
        @PutMapping("update/{id}")
        private ResponseEntity<Wishlist> update(@RequestBody Wishlist wishlist, @PathVariable("id") Long id){
            if(this.getById(id)!=null){
                return new ResponseEntity<>(this.repository.save(wishlist), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
        @DeleteMapping("delete/{id}")
        private void delete(@PathVariable("id") Long id){
            this.repository.deleteById(id);
        }
       
        @GetMapping("findByIdUser/{idUser}")
	    public List<Wishlist> getByUserId(@PathVariable("idUser") Long idUser) {
	        return repository.findByidUser(idUser);
	    }
        
}
