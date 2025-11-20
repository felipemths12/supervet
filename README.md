# API Clínica Veterinária - SuperVet 🐾

![Status](https://img.shields.io/badge/status-concluído-green) ![Java](https://img.shields.io/badge/java-21-orange) ![Spring](https://img.shields.io/badge/spring-boot-3-brightgreen)

Projeto de API REST desenvolvido como requisito avaliativo para a **AV3 da disciplina de Programação Orientada a Objetos (POO)** do **Centro Universitário Jorge Amado (UNIJORGE)**.

O sistema gerencia o fluxo de atendimento de uma clínica veterinária, controlando tutores, animais, veterinários e agendamentos de consultas.

## 📋 Funcionalidades

* **Gestão de Tutores:** Cadastro, listagem, atualização e remoção de clientes.
* **Gestão de Veterinários:** Cadastro e administração do corpo clínico.
* **Gestão de Animais:** Cadastro de pacientes com vínculo obrigatório a um Tutor existente.
* **Agendamento de Consultas:**
    * Registro de consultas vinculando um Animal e um Veterinário.
    * Validação de datas (não permite agendamento no passado).
    * Registro de diagnóstico (atualização da consulta).
    * Cancelamento de consultas.
* **Documentação Automática:** Interface interativa via Swagger UI.

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot 3**
* **Spring Data JPA** (Persistência de dados)
* **Spring Web** (API REST)
* **Spring Validation** (Validação de dados e DTOs)
* **SpringDoc OpenAPI** (Documentação Swagger)
* **MySQL** (Banco de dados relacional)
* **Maven** (Gerenciamento de dependências)

## 🏛️ Arquitetura do Projeto

O projeto segue a arquitetura em camadas para garantir a separação de responsabilidades:

1.  **Controller:** Recebe as requisições HTTP e retorna os DTOs.
2.  **Service:** Contém a lógica de negócios e regras de validação.
3.  **Repository:** Interface de comunicação com o banco de dados.
4.  **Model/Entity:** Representação das tabelas do banco.
5.  **DTOs:** Objetos de transferência de dados para segurança e filtragem.

## 📚 Documentação da API (Swagger)

O projeto possui documentação automática. Após iniciar a aplicação, acesse:

👉 **[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)**

Através dessa interface, é possível visualizar todos os endpoints e testar as requisições diretamente pelo navegador.

## ⚙️ Como Executar o Projeto

### Pré-requisitos
* Java JDK 21 instalado.
* Maven instalado.
* MySQL Server rodando.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
    ```

2.  **Configure as Credenciais:**
    Abra o arquivo `src/main/resources/application.properties` e verifique se o usuário e senha do MySQL conferem com o seu ambiente:
    ```properties
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```
    *Nota: O banco de dados `supervet` será criado automaticamente na primeira execução.*

3.  **Execute a Aplicação:**
    * Pela IDE (IntelliJ/Eclipse/VSCode): Rode a classe `SupervetApplication.java`.
    * Pelo Terminal:
        ```bash
        mvn spring-boot:run
        ```

## 🗺️ Endpoints Principais

| Recurso | Método | Endpoint | Descrição |
| :--- | :--- | :--- | :--- |
| **Tutores** | `POST` | `/tutores` | Cadastra um novo tutor |
| | `GET` | `/tutores` | Lista todos os tutores |
| **Animais** | `POST` | `/animais` | Cadastra animal (Requer ID do Tutor) |
| | `GET` | `/animais` | Lista animais com dados do tutor |
| **Veterinários** | `POST` | `/veterinarios` | Cadastra veterinário |
| | `GET` | `/veterinarios` | Lista veterinários |
| **Consultas** | `POST` | `/consultas` | Agenda consulta (Requer ID Animal e Vet) |
| | `GET` | `/consultas` | Lista histórico de consultas |

---
Desenvolvido por Camila Gomes, Felipe Matheus dos Santos, Joana Santos, Marcos Henrique Castro - UNIJORGE
