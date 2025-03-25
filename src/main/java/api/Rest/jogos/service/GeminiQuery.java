package api.Rest.jogos.service;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class GeminiQuery {
    public static String getDescription(String title){
        ChatLanguageModel gemini = GoogleAiGeminiChatModel.builder()
                .apiKey(System.getenv("GEMINI_APIKEY"))
                .modelName("gemini-1.5-flash")
                .build();

        String response = gemini.generate("Me de uma descrição curta sobre esse jogo: " + title);
        return response;
    }
}
