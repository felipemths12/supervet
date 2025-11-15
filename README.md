# API Clínica Veterinária - SuperVet

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow)

API REST para o gerenciamento de uma clínica veterinária. Este projeto foi desenvolvido como requisito avaliativo para a disciplina de Programação Orientada a Objetos da faculdade Centro Universitário Jorge Amado - UNIJORGE.

A API permite o gerenciamento completo de tutores, animais, veterinários e o agendamento de consultas, seguindo as melhores práticas de desenvolvimento com Spring Boot.

## 🚀 Funcionalidades

* **Tutores:** CRUD completo de tutores (donos dos animais).
* **Animais:** CRUD completo de animais, com vínculo obrigatório a um tutor.
* **Veterinários:** CRUD completo de veterinários.
* **Consultas:** Agendamento (Create), Listagem (Read) e Cancelamento (Delete) de consultas, vinculando um animal e um veterinário.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA:** Para persistência de dados.
* **Spring Web:** Para criação dos endpoints REST.
* **Spring Validation:** Para validação dos DTOs de entrada.
* **MySQL:** Banco de dados relacional.
* **Maven:** Gerenciador de dependências.

## 🏛️ Arquitetura

O projeto segue uma arquitetura de 3 camadas (3-Tier) clássica:

* **`Controller` (Camada de Apresentação):** Recebe as requisições HTTP, valida os dados de entrada (DTOs) e retorna as respostas.
* **`Service` (Camada de Negócio):** Contém toda a lógica de negócio, validações de regras e faz a ponte entre os controllers e os repositórios.
* **`Repository` (Camada de Dados):** Interface que utiliza o Spring Data JPA para se comunicar com o banco de dados.

### Padrões Adotados

* **DTO (Data Transfer Object):** Os controllers recebem e retornam DTOs para desacoplar a API das entidades do banco de dados e evitar a exposição de dados sensíveis.

## ⚙️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```

2.  **Configure o Banco de Dados (MySQL):**
    Abra o arquivo `src/main/resources/application.properties` e altere as seguintes linhas com as suas credenciais do MySQL:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/supervet
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
    *Obs: O schema `supervet` será criado automaticamente se não existir (devido ao `?createDatabaseIfNotExist=true`).*

3.  **Execute a Aplicação:**
    Rode a classe principal `ClinicaVeterinariaApplication.java` pela sua IDE, ou utilize o Maven no terminal:
    ```bash
    mvn spring-boot:run
    ```

4.  **Teste a API:**
    A aplicação estará disponível em `http://localhost:8080`. Você pode usar o Postman ou Insomnia para testar os endpoints.

## 🗺️ Endpoints da API

### Tutores (`/tutores`)

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/tutores` | Cadastra um novo tutor |
| `GET` | `/tutores` | Lista todos os tutores |
| `GET` | `/tutores/{id}` | Busca um tutor por ID |
| `PUT` | `/tutores/{id}` | Atualiza dados de um tutor |
| `DELETE` | `/tutores/{id}` | Deleta um tutor |

### Animais (`/animais`)

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/animais` | Cadastra um novo animal |
| `GET` | `/animais` | Lista todos os animais |
| `GET` | `/animais/{id}` | Busca um animal por ID |
| `PUT` | `/animais/{id}` | Atualiza dados de um animal |
| `DELETE` | `/animais/{id}` | Deleta um animal |

### Veterinários (`/veterinarios`)

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/veterinarios` | Cadastra um novo veterinário |
| `GET` | `/veterinarios` | Lista todos os veterinários |
| `GET` | `/veterinarios/{id}`| Busca um veterinário por ID |
| `PUT` | `/veterinarios/{id}`| Atualiza dados de um veterinário |
| `DELETE` | `/veterinarios/{id}`| Deleta um veterinário |

### Consultas (`/consultas`)

| Verbo | Endpoint | Descrição |
| :--- | :--- | :--- |
| `POST` | `/consultas` | Agenda uma nova consulta |
| `GET` | `/consultas` | Lista todas as consultas |
| `DELETE` | `/consultas/{id}` | Cancela uma consulta |
