package argentina.programa.portfolio.controller;

import argentina.programa.portfolio.model.request.AuthenticationRequest;
import argentina.programa.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(path = "/login")
    ResponseEntity<?>loginUser(@RequestBody @Valid AuthenticationRequest user){
        return new ResponseEntity<>(userService.signIn(user), HttpStatus.OK);
    }

    @PostMapping(path = "/signup")
    ResponseEntity<?>signUpUser(@RequestBody @Valid AuthenticationRequest user){
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.CREATED);
    }
}
