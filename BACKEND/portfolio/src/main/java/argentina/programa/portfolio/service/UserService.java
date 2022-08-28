package argentina.programa.portfolio.service;

import argentina.programa.portfolio.model.request.AuthenticationRequest;
import argentina.programa.portfolio.model.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public AuthenticationResponse signIn(AuthenticationRequest user);
    public AuthenticationResponse signUp(AuthenticationRequest user);

}
