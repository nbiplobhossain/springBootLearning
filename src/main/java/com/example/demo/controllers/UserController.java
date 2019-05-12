package com.example.demo.controllers;

import com.example.demo.dtos.AddUserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.resources.UserResource;
import com.example.demo.schemas.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody @Validated final AddUserDTO addUserDTO){
        userService.add(addUserDTO);

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<UserResource> getAll(){
        return userService.getAll();
    }
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") final int id){

          userService.delete(id);
    }
    @RequestMapping(value="/update/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable("id") final int id,@RequestBody final AddUserDTO addUserDTO){
        userService.update(id,addUserDTO);
    }
    @RequestMapping(value="/singleData/{id}",method = RequestMethod.GET)
    public UserResource singleDataShow(@PathVariable("id") final int id){
       return userService.singleDataShow(id);
    }

}
