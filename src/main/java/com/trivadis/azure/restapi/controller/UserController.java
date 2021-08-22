package com.trivadis.azure.restapi.controller;

import com.trivadis.azure.restapi.models.Person;
import com.trivadis.azure.restapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/")
    public List<Person> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person>  getPersonById(@PathVariable long id ){
        return  ResponseEntity.ok(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse( @PathVariable long id) {

        Person person = userService.deleteById(id);

        if (person != null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

/*
    @GetMapping("/")
    public List<Person> getAllUsers(){
        return userService.getAllUsers();
    }


    @PostMapping("/")
    public Person saveUser(@RequestBody Person user){
        return userService.saveUser(user);
    }

   @GetMapping("/{id}")
    public ResponseEntity<Person>  getPersonById(@PathVariable long id ){
        return  ResponseEntity.ok(userService.getPerson(id));
    }

    @PutMapping("/{id}")
    public Person  updatePerson(@PathVariable long id,@RequestBody Person person){
        return userService.updatePerson(id,person);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteById(@PathVariable long id){
        Person person=userService.getPerson(id);
        userService.deleteById(person);
        Map<String,Boolean> map=new HashMap<>();
        map.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(map);
    }*/



}
