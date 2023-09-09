package com.example.annuaire.services;

import java.util.List;

import com.example.annuaire.entities.user2;

public interface IUserService {

	public user2 addUser(user2 user);
	public List<user2> addlistuser(List<user2> listuser);
	public String addUserWTemail(user2 user);
	public user2 updateUser(user2 user, Long idUser);
	public String deleteUser(Long idUser);
    public user2 findUserByFirstname(String firstname);
    public List<user2> getUsersByFirtname(String ch);
    public List<user2> getAllUsers();
    public user2 getById(Long id);
}
