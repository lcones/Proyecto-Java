package com.proyecto.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyecto.spring.Entity.UserRole;
import com.proyecto.spring.Repository.UserRepository;
import com.proyecto.spring.Repository.UsuarioRepository;

import org.springframework.security.core.userdetails.User;


@Service("userService")
public class UserService  implements UserDetailsService{
	
	
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		 com.proyecto.spring.Entity.User user  =  userRepository.findByUsername(username);
		 
		 List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		
		
		return buildUser(user, authorities);
	}
	
	
	private User buildUser(com.proyecto.spring.Entity.User user, List<GrantedAuthority> Authorities) {
		
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true,true, Authorities);
	}
    
	
	private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRoles){
		
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		
		for(UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		return  new ArrayList<GrantedAuthority>(auths);
	}
}
