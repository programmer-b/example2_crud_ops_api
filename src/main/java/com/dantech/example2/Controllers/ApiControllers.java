package com.dantech.example2.Controllers;

import com.dantech.example2.Models.User;
import com.dantech.example2.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo repo;

    @GetMapping(value = "")
    public String getPage(){
        return "Hello Duncan!";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return  repo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        repo.save(user);
        return "Saved ...";
    }

    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User user) {
        User updateUser = repo.findById(id).get();

        updateUser.setFirstname(user.getFirstname());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setOccupation(user.getOccupation());

        repo.save(updateUser);

        return "updated ...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        User deleteUser = repo.findById(id).get();
        repo.delete(deleteUser);

        return "Delete user with the id" + id;
    }
}
