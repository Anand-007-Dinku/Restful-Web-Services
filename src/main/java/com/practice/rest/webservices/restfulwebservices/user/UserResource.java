package com.practice.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @author Anand SN
 */
@RestController
public class UserResource{

    @Autowired
    private UserDaoService service;

    @GetMapping(value = "/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }


    //Important: HATEOAS Implementation
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if (user == null){
            throw new UserNotFoundException("User Not Found for id "+id);
        }

        user.add(linkTo(methodOn(this.getClass())
                .retrieveAllUsers())
                .withRel("all-users"));

        return user;
    }

    //@RequestMapping(method = RequestMethod.POST, path = "users/{user}")
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        User savedUser = service.save(user);

        //CREATED
        //user/{id}
        //Important : if the Clients want to know the location check header section

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

       return ResponseEntity.created(location).build();
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/users/{id}")
    public void deleteById(@PathVariable int id){
        User user = service.deleteById(id);
        if (user == null){
            throw new UserNotFoundException("User Not Found for id "+id);
        }
    }
}