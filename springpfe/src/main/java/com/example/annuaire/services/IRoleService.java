package com.example.annuaire.services;

import com.example.annuaire.entities.Role;

public interface IRoleService {
	
	public Role adddRole(Role role);
    public Role addRolee (Role role, Long idUser );

}
