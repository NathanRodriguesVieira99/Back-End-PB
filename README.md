# Backend do Projeto de Bloco

API do nosso projeto de bloco da faculdade.

## Descrição

Este projeto é uma API REST desenvolvida com Spring Boot para cadastrar e listar jogos. Ela é usada em um site que permite listar todos os jogos, buscar jogos por categoria e adicionar novos jogos.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.5.0
- PostgreSQL
- Maven
- Deploy no Render com dockerfile

## Configuração e Instalação

1.  **Clone o repositório:**

    ```bash
    git clone (https://github.com/NathanRodriguesVieira99/Back-End-PB)
    cd Backend_PB
    ```

2.  **Execute a aplicação:**
    Você pode executar a aplicação rodando o arquivo main: BackendPbApplication.

    A aplicação estará disponível em `http://localhost:8080`.

## Endpoints da API

A seguir estão os endpoints disponíveis na API:

- **`GET /`**:

  - Descrição: Rota principal para verificar se a API está online.
  - Controlador: [`pb.com.Backend_PB.controllers.IndexController.mainRoute`](src/main/java/pb/com/Backend_PB/controllers/IndexController.java)
  - Resposta: `String` ("ok")

- **`GET /game`**:

  - Descrição: Retorna uma lista de todos os jogos.
  - Controlador: [`pb.com.Backend_PB.controllers.GameController.getAll`](src/main/java/pb/com/Backend_PB/controllers/GameController.java)
  - Resposta: `List<Game>`

- **`GET /game/category/{category}`**:

  - Descrição: Retorna uma lista de jogos filtrados pela categoria especificada.
  - Controlador: [`pb.com.Backend_PB.controllers.GameController.findByCategory`](src/main/java/pb/com/Backend_PB/controllers/GameController.java)
  - Parâmetro de Path: `category` (String)
  - Resposta: `ResponseEntity<List<Game>>`

- **`POST /game`**:
  - Descrição: Cria um novo jogo.
  - Controlador: [`pb.com.Backend_PB.controllers.GameController.create`](src/main/java/pb/com/Backend_PB/controllers/GameController.java)
  - Corpo da Requisição: `Game` (JSON)
    ```json
    {
      "name": "Nome do Jogo",
      "category": "Categoria do Jogo",
      "image_url": "url_da_imagem.png",
      "developer": "Desenvolvedor do Jogo",
      "release_date": "2024-07-28",
      "price": 59.99
    }
    ```
  - Resposta: `Game` (o jogo criado)

## Entidade Game

A entidade `Game` ([`pb.com.Backend_PB.entities.Game`](src/main/java/pb/com/Backend_PB/entities/Game.java)) possui os seguintes atributos:

- `id`: `Long` (Gerado automaticamente)
- `name`: `String`
- `category`: `String`
- `image_url`: `String`
- `developer`: `String`
- `release_date`: `String`
- `price`: `double`

## Créditos

Este projeto foi desenvolvido por:

- Nathan Vieira
- Natan Robers
- Victor Moraes
