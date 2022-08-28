package argentina.programa.portfolio.controller;

import argentina.programa.portfolio.model.request.ProfileRequest;
import argentina.programa.portfolio.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @GetMapping(path = "/{id}")
    ResponseEntity<?>getProfile(@Valid @PathVariable("id") Long id){
        return new ResponseEntity<>(profileService.getProfileById(id), HttpStatus.OK);
    }

    @PostMapping()
    ResponseEntity<?>postProfile(@Valid @RequestBody ProfileRequest profileRequest) {
        return new ResponseEntity<>(profileService.createProfile(profileRequest), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    ResponseEntity<?>putProfile(@Valid @RequestBody ProfileRequest profileRequest, @PathVariable("id") Long id) {
        return new ResponseEntity<>(profileService.editProfile(profileRequest, id), HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/{element}")
    ResponseEntity<?>patchProfile(@Valid @RequestBody ProfileRequest profileRequest, @PathVariable("id") Long id, @PathVariable("element") String element) {
        return new ResponseEntity<>(profileService.partialEditProfile(profileRequest, id, element), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    ResponseEntity<?>deleteProfile(@Valid @PathVariable("id") Long id) {
        return new ResponseEntity<>(profileService.removeProfile(id), HttpStatus.OK);
    }
}
