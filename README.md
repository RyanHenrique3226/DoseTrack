# DoseTrack

DoseTrack é uma API REST desenvolvida com **Spring Boot** e **PostgreSQL** para gerenciamento de medicamentos.

O sistema permite cadastrar tratamentos, definir frequência de uso e **verificar automaticamente quando um medicamento deve ser tomado**, gerando notificações para auxiliar o usuário.

---

## Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Gradle
* Lombok

---

##  Funcionalidades

###  Gerenciamento de medicamentos

* Cadastrar medicamentos
* Listar todos os medicamentos
* Buscar medicamento por ID
* Atualizar informações de um medicamento
* Remover medicamentos

###  Controle de tratamento

* Cálculo automático da data de início
* Cálculo automático da data de término com base na duração
* Definição de frequência (ex: a cada X dias)

###  Controle de consumo

* Marcar medicamento como "tomado"
* Verificar se o medicamento já foi tomado no dia

###  Sistema de notificações

* Geração de notificações para medicamentos não tomados
* Listagem de notificações não lidas
* Marcar notificações como lidas (individual ou em massa)

###  Execução automática (Scheduler)

* Verificação periódica dos medicamentos
* Identifica se:

  * Hoje é dia de tomar o medicamento
  * O medicamento ainda não foi tomado
* Geração automática de notificações

---

##  Endpoints da API

###  Medicamentos

#### Criar medicamento

**POST /medications**

```json
{
  "name": "Paracetamol",
  "frequency": 2,
  "termDays": 7
}
```

#### Listar todos

**GET /medications**

#### Buscar por ID

**GET /medications/{id}**

#### Atualizar

**PUT /medications/{id}**

#### Deletar

**DELETE /medications/{id}**

---

###  Controle de consumo

#### Marcar como tomado

**POST /medications/{id}/take**

---

###  Notificações

#### Listar notificações não lidas

**GET /notifications**

#### Marcar como lida (individual)

**PUT /notifications/{id}**

#### Marcar todas como lidas

**PUT /notifications**

---

##  Scheduler

A aplicação possui um processo automático utilizando `@Scheduled` que executa verificações periódicas.

* Frequência: a cada 1 hora
* Intervalo: das 08:00 às 20:00
* Timezone: America/Recife

Esse processo:

1. Verifica todos os medicamentos cadastrados
2. Identifica se é dia de uso
3. Verifica se o medicamento já foi tomado
4. Caso não tenha sido, gera uma notificação automaticamente

---

##  Configuração do projeto

Antes de executar a aplicação, configure o banco de dados no arquivo:

```
src/main/resources/application.properties
```

Exemplo:

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

4. Execute a classe principal:

```
DoseTrackApplication.java
```

A aplicação será iniciada em:

```
http://localhost:8080
```

---

##  Objetivo do projeto

O DoseTrack foi desenvolvido com o objetivo de criar uma aplicação para controle e acompanhamento de medicamentos.

Além do gerenciamento básico, o sistema evolui para um modelo mais completo, incluindo:

* Automação de verificações
* Regras de recorrência
* Sistema de notificações

A proposta é evoluir para uma aplicação capaz de **lembrar o usuário de tomar seus medicamentos de forma automática**, podendo futuramente integrar com serviços externos como WhatsApp ou e-mail.

---

##  Próximas melhorias

* Integração com envio de mensagens (WhatsApp / Email)
* Autenticação de usuários
* Definição de horários específicos por medicamento
* Evitar notificações duplicadas
* Interface frontend

---

##  Autor

Desenvolvido por **Ryan Henrique**
