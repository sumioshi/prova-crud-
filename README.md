# Projeto CRUD - Prova
## Como Executar a Aplicação

1. Certifique-se de ter o **Java 21** e o **Maven** instalados.
2. No terminal, execute:
   ```
   mvn spring-boot:run
   ```
3. A aplicação estará na porta `8080`.

## Endpoints da API

### Pessoa
- **Listar**: `GET /api/pessoas`
- **Buscar por ID**: `GET /api/pessoas/{id}`
- **Criar**: `POST /api/pessoas`
- **Atualizar**: `PUT /api/pessoas/{id}`
- **Deletar**: `DELETE /api/pessoas/{id}`

### Trabalho
- **Listar**: `GET /api/trabalhos`
- **Buscar por ID**: `GET /api/trabalhos/{id}`
- **Criar**: `POST /api/trabalhos`
- **Atualizar**: `PUT /api/trabalhos/{id}`
- **Deletar**: `DELETE /api/trabalhos/{id}`

## Documentação e Testes

- **Swagger UI**: Acesse `http://localhost:8080/swagger-ui.html` para documentação e testes interativos.
- **Console H2**: Veja o banco em `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:testdb`, Usuário: `sa`, Senha: em branco).

## Estrutura do Projeto

- **Modelo**: Entidades `Pessoa` e `Trabalho`.
- **DTO**: Objetos de transferência de dados.
- **Controladores**: Endpoints da API.
- **Serviços**: Lógica de negócios.
- **Repositórios**: Acesso ao banco com Spring Data JPA.

