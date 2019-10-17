package com.proyecto.spring.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.Entity.User;

@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User, Serializable>{
	
	public abstract User findByUsername(String usarname);

}
