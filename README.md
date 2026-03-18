# DoseTrack

DoseTrack é uma API REST desenvolvida com **Spring Boot** e **PostgreSQL** para gerenciamento de medicamentos.  
O sistema permite cadastrar tratamentos, definir frequência de uso e calcular automaticamente as datas de início e término.

---

##  Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Lombok

---

##  Funcionalidades

A API permite:

- Cadastrar medicamentos
- Listar todos os medicamentos
- Buscar medicamento por ID
- Atualizar informações de um medicamento
- Remover medicamentos

Além disso, o sistema calcula automaticamente:

- Data de início do tratamento
- Data de término do tratamento com base na duração informada

---

##  Endpoints da API

### Criar medicamento

**POST /medications**

Exemplo de requisição:

```json
{
  "name": "Paracetamol",
  "frequency": 2,
  "termDays": 7
}
```

---

### Listar todos os medicamentos

**GET /medications**

---

### Buscar medicamento por ID

**GET /medications/{id}**

---

### Atualizar medicamento

**PUT /medications/{id}**

---

### Deletar medicamento

**DELETE /medications/{id}**

---

##  Configuração do projeto

Antes de executar a aplicação, configure o banco de dados no arquivo:

```
src/main/resources/application.properties
```

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dosetrack
spring.datasource.username=postgres
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

##  Como executar o projeto

1. Clone o repositório

```
git clone https://github.com/RyanHenrique3226/DoseTrack
```

2. Abra o projeto em uma IDE (IntelliJ, Eclipse, etc)

3. Configure o PostgreSQL

4. Execute a classe:

```
Application.java
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

##  Objetivo do projeto

O DoseTrack foi desenvolvido com o objetivo de criar uma aplicação para controle e acompanhamento de medicamentos. O sistema permite registrar tratamentos, definindo a frequência de uso e a duração do medicamento.

A ideia do projeto é evoluir para uma aplicação capaz de ajudar usuários a não esquecerem de tomar seus medicamentos, utilizando lembretes baseados nas informações cadastradas no sistema.
