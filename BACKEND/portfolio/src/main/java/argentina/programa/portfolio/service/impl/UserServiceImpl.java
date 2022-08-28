package argentina.programa.portfolio.service.impl;

import argentina.programa.portfolio.common.exception.BadRequestException;
import argentina.programa.portfolio.common.exception.Errors;
import argentina.programa.portfolio.common.exception.ForbiddenException;
import argentina.programa.portfolio.common.security.service.Impl.UserDetailsServiceImpl;
import argentina.programa.portfolio.model.entity.User;
import argentina.programa.portfolio.model.mapper.UserMapper;
import argentina.programa.portfolio.model.request.AuthenticationRequest;
import argentina.programa.portfolio.model.response.AuthenticationResponse;
import argentina.programa.portfolio.repository.UserRepository;
import argentina.programa.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public AuthenticationResponse signIn(AuthenticationRequest userRequest) {
        try {
            var authenticationUser = new UsernamePasswordAuthenticationToken(userRequest.getEmail(), userRequest.getPassword());
            authenticationManager.authenticate(authenticationUser);
            return userMapper.toAuthenticationResponse(userRequest);
        } catch (ForbiddenException e) {
            throw new ForbiddenException(Errors.INVALIDUSER);
        }
    }

    @Override
    public AuthenticationResponse signUp(AuthenticationRequest userRequest) {
        User userFound = userRepository.findByEmail(userRequest.getEmail());
        if(userFound != null) {
            throw new BadRequestException(Errors.USEREXIST);
        }
        User user = userMapper.toUser(userRequest);
        userRepository.save(user);
        return userMapper.toAuthenticationResponse(userRequest);
    }
}
