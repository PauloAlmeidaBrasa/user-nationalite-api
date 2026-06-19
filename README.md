# Teste Equip UX API

## Português (Brasil)

Este é um backend em Spring Boot para o projeto nationality user da quipux.

## Tecnologias

- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Spring Security
- Autenticação JWT (jjwt)
- Migrações de banco de dados com Flyway
- MySQL
- Validação com Spring Validation
- Testes com Spring Boot Test (MockMvc, spring-security-test)
- Integração com API externa https://api.nationalize.io

## Pré-requisitos

- Java 17 instalado
- Maven disponível ou use o `mvnw` incluso
- MySQL rodando localmente
- Um usuário MySQL local para a aplicação

## Configuração

1. Clone o repositório.

2. Crie o banco de dados local e o usuário MySQL.

```sql
CREATE DATABASE testdatabase;

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'AppPassword123!';
GRANT ALL PRIVILEGES ON testdatabase.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
```

> Se o seu usuário root do MySQL for diferente, ajuste os comandos conforme necessário.

3. Crie o arquivo de ambiente.

Renomeie o arquivo de exemplo para `.env`:

```bash
cp .env.example .env
```

4. Preencha o `.env` com seus valores.

Exemplo de `.env`:

```env
NATIONALITY_API_BASE_URL=https://api.nationalize.io
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/testdatabase
SPRING_DATASOURCE_USERNAME=appuser
SPRING_DATASOURCE_PASSWORD=AppPassword123!
JWT_SECRET=ChangeThisJwtSecretKeyChangeThisJwtSecretKey
JWT_EXPIRATION_MS=3600000
```

## Executar a aplicação localmente

Use o Maven wrapper a partir da raiz do projeto:

```bash
bash ./mvnw spring-boot:run
```

Ou empacote o JAR e execute manualmente:

```bash
bash ./mvnw clean package
java -jar target/testequipux-0.0.1-SNAPSHOT.jar
```

A API ficará disponível em:

```
http://localhost:8080
```

## Endpoints importantes

- `POST /api/v1/login`
- `GET /api/v1/user/list`
- `GET /api/v1/user/{id}`
- `POST /api/v1/user/create`
- `DELETE /api/v1/user/{id}`
- `GET /api/v1/nationality/findNacionalityByPerson/{name}`

## Testes

Execute todos os testes com:

```bash
bash ./mvnw test
```

Execute apenas os testes de controller:

```bash
bash ./mvnw -Dtest=AuthControllerTest,UserControllerTest test
```

## Observações

- A aplicação carrega variáveis de ambiente do arquivo `.env` na raiz do projeto.
- Garanta que o arquivo `.env` não seja versionado.
- Se alterar as credenciais ou o nome do banco, atualize também o `.env` e o usuário MySQL local.

---

## English

This is a Spring Boot backend API for the Teste Equip UX project.

## Technologies

- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Spring Security
- JWT authentication (jjwt)
- Flyway database migrations
- MySQL
- Spring Validation
- Spring Boot test stack (MockMvc, spring-security-test)
- External API integration with https://api.nationalize.io

## Prerequisites

- Java 17 installed
- Maven available or use the included `mvnw`
- MySQL server running locally
- A local MySQL user for the application

## Setup

1. Clone the repository.

2. Create the local database and the MySQL user.

```sql
CREATE DATABASE testdatabase;

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'AppPassword123!';
GRANT ALL PRIVILEGES ON testdatabase.* TO 'appuser'@'localhost';
FLUSH PRIVILEGES;
```

> If your MySQL root user is different, adjust the command accordingly.

3. Create the environment file.

Rename the example file to `.env`:

```bash
cp .env.example .env
```

4. Fill `.env` with your values.

Example `.env` content:

```env
NATIONALITY_API_BASE_URL=https://api.nationalize.io
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/testdatabase
SPRING_DATASOURCE_USERNAME=appuser
SPRING_DATASOURCE_PASSWORD=AppPassword123!
JWT_SECRET=ChangeThisJwtSecretKeyChangeThisJwtSecretKey
JWT_EXPIRATION_MS=3600000
```

## Run the application locally

Use the Maven wrapper from the project root:

```bash
bash ./mvnw spring-boot:run
```

Or build the JAR and run it manually:

```bash
bash ./mvnw clean package
java -jar target/testequipux-0.0.1-SNAPSHOT.jar
```

The API will be available at:

```
http://localhost:8080
```

## Important endpoints

- `POST /api/v1/login`
- `GET /api/v1/user/list`
- `GET /api/v1/user/{id}`
- `POST /api/v1/user/create`
- `DELETE /api/v1/user/{id}`
- `GET /api/v1/nationality/findNacionalityByPerson/{name}`

## Tests

Run all tests with:

```bash
bash ./mvnw test
```

Run only the controller tests:

```bash
bash ./mvnw -Dtest=AuthControllerTest,UserControllerTest test
```

## Notes

- The application loads environment variables from the `.env` file in the project root.
- Make sure your `.env` file is not committed to source control.
- If you change the database credentials or name, update both `.env` and the local MySQL user accordingly.
