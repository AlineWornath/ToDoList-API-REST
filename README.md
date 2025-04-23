
# ✅ ToDoList-API-REST

Aplicação para criação e gerenciamento de tarefas (To-Do List), utilizando arquitetura RESTful. A API permite registrar, atualizar, deletar e consultar tarefas com persistência de dados em banco H2 e validação por Jakarta Bean Validation. Desenvolvida inteiramente em Java.

---

## 🛠️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- H2 Database
- Jakarta Bean Validation
- Swagger (para documentação da API)
- Maven
- Postman (testes de requisição)
- IDE recomendada: IntelliJ IDEA / Eclipse

---

## 🚀 Guia de Uso

### Pré-requisitos

- Java 17 ou superior instalado
- Maven instalado
- Git

### Instalação e Execução

```bash
# Clonar o repositório
git clone https://github.com/AlineWornath/ToDoList-API-REST.git

# Entrar no diretório do projeto
cd ToDoList-API-REST

# Compilar o projeto
mvn clean install

# Rodar a aplicação
mvn spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

Para acessar a documentação interativa com Swagger:
`http://localhost:8080/swagger-ui.html`

---

## 📐 Diagrama de Classes

![Diagrama de Classes](docs/diagrama.png)

> O diagrama acima apresenta as principais classes da aplicação e suas relações.

---

## 🧪 Exemplos de Uso

### Criar uma nova tarefa

```http
POST /tarefas
Content-Type: application/json

{
  "title": "Tarefa de Exemplo",
  "description": "Descrição da tarefa de exemplo.",
  "deadline": "2025-05-10",
  "status": "PENDENTE"
}
```

### Listar todas as tarefas

```http
GET /tarefas
```

---

## 🎯 Entregas do Projeto

- ✅ API REST funcional para CRUD de tarefas
- ✅ Validação dos dados com Jakarta
- ✅ Persistência de dados com banco H2
- ✅ Integração com Swagger para documentação da API
- ❌ Implementação de autenticação/autorização
- ❌ Desenvolvimento de front-end

---

## ⚔️ Desafios e Perrengues

- Configuração do H2 com persistência automática
- Ajuste das anotações de validação (Bean Validation)
- Comunicação e testes com o Postman
- Integração do Swagger com Spring Boot
- Dificuldade para casar as agendas dos integrantes do grupo, considerando outros compromissos como faculdade e trabalho
- Tempo limitado para implementar autenticação e testes automatizados

---

## 👥 Autores e Responsabilidades

| Nome              | GitHub                                           | Responsabilidades                                                                 |
|-------------------|--------------------------------------------------|------------------------------------------------------------------------------------|
| Aline Wornath     | [@AlineWornath](https://github.com/AlineWornath) | Adaptação do projeto para Spring Boot, integração com Swagger                      |
| Stefanie Castro   | [@Stefanie-Grou](https://github.com/Stefanie-Grou) | Integração com H2, validação com Jakarta, testes com Postman                       |

---

## 📄 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](./LICENSE) para mais detalhes.

---

## 📢 Apresentação Final

- **Resumo do projeto:** API REST de lista de tarefas em Java
- **Desafios enfrentados:** configuração do H2, validações, uso do Swagger e Postman, gestão de tempo entre integrantes
- **O que foi entregue:** CRUD funcional, Swagger, validações, persistência
- **O que ficou faltando:** autenticação, testes automatizados, front-end

---
