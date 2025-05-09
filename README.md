# API de Cursos 📚

Este é um projeto simples de API REST para gerenciamento de cursos, construído com Java, Spring Boot e PostgreSQL.

## Funcionalidades

- Criar um novo curso
- Listar todos os cursos
- Atualizar informações de um curso
- Inativar (delete lógico) um curso
- Listar apenas cursos ativos

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Configurar o banco de dados

Edite o arquivo `application.properties` com as suas credenciais:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/apicursos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

> Certifique-se de que o banco `apicursos` já foi criado no PostgreSQL e que a extensão `uuid-ossp` foi habilitada.

## Rodar a aplicação

Execute o seguinte comando no terminal:

```bash
./mvnw spring-boot:run
```

## Endpoints principais

- `POST /cursos` – Cadastrar novo curso  
- `GET /cursos` – Listar todos os cursos  
- `PUT /cursos/{id}` – Atualizar curso  
- `DELETE /cursos/{id}` – Inativar curso  
- `GET /cursos/ativos` – Listar cursos ativos  

## Estrutura do projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/meuprojeto/api_cursos/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── model/
│   │       └── repository/
│   └── resources/
│       └── application.properties
└── test/
```

## Autor

Feito por João Victor.  
Projeto feito para fins de estudo e prática com Spring Boot.
