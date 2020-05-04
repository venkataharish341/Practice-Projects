package io.javabrains.springsecurityjwt.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.springsecurityjwt.models.MyUserDetails;
import io.javabrains.springsecurityjwt.models.User;
import io.javabrains.springsecurityjwt.repository.UserRepository;


//This class some how connect to LDAP or DB or any source to get the UserDetails object.
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
    /**
     * Gets the user from DB in this case and convert that to UserDetails class.
     * We also get the roles of the user from DB.
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	Optional<User> user =userRepository.findByUsername(userName); // Gets from DB
    	
    	user.orElseThrow(() -> new UsernameNotFoundException("Not Found : "+ userName));
    	
    	return user.map(MyUserDetails::new).get();
    }
}