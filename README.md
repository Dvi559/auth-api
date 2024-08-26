# README - Sistema de Gerenciamento de Usuários com Autenticação JWT

## Visão Geral

Este projeto é uma aplicação web baseada em Spring Boot, projetada para gerenciar o cadastro de usuários, login e autenticação baseada em JWT (JSON Web Token). Ele oferece uma solução simples, porém robusta, para o gerenciamento de usuários, com recursos de segurança para garantir a integridade dos dados e a privacidade dos usuários. A aplicação foi desenvolvida utilizando Java 17, Spring Security, Hibernate, JPA e MySQL.

## Funcionalidades

- **Cadastro de Usuários:** Os usuários podem se cadastrar fornecendo informações necessárias como nome de usuário, email e senha.
- **Login de Usuários:** Usuários cadastrados podem fazer login utilizando suas credenciais (email e senha).
- **Autenticação JWT:** Após um login bem-sucedido, um token JWT é gerado e retornado ao usuário, que pode ser utilizado para autenticação em futuras requisições.
- **Validação de JWT:** A aplicação valida o JWT em cada requisição protegida para garantir que o usuário esteja autenticado.
- **Persistência de Dados:** Os dados dos usuários são persistidos em um banco de dados MySQL, utilizando Hibernate e JPA para o mapeamento objeto-relacional.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Hibernate**
- **JPA (Java Persistence API)**
- **MySQL**

## Configuração do Projeto

### Pré-requisitos

- **Java 17** deve estar instalado na sua máquina.
- **MySQL** deve estar instalado e configurado.

### Passos para Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd seu-repositorio
   ```
3. Configure as propriedades do banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
