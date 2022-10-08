package argentina.programa.portfolio.controller;

import argentina.programa.portfolio.model.request.AuthenticationRequest;
import argentina.programa.portfolio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT})
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
