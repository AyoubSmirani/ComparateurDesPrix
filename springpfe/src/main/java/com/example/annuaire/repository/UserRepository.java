package com.example.annuaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.annuaire.entities.user2;
@Repository
public interface UserRepository extends JpaRepository<user2, Long> {
	
	Boolean existsByemail(String email);
	user2 findByFirstname(String firstname);
	user2 getById(Long id);
	@Query(value = "select * from user u where u.firstname like :cle%", nativeQuery = true)
	List<user2> getAllUserByFname(@Param("cle") String cle);
}
