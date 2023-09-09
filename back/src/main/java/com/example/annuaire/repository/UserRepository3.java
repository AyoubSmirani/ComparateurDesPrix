package com.example.annuaire.repository;
import com.example.annuaire.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository3 extends JpaRepository<User, Long>{
	Optional<User> findByEmail(String email);
}
