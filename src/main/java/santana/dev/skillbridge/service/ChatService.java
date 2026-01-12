package santana.dev.skillbridge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import santana.dev.skillbridge.domain.dto.request.GeneratedLearningTrack;
import santana.dev.skillbridge.domain.dto.response.LearningTrackResponse;
import santana.dev.skillbridge.domain.model.LearningTrack;
import santana.dev.skillbridge.domain.model.TrackStep;
import santana.dev.skillbridge.domain.model.User;
import santana.dev.skillbridge.repository.LearningTrackRepository;

import java.util.List;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final LearningTrackService service;

    public ChatService(ChatClient.Builder builder, LearningTrackService service) {
        this.chatClient = builder
                .defaultSystem("""
                        Você um agente que cria trilhas de aprendizado a partir dos dados do usuário, para ele entrar no mercado de trabalho
                        Você vai dar dicas de Skills RELEVANTES para ele entrar no mercado de trabalho
                        """)
                .build();
        this.service = service;
    }

    public LearningTrackResponse sendMessage(User user) {
        String prompt =  """
            Você é um agente especializado em criar trilhas de aprendizado PERSONALIZADAS e PROFISSIONAIS,
            focadas em preparar o usuário para o MERCADO DE TRABALHO REAL.
            
            Sua função:
            
            1. ANALISAR o perfil do usuário:
               - Objetivo profissional
               - Experiência prévia
               - Skills atuais
               - Skills faltantes
               - Nível estimado (iniciante / júnior / pleno)
            
            2. IDENTIFICAR skills e conhecimentos REAIS do mercado atual para aquela carreira:
               - Tecnologias essenciais
               - Ferramentas amplamente usadas
               - Frameworks modernos
               - Boas práticas exigidas em entrevistas
               - Projetos que recrutadores valorizam
            
            3. GERAR uma trilha COMPLETA e RELEVANTE:
               - Passos ordenados e progressivos
               - Cada passo deve ter propósito claro
               - Conteúdos avançados ou intermediários caso o usuário já domine o básico
               - Nada de repetição do que o usuário já sabe
               - Sempre inclua:
                   * título do passo
                   * estimatedTime coerente com o nível
                   * descrição detalhada do porquê esse passo importa
                   * links úteis e REAIS
                   * recursos relevantes (documentação, cursos, livros, projetos)
                   * status: "PENDING"
            
            4. ADAPTAR à realidade do usuário:
               - Se ele já domina algo, pule ou aprofunde
               - Se ele possui lacunas importantes, dê foco nelas
               - A trilha deve deixá-lo pronto para processos seletivos de verdade
            
            5. FORMATO EXATO (não altere):
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
            
            REGRAS IMPORTANTES:
            - NÃO inclua campos como id, user ou objetos extras.
            - Os links e resources devem ser úteis, modernos e confiáveis.
            - Gere SEMPRE conteúdo profundo e profissional.
            - Pense como um recrutador + tech lead ao mesmo tempo.
            - Retorne SOMENTE o JSON.
            
            Dados do usuário:
            Objetivo profissional: %s
            Experiência prévia: %s
            Skills que já possui: %s
            
            Retorne SOMENTE o JSON no formato exato do modelo.
            """.formatted(user.getJobGoal(), user.getExperienceSummary(), user.getSkills());


        GeneratedLearningTrack generated = chatClient.prompt()
                .user(prompt)
                .call()
                .entity(GeneratedLearningTrack.class);

        LearningTrackResponse response = new LearningTrackResponse(
                user.getId(),
                generated.targetJobGoal(),
                generated.trackSteps()
        );

        service.convertLearningTrack(response, user);

        return response;
    }
}
