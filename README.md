
# Controle de Gastos Pessoais

API desenvolvida para controle de despesas pessoais, permitindo organizar movimentações financeiras e categorias.

## Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Lombok**
- **PostgreSQL**
- **Swagger (Documentação de API)**

## Endpoints disponíveis

### **Movimentação**
- `GET /movimentacao/{id}` — Buscar movimentação por ID
- `POST /movimentacao` — Cadastrar uma nova movimentação
- `PUT /movimentacao/{id}` — Atualizar movimentação
- `DELETE /movimentacao/{id}` — Deletar movimentação
- `GET /movimentacao` — Listar todas as movimentações
- `GET /movimentacao/valor` — Retornar o valor total das movimentações
- `GET /movimentacao/tipo/{tipo}` — Filtrar movimentações por tipo (ex.: receita, despesa)
- `GET /movimentacao/data/{dataInicio}/{dataFim}` — Filtrar movimentações por período
- `GET /movimentacao/categoria/{id}` — Filtrar movimentações por categoria

### **Categoria**
- `GET /categoria/{id}` — Buscar categoria por ID
- `POST /categoria` — Cadastrar nova categoria
- `PUT /categoria/{id}` — Atualizar categoria
- `DELETE /categoria/{id}` — Deletar categoria
- `GET /categoria` — Listar todas as categorias






## Como executar o projeto

### Pré-requisitos

- Java 17+
- PostgreSQL
- Maven ou sua IDE de preferência

### Configurações necessárias

O projeto utiliza variáveis de ambiente para configuração do banco de dados. Você deve definir as seguintes variáveis no seu sistema:

- `DATABASE_URL` — URL de conexão do PostgreSQL (ex.: `jdbc:postgresql://localhost:5432/nome_do_banco`)
- `DATABASE_USERNAME` — Usuário do banco
- `DATABASE_PASSWORD` — Senha do banco

Ou, se preferir, você pode configurar diretamente no arquivo `application.properties`:

```properties
spring.datasource.url=${DATABASE_URL}
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}
```

### Executando

1. Clone o repositório:
```bash
git clone https://github.com/RafaelGelain/controle-de-gastos
```
2. Acesse a pasta do projeto:
```bash
cd controle-de-gastos
```
3. Execute:
```bash
./mvnw spring-boot:run
```
Ou rode pela sua IDE.

A API estará disponível em:  
`http://localhost:8080`
