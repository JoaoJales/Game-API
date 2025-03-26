# 🎮 Game API

### **Uma API REST simples para buscar informações sobre jogos.**

#### Projeto pessoal desenvolvido para Estudos.
## 🚀 Tecnologias

- **Java + Spring Boot**
- **PostgreSQL**
- **Hibernate (JPA)**
- **Spring Data JPA**

## 📌 Endpoints

### 🔹 Listar todas os jogos
`GET /games`  
Retorna uma lista de todas as séries de jogos cadastradas no banco de dados.

### 🔹 Top 5 jogos mais bem avaliadas
`GET /games/top5`  
Retorna as cinco séries de jogos com as melhores avaliações.

### 🔹 Buscar jogos por desenvolvedor
`GET /games/developers/{name}`  
Retorna todas as séries desenvolvidas por um estúdio específico.


**Exemplo de resposta `GET /games`:**
```json
[
  {
    "name": "The Last of Us",
    "relaesed": "2013-09-17",
    "developer": "Rockstar North",
    "rating": 4.55,
    "background_image": "https://media.rawg.io/media/games/a5a/a5a7fb8d9cb8063a8b42ee002b410db6.jpg",
    "description": "Em um mundo devastado por um fungo que transforma humanos em criaturas monstruosas..."
  },
  {
    "name": "Grand Theft Auto V",
    "relaesed": "2013-06-24",
    "developer": "Naughty Dog",
    "rating": 4.47,
    "background_image": "https://media.rawg.io/media/games/20a/20aa03a10cda45239fe22d035c0ebe64.jpg",
    "description": "Grand Theft Auto V (GTA V) é um jogo de ação-aventura em mundo aberto..."
  }
]
```

---

## 🛠️ Configuração do Banco de Dados

A API utiliza **PostgreSQL**. Certifique-se de configurar corretamente as credenciais no arquivo `application.properties` ou `application.yml`.

Exemplo de configuração (`application.properties`):

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```
---

## 🏆 Créditos
Os dados utilizados nesta API são fornecidos pela API RAWG.

🔗 RAWG API: https://rawg.io/apidocs?ref=public_apis&utm_medium=website

---

## 📌 Autor

👤 **João Ricardo Jales Cirino**  
📧 **Contato:** [Linkedin](www.linkedin.com/in/joão-ricardo-cirino) / joaoricardocirino@gmail.com

---