package com.example.annuaire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.annuaire.entities.Role;
import com.example.annuaire.services.RoleServiceImpl;

@RestController
public class RoleController {
	
	
   @Autowired
   RoleServiceImpl roleServ;
   
   @PostMapping(value = "/addRole")
	public Role addRole(@RequestBody Role role)
	{
		 return roleServ.adddRole(role);
	}
   
   @PostMapping(value = "/addRolee/{iduser}")
  	public Role addRolee(@RequestBody Role role,@PathVariable("iduser") Long iduser)
  	{
  		 return roleServ.addRolee(role, iduser);
  	}
}

