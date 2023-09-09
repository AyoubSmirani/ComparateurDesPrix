package com.example.annuaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Universite implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String description;
	private Number téléphone;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Number getTéléphone() {
		return téléphone;
	}
	public void setTéléphone(Number téléphone) {
		this.téléphone = téléphone;
	}
	public Universite(Long id, String name, String email, String description, Number téléphone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.description = description;
		this.téléphone = téléphone;
	}
	public Universite() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Universite [id=" + id + ", name=" + name + ", email=" + email + ", description=" + description
				+ ", téléphone=" + téléphone + "]";
	}
	
	
	
	
}
  