package com.api.parkingcontrol.config.security;

import com.api.parkingcontrol.model.UserModel;
import com.api.parkingcontrol.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));

        return new User(userModel.getUsername(), userModel.getPassword(),true,true,true,true,userModel.getAuthorities());
    }
}
