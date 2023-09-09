package com.example.annuaire.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.annuaire.entities.user2;
import com.example.annuaire.repository.UserRepository;

@Service
public class UserService  implements IUserService {

	@Autowired
	UserRepository userRep;

	@Override
	public user2 addUser(user2 user) {
		// TODO Auto-generated method stub
		return userRep.save(user);
	}

	@Override
	public List<user2> addlistuser(List<user2> listuser) {
		// TODO Auto-generated method stub
		return userRep.saveAll(listuser);
	}

	@Override
	public String addUserWTemail(user2 user) {
		// TODO Auto-generated method stub
		String ch="";
		if (userRep.existsByemail(user.getEmail()))
		{
			ch="email already existe";
		}
		else
		{
			userRep.save(user);
			ch="user added succsesfuly";
		}
		return ch;
	}

	@Override
	public user2 updateUser(user2 user, Long idUser) {
		// TODO Auto-generated method stub
		user2 usr= userRep.findById(idUser).get();
		
		usr.setFirstname(user.getFirstname());
		usr.setLastname(user.getLastname());
		return userRep.save(usr) ;
	}

	@Override
	public String deleteUser(Long idUser) {
		// TODO Auto-generated method stub
		String ch="";
		if(userRep.existsById(idUser))
		{
			userRep.deleteById(idUser);
			ch="user deleted succesesfuly";
		}
		else
		{
			ch="user doen't exist";
		}
		return ch;
	}

	@Override
	public user2 findUserByFirstname(String firstname) {
		// TODO Auto-generated method stub
		return userRep.findByFirstname(firstname);
		}

	@Override
	public List<user2> getUsersByFirtname(String ch) {
		// TODO Auto-generated method stub
		return userRep.getAllUserByFname(ch);
	}
	 
	@Override
	public List<user2> getAllUsers() {
		// TODO Auto-generated method stub
		return userRep.findAll();
	}
	    	
	
    public user2 getById(Long id){
        return this.userRep.getById(id);
    }
	

	
	

	
		


	
	
	
	
}
