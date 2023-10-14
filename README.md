# <h1 align="center">To Do List API com Spring Boot</h1>

### <h3 align="center">API que permite a criação de usuários e lista de tarefas. Projeto desenvolvido para o Desafio de Projeto do Bootcamp Santander na trilha Java + Angular Fullstack</h3>

</br>

<div align="center">

![image](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![image](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![image](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![image](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![image](https://img.shields.io/badge/Railway-131415?style=for-the-badge&logo=railway&logoColor=white)

</div>

</br>

## Features
- [x] Cadastro, atualização de usuários
- [x] Ao remover um usuário também se remove a sua lista de tarefas
- [x] Cadastro, atualização e remoção de tarefas
- [x] Tarefas podem ser marcadas como concluídas ou não

</br>

## Deploy na nuvem
O projeto está disponível para ser testado na nuvem através do Railway que também está provisionando um banco de dados PostgresSQL para salvar os dados.

[O projeto pode ser acessado aqui.](https://todo-app-prd.up.railway.app/swagger-ui/index.html#/)


</br>

## Diagrama de Classes
```mermaid
classDiagram
  class User {
    -id: int
    -name: string
    -toDoList: ToDo[]
  }
  class ToDo {
    -id: int
    -name: string
    -description: string
    -completed: bool
  }

  User "1" -- "N" ToDo : Contains
```
