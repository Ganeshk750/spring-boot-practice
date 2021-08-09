package com.ganesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ganesh.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	@Query( value = "select u from users u where u.username = :username and u.password = :password", nativeQuery = true)
//	public User findByUsernameAndPassword(String username, String password);
	
	@Query(value = "select u from User u where u.username = ?1 and u.password = ?2")
    public User findByUsernameAndPassword(String username, String password);
		
}
