package com.example.annuaire.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.annuaire.entities.Role;
import com.example.annuaire.entities.User;
import com.example.annuaire.repository.IRoleRepository;
import com.example.annuaire.repository.UserRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	
	
	@Autowired
	IRoleRepository roleRep;
	
	@Override
	public Role adddRole(Role role) {
		// TODO Auto-generated method stub
		return roleRep.save(role) ;
	}
    @Autowired
    UserRepository userRep;
	@Override
	public Role addRolee(Role role, Long idUser) {
		// TODO Auto-generated method stub
		
		User user = userRep.findById(idUser).get();
		role.setUserr(user);
		return roleRep.save(role);
	}

}
