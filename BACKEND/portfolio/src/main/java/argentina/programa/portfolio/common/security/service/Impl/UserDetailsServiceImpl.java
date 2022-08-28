package argentina.programa.portfolio.common.security.service.Impl;

import argentina.programa.portfolio.common.security.service.JWTUtils;
import argentina.programa.portfolio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    JWTUtils jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var userFound = userRepository.findByEmail(email);

        if(userFound != null) {
            return new User(userFound.getEmail(), userFound.getPassword(), Collections.emptyList());
        } else {
            return null;
        }
    }

}