package com.panvel.teste_tecnico.controller;

import com.panvel.teste_tecnico.entities.User;
import com.panvel.teste_tecnico.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuario")
@Tag (name = "Rotas de usuário")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "GET - Buscar usuários", description = "Retorna a lista de usuários cadastrados")
    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(this.userService.getUsers());
    }

    @Operation(summary = "GET - Buscar usuário por Id", description = "Retorna dados do usuário com base no id informado")
    @GetMapping("{id}")
    public User getUserById(@PathVariable UUID id){
        try{
            return this.userService.getUserById(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Operation(summary = "POST - Adicionar usuário", description = "Adiciona usuário á lista de cadastros")
    @PostMapping
    public User addUser(@RequestBody User user){
        try{
            return this.userService.addUser(user);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Operation(summary = "PUT - Atualizar usuário", description = "Atualiza usuário cadastrado")
    @PutMapping("{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user){
        try{
            return this.userService.updateUser(id, user);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Operation(summary = "DELETE - Deletar usuário", description = "Deleta usuário cadastrado")
    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable UUID id){
        try{
            return this.userService.deleteUser(id);
        } catch (RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
