📘 SkillBridge – Plataforma Inteligente de Trilha de Aprendizado com IA

O SkillBridge é uma aplicação moderna desenvolvida em Java + Spring Boot que usa Inteligência Artificial (via Spring AI) para criar trilhas de aprendizado personalizadas com base no perfil real de cada usuário.

A plataforma analisa:

✔️ Skills que o usuário já domina
✔️ Experiência profissional atual
✔️ Objetivo profissional desejado
✔️ Nível de maturidade técnica
✔️ Lacunas técnicas que ele precisa desenvolver

Com esses dados, a IA gera automaticamente uma Learning Track, contendo:

Passos ordenados de aprendizado

Descrições claras

Tempo estimado

Recursos recomendados (vídeos, livros, documentações, cursos)

Links úteis

Status de progresso

O resultado é uma trilha personalizada, atualizada com o que o mercado realmente exige para aquela carreira.

🚀 Tecnologias Utilizadas
Backend

Java 17

Spring Boot 3

Spring Web

Spring Security + JWT

Spring Data JPA

Spring AI

Maven

Integração com IA

Spring AI Client

Modelos LLM (Groq, OpenAI, etc.)

Prompts avançados com estruturação de JSON

Banco de Dados

Oracle DB ou MySQL

Containerização

Docker

Docker Compose

🧠 Como funciona a geração da Learning Track

Quando o usuário solicita uma trilha:

O SkillBridge coleta os dados do usuário logado:

Nome

Skills cadastradas

Experiência profissional

Objetivo desejado

Cria um prompt altamente estruturado para a IA.

Envia o prompt para a API do LLM via Spring AI.

A IA responde com um JSON estruturado contendo:

{
  "targetJobGoal": "string",
  "trackSteps": [
    {
      "title": "string",
      "estimatedTime": "string",
      "description": "string",
      "links": ["string"],
      "resources": ["string"],
      "status": "PENDING"
    }
  ]
}


O backend converte essa resposta em entidades JPA (LearningTrack e TrackStep) e salva no banco.

O usuário visualiza sua trilha completa.

🏗️ Arquitetura da Aplicação
Controller → Service → Spring AI → Repository → Oracle DB

Principais entidades

User

LearningTrack

TrackStep

Skill

A relação é:

Um usuário possui múltiplas Learning Tracks

Uma Learning Track possui vários Track Steps

💻 Como rodar o projeto localmente
1. Clone o repositório
git clone https://github.com/seu-usuario/skillbridge.git
cd skillbridge

2. Configure variáveis de ambiente

Crie um arquivo .env com:

SPRING_AI_API_KEY=your_key
DB_USER=your_user
DB_PASS=your_pass

3. Suba o banco (Docker)
docker compose up -d

4. Rode o projeto
mvn spring-boot:run

🔐 Autenticação e Segurança

O sistema utiliza:

JWT

Spring Security

Rotas protegidas

Controle de permissões do usuário

🎯 Objetivo do Projeto

O SkillBridge foi criado para:

✔ Ajudar pessoas a encontrarem o caminho certo na área desejada
✔ Oferecer trilhas realistas baseadas em padrões de mercado
✔ Otimizar esforços de estudo
✔ Ajudar iniciantes, juniores e profissionais em transição de carreira
✔ Servir como assistente pessoal de desenvolvimento profissional

📈 Exemplo de Learning Track gerada

(resumo)

Java Avançado

Spring Boot

JPA & Bancos de Dados

JWT

APIs REST

Microsserviços

Docker & Deploy em Cloud

Preparação para Entrevistas

TESTE ONLINE

http://20.226.241.237:8080/swagger-ui/index.html#/

Login:
{
  "email": "felipesantana@email.com",
  "password": "123456"
}
