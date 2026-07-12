package com.nihar.backend.service.ai;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GroqService {

    private final RestClient restClient;

    @Value("${groq.api.key}")
    private String apiKey;

    @Value("${groq.api.url}")
    private String apiUrl;

    public GroqService(RestClient restClient) {
        this.restClient = restClient;
    }

    public String askGroq(String prompt) {

        GroqRequest request = new GroqRequest(
                "llama-3.3-70b-versatile",
                List.of(new GroqMessage("user", prompt))
        );

        GroqResponse response = restClient.post()
                .uri(apiUrl)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(GroqResponse.class);

        if (response == null
                || response.getChoices() == null
                || response.getChoices().isEmpty()) {

            return "No response from Groq.";

        }

        return response.getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}