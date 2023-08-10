# LivrADAria

Bem-vindo à documentação da LivrADAria! Esta API foi desenvolvida em Java utilizando o framework Spring Boot. Ela permite gerenciar informações sobre livros, editoras e categorias em uma livraria. Este arquivo README fornece informações sobre a API e como utilizá-la.

## Requisitos

Certifique-se de ter os seguintes requisitos instalados em seu ambiente de desenvolvimento:

- Java Development Kit (JDK) versão 8 ou superior
- Maven
- Spring Boot

## Configuração do Projeto

1. Clone este repositório em seu ambiente local:

```
git clone https://github.com/renancba/LivrADAria.git
```

2. Navegue até o diretório do projeto:

```
cd LivrADAria
```

3. Construa o projeto utilizando o Maven:

```
mvn clean install
```

4. Inicie o servidor embutido do Spring Boot:

```
mvn spring-boot:run
```

Agora, a LivrADAria API está em execução localmente no endereço `http://localhost:8080`.

## Endpoints

A LivrADAria API possui os seguintes endpoints:

### Livros

- `GET /livros`: Retorna a lista de todos os livros cadastrados.
- `GET /livros/{id}`: Retorna as informações de um livro específico com base no ID fornecido.
- `POST /livros`: Adiciona um novo livro. Envie as informações do livro no corpo da solicitação, seguindo o formato abaixo:

```json
{
  "id": 1,
  "nome": "Nome do Livro",
  "isbn": "1234567890123",
  "editora": {
    "id": 1,
    "nome": "Nome da Editora"
  },
  "categoria": {
    "id": 1,
    "nome": "Nome da Categoria",
    "descricao": "Descrição da Categoria"
  }
}
```

- `PUT /livros/{id}`: Atualiza as informações de um livro existente com base no ID fornecido. Envie as informações atualizadas no corpo da solicitação, seguindo o mesmo formato mencionado acima.
- `DELETE /livros/{id}`: Remove um livro da lista com base no ID fornecido.
- `GET /livros/categoria`: Retorna a lista de livros de uma determinada categoria. Envie o parâmetro `categoriaId` na consulta.
- `GET /livros/editora`: Retorna a lista de livros de uma determinada editora. Envie o parâmetro `editoraId` na consulta.
- `GET /livros/filter`: Retorna a lista de livros com base no nome e/ou ISBN fornecidos. Envie os parâmetros `nome` e `isbn` na consulta.

### Editoras

- `GET /editoras`: Retorna a lista de todas as editoras cadastradas.
- `GET /editoras/{id}`: Retorna as informações de uma editora específica com base no ID fornecido.
- `POST /editoras`: Adiciona uma nova editora. Envie as informações da editora no corpo da solicitação, seguindo o formato abaixo:

```json
{
  "id": 1,
  "nome": "Nome da Editora"
}
```

- `PUT /editoras/{id}`: Atualiza as informações de uma editora existente com base no ID fornecido. Envie as informações atualizadas no corpo da solicitação, seguindo o mesmo formato menc

ionado acima.
- `DELETE /editoras/{id}`: Remove uma editora da lista com base no ID fornecido.

### Categorias

- `GET /categorias`: Retorna a lista de todas as categorias cadastradas.
- `GET /categorias/{id}`: Retorna as informações de uma categoria específica com base no ID fornecido.
- `POST /categorias`: Adiciona uma nova categoria. Envie as informações da categoria no corpo da solicitação, seguindo o formato abaixo:

```json
{
  "id": 1,
  "nome": "Nome da Categoria",
  "descricao": "Descrição da Categoria"
}
```

- `PUT /categorias/{id}`: Atualiza as informações de uma categoria existente com base no ID fornecido. Envie as informações atualizadas no corpo da solicitação, seguindo o mesmo formato mencionado acima.
- `DELETE /categorias/{id}`: Remove uma categoria da lista com base no ID fornecido.

## Tratamento de Erros

A LivrADAria API retorna códigos de status HTTP apropriados para indicar o resultado de uma solicitação. Em caso de erro, uma resposta JSON será enviada, contendo uma mensagem de erro e detalhes adicionais, se aplicável.

## Considerações Finais

A LivrADAria API é uma solução poderosa para gerenciar informações sobre livros, editoras e categorias em uma livraria. Sinta-se à vontade para explorar e utilizar a API em seus próprios projetos. Se tiver alguma dúvida, consulte a documentação dos endpoints para obter informações mais detalhadas.
