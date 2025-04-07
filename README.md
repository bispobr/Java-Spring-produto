# Java-Spring-Autenticação

Este repositório contém uma API simples desenvolvida em Java Spring, com o objetivo de praticar e aplicar o uso do Spring Security e JWT para controle de autenticação. A aplicação implementa um cadastro de produtos com autenticação de usuários.

## Instalação

1. Clone o repositório:

```bash
git clone hhttps://github.com/bispobr/Java-Spring-produto.git
```

2. Instale as dependências com Maven

## Como Usar

1. Inicie a aplicação com o Maven
2. API está acessível através do Link http://localhost:8080


## API Endpoints
API contem o seguinte endpoint :

```http request
GET /produto - Retorna uma lista com todos os produtos. (Obrigatorio está autenticado)
```
```http request
POST /produto - Adiciona um novo produto (usuarios ADMIN).
Content-Type: application/json

{
  "nome": "xxxxxx",
  "preco": 0000
}
```

```http request
POST /auth/login - Realiza login na aplicação
Content-Type: application/json

{
  "login": "xxxxxxxxx",
  "senha": "xxxxxxxxx",
}
```

```http request
POST /auth/registro - Registra um novo Usuario (admin) ou (user)
{
  "login": "xxxxxxxxx",
  "senha": "xxxxxxxxx",
  "permissao" : "user"
}
```

## Banco de Dados
Esse projeto utiliza o PostgresSQL como Banco de Dados. Todas as migrations são gerenciadas através do Flyway.

