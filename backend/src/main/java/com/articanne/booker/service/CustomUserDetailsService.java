package com.articanne.booker.service;

import com.articanne.booker.model.User;
import com.articanne.booker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        CustomUserDetails customUserDetails = optionalUser.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        return customUserDetails;
    }

}
