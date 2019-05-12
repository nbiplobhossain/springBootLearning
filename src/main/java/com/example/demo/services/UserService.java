package com.example.demo.services;

import com.example.demo.dtos.AddUserDTO;
import com.example.demo.repositories.UserRepository;
import com.example.demo.resources.UserResource;
import com.example.demo.schemas.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional//all complete or rollback
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))//extends another class
public class UserService {
    private final UserRepository userRepository;

    public void add(AddUserDTO addUserDTO){
        User user = new User();

        user.setName(addUserDTO.getName());
        user.setEmail(addUserDTO.getEmail());

        userRepository.save(user);
    }

    public List<UserResource> getAll(){
        List<User> userList = userRepository.findAll();
        List<UserResource> userResourceList = new ArrayList<>();

        for (User user : userList) {
            UserResource userResource = new UserResource();
            userResource.setEmail(user.getEmail());

            userResourceList.add(userResource);
        }
        return userResourceList;
    }
    public void delete(Integer id){
       userRepository.deleteById(id);


    }
    public void update(int id,AddUserDTO addUserDTO){

        //User oldUser = userRepository.findById(id);
        User oldUser = userRepository.customFind(id);//query of userRepository.java

        if (oldUser == null)
            return;


        oldUser.setName(addUserDTO.getName());
        oldUser.setEmail(addUserDTO.getEmail());

        userRepository.save(oldUser);
    }
 public UserResource singleDataShow(int id){
     User user = userRepository.findById(id);
     if(user==null){
         return null;
     }


     UserResource userResource = new UserResource();
     userResource.setEmail(user.getEmail());
     return userResource;
    }

}
