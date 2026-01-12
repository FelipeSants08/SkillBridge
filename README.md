# 🚀 SkillBridge – Plataforma Inteligente de Trilhas de Aprendizado com IA

O **SkillBridge** é uma API REST desenvolvida em **Java com Spring Boot** que utiliza **Inteligência Artificial** para gerar **trilhas de aprendizado personalizadas**, focadas em preparar usuários para o **mercado de trabalho real**.

A aplicação analisa o perfil técnico e profissional do usuário e cria **Learning Tracks inteligentes**, adaptadas ao nível de conhecimento, experiência prévia e objetivo de carreira.

> 🎯 O foco do projeto é aplicar **boas práticas de backend**, **arquitetura limpa**, **segurança**, **persistência de dados** e **integração real com IA**, simulando um cenário de produto profissional.

---

## 🧠 O que o SkillBridge faz?

A plataforma analisa automaticamente:

* Objetivo profissional do usuário
* Experiência prévia
* Skills já dominadas
* Lacunas técnicas relevantes
* Nível estimado (iniciante / júnior / pleno)

Com base nisso, a IA gera uma **trilha de aprendizado completa**, contendo:

* 📌 Passos ordenados de aprendizado
* ⏱️ Tempo estimado por etapa
* 📝 Descrição clara do porquê cada passo é importante
* 🔗 Links úteis e atuais
* 📚 Recursos recomendados (documentação, cursos, livros)
* 📊 Status de progresso

Tudo isso é salvo no banco e associado ao usuário autenticado.

---

## 🏗️ Arquitetura da Aplicação

A aplicação segue uma arquitetura em camadas bem definida:

```
Controller → Service → Spring AI → Repository → PostgreSQL
```

### Principais responsabilidades:

* **Controllers**: Exposição de endpoints REST
* **Services**: Regras de negócio
* **Spring AI**: Comunicação com LLMs para geração das trilhas
* **Repositories (JPA)**: Persistência de dados
* **Security**: Autenticação e autorização com JWT

---

## 🧩 Principais Entidades

* **User** – Usuário da plataforma
* **Skill** – Skills associadas ao usuário
* **LearningTrack** – Trilha de aprendizado gerada pela IA
* **TrackStep** – Etapas da trilha

### Relacionamentos:

* Um usuário pode possuir várias **Learning Tracks**
* Uma **Learning Track** possui vários **Track Steps**
* Apenas uma trilha pode estar ativa por vez

---

## 🤖 Integração com Inteligência Artificial

A geração da trilha acontece da seguinte forma:

1. O usuário autenticado solicita uma trilha
2. O backend coleta:

   * Objetivo profissional
   * Experiência
   * Skills cadastradas
3. Um **prompt altamente estruturado** é criado
4. O prompt é enviado para o LLM via **Spring AI**
5. A IA retorna um **JSON estruturado**
6. O backend converte o JSON em entidades JPA
7. A trilha é persistida no banco e retornada ao usuário

### Exemplo de retorno da IA:

```json
{
  "targetJobGoal": "Backend Java Developer",
  "trackSteps": [
    {
      "title": "Spring Boot Avançado",
      "estimatedTime": "2 semanas",
      "description": "Aprofundar em boas práticas e arquitetura",
      "links": ["https://spring.io"],
      "resources": ["Documentação oficial"],
      "status": "PENDING"
    }
  ]
}
```

---

## 🔐 Autenticação e Segurança

O projeto utiliza:

* **Spring Security**
* **JWT (JSON Web Token)**
* Rotas protegidas por autenticação
* Controle de acesso por usuário autenticado

### Endpoints de autenticação:

* `POST /auth/register`
* `POST /auth/login`

---

## 📡 Principais Endpoints

### Usuário

* `PUT /user/experience` – Atualiza experiência profissional
* `POST /user/skills` – Adiciona skills ao usuário
* `GET /user/my-user` – Retorna dados do usuário logado

### IA / Learning Track

* `POST /ia` – Gera uma nova trilha de aprendizado
* `GET /ia/learning` – Lista trilhas do usuário
* `DELETE /ia/learning` – Remove trilhas do usuário

---

## 🛠️ Tecnologias Utilizadas

### Backend

* Java 17
* Spring Boot 3
* Spring Web
* Spring Security + JWT
* Spring Data JPA
* Spring AI
* Maven

### Banco de Dados

* PostgreSQL

### Infraestrutura

* Docker
* Docker Compose
* Azure Pipelines (CI/CD)

---

## ▶️ Como rodar o projeto localmente

### Pré-requisitos

* Java 17+
* Docker e Docker Compose
* Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/FelipeSants08/SkillBridge.git
cd SkillBridge

# Suba o banco de dados
docker compose up -d

# Rode a aplicação
mvn spring-boot:run
```

### Variáveis de ambiente

Crie um arquivo `.env`:

```env
SPRING_AI_API_KEY=your_api_key
DB_USER=postgres
DB_PASS=postgres
```

---

## 🧪 Swagger / Teste Online

📎 **Swagger UI:**
[http://20.226.241.237:8080/swagger-ui/index.html](http://20.226.241.237:8080/swagger-ui/index.html)

### Usuário de teste

```json
{
  "email": "felipesantana@email.com",
  "password": "123456"
}
```

---

## 🎯 Objetivo do Projeto

O SkillBridge foi desenvolvido para:

* ✔️ Ajudar pessoas a entrarem na área de tecnologia
* ✔️ Criar trilhas realistas baseadas no mercado
* ✔️ Aplicar conceitos avançados de backend
* ✔️ Demonstrar integração real com IA
* ✔️ Servir como projeto de portfólio profissional

---

## 👨‍💻 Autor

**Felipe Santana**
Desenvolvedor Backend Java
📌 Foco em Spring Boot, APIs REST, Arquitetura Limpa e IA aplicada

---

⭐ Se este projeto te ajudou ou chamou sua atenção, considere deixar uma estrela!
