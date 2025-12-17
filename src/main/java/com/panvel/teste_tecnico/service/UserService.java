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

        // Caso não encontre o usuário, subir uma exception - not found
        if(foundUser.isEmpty())
            throw new RuntimeException("User " + id + " not found!");

        // Retorno do usuário encontrado
        return foundUser.get();
    }

    public User addUser(User user){
        // Verifica se o email já foi cadastrado
        this.getUserByEmail(user.getEmail());

        // Salva o registro
        return this.userRepository.save(user);
    }

    public User updateUser (UUID id, User newUserData){
        // Busca usuário a ser atualizado
        User foundUser = this.getUserById(id);

        //Atualiza os dados do registro encontrado
        foundUser = this.updateUserData(foundUser, newUserData);

        // Atualiza o usuário encontrado com os novos dados
        return this.userRepository.save(foundUser);
    }

    public String deleteUser(UUID id){
        // Verifica a existencia do id. Caso não exista, a exception é disparada dentro de getUserById (not found)
        this.getUserById(id);
        this.userRepository.deleteById(id);
        return "User " + id + " deleted successfully!";
    }


    // Método auxiliar para sobrescrever os campos de usuário
    private User updateUserData(User foundUser, User newUserData){
        // Sobrescreve o nome do usuário
        foundUser.setName(newUserData.getName());

        // Sobrescreve o email do usuário
        foundUser.setEmail(newUserData.getEmail());

        return foundUser;
    }

    // Método para validar existência de email
    private void getUserByEmail(String email){
        // Busca o usuário pelo email
        Optional<User> foundUserEmail = this.userRepository.findByEmail(email);

        // Caso o email já esteja cadastrado, sobe uma exception
        if(foundUserEmail.isPresent())
            throw new RuntimeException("Email " + email + " already registered!");
    }
}
