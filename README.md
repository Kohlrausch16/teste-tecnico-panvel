# Teste técnico Panvel

## Descrição

Solução de teste técnico para vága de estágio em desenvolvimento Backend - Panvel.

## Rotas

Todas as rotas possuem como base a porta 8080 
```
http://localhost:8080
```

Listagem de rotas para realização de requisições HTTP.

GET - Buscar todos os usuários:
```
http://localhost:8080/usuario
```

GET - Buscar usuário por id
```
http://localhost:8080/usuario/<id>
```

POST - Adicionar usuário
```
http://localhost:8080/usuario

-> Corpo da requisição:

{
    "name": "<valor para nome>",
    "email": "<valor para email>"
}
```

PUT - Editar usuário
```
http://localhost:8080/usuario/<id>

-> Corpo da requisição:

{
    "name": "<valor para nome>",
    "email": "<valor para email>"
}
```

DELETE - Deletar usuário
```
http://localhost:8080/usuario/<id>
```

## Banco de dados

Para a solução do teste proposto, foi implementado o banco de dados H2 Database, o qual trabalha com o armazenamento de dados em memória.
Para consultar o banco em questão, acessar a rota /h2-console e utilizar as credenciais conforme a imagem abaixo:

```
JDBC URL: jdbc:h2:mem:testedb
Username: sa
Password: <campo vazio>
```

<img width="459" height="355" alt="image" src="https://github.com/user-attachments/assets/68639a94-9b3d-4ada-98c0-754fa2be26be" />

## Dependências do projeto

- Spring Web;
- Spring Data JPA;
- Lombok;
- H2 Database
