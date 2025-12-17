package com.panvel.teste_tecnico.service;

import com.panvel.teste_tecnico.entities.User;
import com.panvel.teste_tecnico.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return this.userRepository.findAll();
    }

    public User getUserById(UUID id){
        Optional<User> foundUser = this.userRepository.findById(id);

        if(foundUser.isEmpty())
            throw new RuntimeException("User " + id + " not found!");

        return foundUser.get();
    }

    public User addUser(User user){
        return this.userRepository.save(user);
    }

    public User updateUser (UUID id, User newUserData){
        User foundUser = this.getUserById(id);
        foundUser = this.updateUserData(foundUser, newUserData);
        return this.userRepository.save(foundUser);
    }

    private User updateUserData(User foundUser, User newUserData){
        foundUser.setName(newUserData.getName());
        foundUser.setEmail(newUserData.getEmail());

        return foundUser;
    }

    public String deleteUser(UUID id){
        User foundUser = this.getUserById(id);
        this.userRepository.deleteById(id);
        return "User " + id + " deleted successfully!";
    }
}
