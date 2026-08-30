# Java Spring - API de Produtos e Autenticação

API REST desenvolvida com Java e Spring Boot para gerenciamento de produtos, utilizando autenticação e autorização com Spring Security e JWT.

O projeto também utiliza PostgreSQL para persistência dos dados e Flyway para versionamento do banco de dados.

## Funcionalidades

- Cadastro de usuários
- Autenticação de usuários
- Geração e utilização de token JWT
- Controle de acesso baseado em permissões
- Cadastro de produtos
- Listagem de produtos
- Persistência com PostgreSQL
- Versionamento do banco de dados com Flyway

## Tecnologias

- Java
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- PostgreSQL
- Flyway
- Maven

## Requisitos

- Java 21+
- Maven
- PostgreSQL

## Configuração do banco de dados

Configure as propriedades de conexão com o PostgreSQL no arquivo de configuração da aplicação.

As migrations do banco de dados são executadas e versionadas pelo Flyway.

## Executando o projeto

Clone o repositório:

```bash
git clone https://github.com/bispobr/Java-Spring-produto.git
cd Java-Spring-produto
```

Execute a aplicação com Maven:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## Autenticação

A aplicação utiliza JWT para autenticação.

O fluxo básico é:

```text
Registro
   ↓
Login
   ↓
Token JWT
   ↓
Requisição autenticada
   ↓
Autorização por permissão
```

### Login

```http
POST /auth/login
Content-Type: application/json
```

Exemplo:

```json
{
  "login": "usuario",
  "senha": "senha"
}
```

### Registro

```http
POST /auth/registro
Content-Type: application/json
```

Exemplo:

```json
{
  "login": "usuario",
  "senha": "senha",
  "permissao": "user"
}
```

## API de Produtos

### Listar produtos

```http
GET /produto
Authorization: Bearer <token>
```

Endpoint protegido por autenticação.

### Cadastrar produto

```http
POST /produto
Authorization: Bearer <token>
Content-Type: application/json
```

Exemplo:

```json
{
  "nome": "Produto exemplo",
  "preco": 100.00
}
```

O cadastro de produtos requer a permissão `ADMIN`.

## Banco de Dados

O projeto utiliza **PostgreSQL** como banco de dados relacional.

O versionamento e gerenciamento das alterações do schema são realizados utilizando **Flyway**.

## Estrutura do fluxo de autenticação

```text
Cliente
   │
   ├── POST /auth/registro
   │
   └── POST /auth/login
            │
            ▼
       Autenticação
            │
            ▼
         JWT Token
            │
            ▼
   ┌───────────────────┐
   │ Endpoints REST    │
   │ protegidos        │
   └─────────┬─────────┘
             │
             ▼
       Spring Security
             │
             ▼
       Autorização
```

## Testes

Execute os testes com:

```bash
mvn test
```

## Status

Projeto de estudo desenvolvido para praticar autenticação e autorização com Spring Security e JWT, além de persistência de dados com Spring Data JPA, PostgreSQL e Flyway.
