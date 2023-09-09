package com.example.annuaire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annuaire.entities.user2;
import com.example.annuaire.entities.bon_plan;
import com.example.annuaire.services.UserService;
import com.example.annuaire.repository.UserRepository;
@RequestMapping("user/")
@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class UserController {
	
	@Autowired
	UserService userServ;
	@Autowired
	UserRepository userRep;
	@PostMapping(value = "/addUser")
	public user2 addUser(@RequestBody user2 usr)
	{
		return userServ.addUser(usr);
	}
	
	@PostMapping(value = "/addListUser")
	public List<user2> addListUser(@RequestBody List<user2> listUser)
	{
		return userServ.addlistuser(listUser);
	}
	
	@PostMapping(value = "/addUserWTemail")
	public String addUserWTemail(@RequestBody user2 usr)
	{
		return userServ.addUserWTemail(usr);
	}
	
	@PutMapping(value = "/updateUser/{idUser}")
	public user2 updateUser(@RequestBody user2 usr, @PathVariable Long idUser)
	{
		return userServ.updateUser(usr, idUser);
	}
	
	@DeleteMapping(value = "/deleteUser/{idUser}")
	public String deleteUser(@PathVariable Long idUser)
	{
		return userServ.deleteUser(idUser);
	}
	
	@GetMapping(value = "/findUserByFirstname/{firstname}")
	public user2 deleteUser(@PathVariable String firstname)
	{
		return userServ.findUserByFirstname(firstname);
	}
	
	
	@GetMapping(value = "/getAllUsersByFirstname/{ch}")
	public List<user2> getAllUsersByFirstname(@PathVariable ("ch") String ch)
	{
		return userServ.getUsersByFirtname(ch);
	}
	
	@GetMapping(value = "/getAllUsers")
	public List<user2> getAllUsers()
	{
		return userServ.getAllUsers();
	}
	@GetMapping(value = "get/{id}")
    private user2 getById(@PathVariable("id") Long id){
        return userRep.getById(id);
    }
	
}

