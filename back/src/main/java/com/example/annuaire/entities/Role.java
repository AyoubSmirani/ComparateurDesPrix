package com.example.annuaire.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrole;
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
	
	@ManyToOne
	private User userr; 
	
	
	
	
	public User getUserr() {
		return userr;
	}
	public void setUserr(User userr) {
		this.userr = userr;
	}
	public Long getIdrole() {
		return idrole;
	}
	public void setIdrole(Long idrole) {
		this.idrole = idrole;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	public Role(Long idrole, RoleName roleName) {
		super();
		this.idrole = idrole;
		this.roleName = roleName;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
