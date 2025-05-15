API de Conversão de Moedas do Reino SRM
Spring Boot com PostgreSQL, Swagger e Docker

API para gerenciar conversões entre Ouro Real e Tibar no Mercado de Pulgas dos Mil Saberes. Este sistema permite o registro e conversão de moedas entre diferentes reinos, gerenciamento de produtos, taxas de câmbio e transações comerciais.

? Índice
Tecnologias Utilizadas
- Estrutura do Projeto
- Configuracao e Instalacao
- Documentacao da API
- Funcionalidades
- Esquema do Banco de Dados
- Exemplos de Uso

? Tecnologias Utilizadas

- Spring Boot 2.7.18: Framework para desenvolvimento de aplicacoes Java

- Java 11: Linguagem de programacao

- PostgreSQL 14: Banco de dados relacional

- Docker & Docker Compose: Containerizacao e orquestracao

- Spring Data JPA: Persistencia de dados

- Lombok: Reducao de codigo boilerplate

- MapStruct: Mapeamento entre objetos

- Swagger/OpenAPI: Documentacao da API

-  Maven: Gerenciamento de dependencias e build



## ? Configuracao e Instalacao

### Pre-requisitos
- Java 11 ou superior
- Maven 3.6 ou superior
- Docker e Docker Compose

### Passos para Instalacao

1. Clone o repositorio

``
git clone https://github.com/seu-usuario/api-conversao-moedas-srm.git
cd api-conversao-moedas-srm``

2. Inicie o banco de dados com Docker.
dentro da pasta main, use o comando:

``
docker-compose up -d
``

Isso iniciara um container PostgreSQL com as tabelas ja criadas conforme definido no arquivo create_tables.sql.

3.
Execute o build do projeto com o comando ``mvn clean install`` no terminal do projeto.
Isso ira gerar os models e controllers do Openapi

4.
Inicie o projeto

configuracao do docker com o banco

version: '3.8'
````
services:
postgres:
image: postgres:14
container_name: srm-postgres
environment:
POSTGRES_USER: postgres
POSTGRES_PASSWORD: 123
POSTGRES_DB: srm_db
ports:
- "5432:5432"
volumes:
- srm-postgres-data:/var/lib/postgresql/data
- ./create_tables.sql:/docker-entrypoint-initdb.d/create_tables.sql
restart: unless-stopped

volumes:
srm-postgres-data:
driver: local
````

### ADICIONAIS

configuracao do properties

````
server.servlet.context-path=/api/v1

spring.datasource.url=jdbc:postgresql://172.30.134.250:5432/srm_db
spring.datasource.username=postgres
spring.datasource.password=123
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.doc-expansion=none

springdoc.api-docs.path=/api-docs
springdoc.default-consumes-media-type=application/json
springdoc.default-produces-media-type=application/json
````

sendo 
``172.30.134.250:5432``
o ip do wsl ou da maquina que voce utilizou para subir o docker.

### DIAGRAMA BANCO

<img src="https://postimg.cc/2bgxjRQS" alt="Descrição da imagem" width="500"/>