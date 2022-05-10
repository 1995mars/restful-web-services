package com.mars.rest.webservices.restfulwebservices.controller;

import com.mars.rest.webservices.restfulwebservices.model.User;
import com.mars.rest.webservices.restfulwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(value = "/users")
    public List<User> userList(){
        return userDaoService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public  EntityModel<User>  findOne(@PathVariable int id) throws UserNotFoundException {
        User user = userDaoService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
        EntityModel<User> model = EntityModel.of(user);
        WebMvcLinkBuilder linkToUser =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).userList());
        model.add(linkToUser.withRel("all-user"));
        return model;
    }

    @PostMapping(value = "/users")
    public void craeteUser(@Valid @RequestBody User user){
        User newUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/{id}").buildAndExpand(newUser.getId()).toUri();

        ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        User user = userDaoService.deleteById(id);

        if(user == null){
            throw new UserNotFoundException("id - " + id);
        }
    }
}
