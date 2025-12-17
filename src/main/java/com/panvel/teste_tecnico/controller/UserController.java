package com.panvel.teste_tecnico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UserController {

    @GetMapping
    public String getTest(){
        return "Mensagem de teste";
    }

}
