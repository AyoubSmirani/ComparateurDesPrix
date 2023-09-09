package com.example.annuaire.services;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.example.annuaire.entities.User;
import com.example.annuaire.repository.UserRepository3;
@Service
public class UserService2 {
	  @Autowired
	    UserRepository3 userRepository;

	    public User getUserByEmail(String email) {
	        return userRepository.findByEmail(email)
	                .orElse(null);
	    }
}
