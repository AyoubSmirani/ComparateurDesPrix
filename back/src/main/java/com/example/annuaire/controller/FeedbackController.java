package com.example.annuaire.controller;

import java.util.List;

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

import com.example.annuaire.entities.Feedback;
import com.example.annuaire.entities.Wishlist;
import com.example.annuaire.repository.FeedbackRepository;



@RequestMapping("feedback/")
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class FeedbackController {
	@Autowired
    private FeedbackRepository repository;
	@GetMapping("all")
    private List<Feedback> getAll(){
        return this.repository.findAll();}
        
        @GetMapping("get/{id}")
        private Feedback getById(@PathVariable("id") Long id){
            return this.repository.findById(id).orElseThrow(()-> new RuntimeException("feedback not found"));
        }
        
        @PostMapping("add")
        private Feedback add(@RequestBody 	Feedback feedback){
            return this.repository.save(feedback);
        }
        @PutMapping("update/{id}")
        private ResponseEntity<Feedback> update(@RequestBody Feedback feedback, @PathVariable("id") Long id){
            if(this.getById(id)!=null){
                return new ResponseEntity<>(this.repository.save(feedback), HttpStatus.ACCEPTED);
            }
            return new ResponseEntity<>(HttpStatus.FAILED_DEPENDENCY);
        }
        @DeleteMapping("delete/{id}")
        private void delete(@PathVariable("id") Long id){
            this.repository.deleteById(id);
        }
        @GetMapping("findByIdUser/{idUser}")
	    public List<Feedback> getByUserId(@PathVariable("idUser") Long idUser) {
	        return repository.findByIdUser(idUser);
	    }
        
        @GetMapping("findByIdProduit/{idProduit}")
	    public List<Feedback> getByProduitId(@PathVariable("idProduit") Long idProduit) {
	        return repository.findByIdProduit(idProduit);
	    }
        
}
