package argentina.programa.portfolio.model.mapper;

import argentina.programa.portfolio.common.security.service.Impl.UserDetailsServiceImpl;
import argentina.programa.portfolio.common.security.service.JWTUtils;
import argentina.programa.portfolio.model.entity.User;
import argentina.programa.portfolio.model.request.AuthenticationRequest;
import argentina.programa.portfolio.model.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    JWTUtils jwtUtils;
    @Autowired
    PasswordEncoder passwordEncoder;

    public User toUser(AuthenticationRequest userRequest) {
        User user = User
                .builder()
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .build();
        return user;
    }

    public AuthenticationResponse toAuthenticationResponse(AuthenticationRequest userReq) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(userReq.getEmail());
        String token = jwtUtils.generateToken(userDetails);
        AuthenticationResponse userResp = AuthenticationResponse.builder().token(token).build();
        return userResp;
    }
}
