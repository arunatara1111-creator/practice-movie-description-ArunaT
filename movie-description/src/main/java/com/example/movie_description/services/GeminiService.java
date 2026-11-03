package com.example.movie_description.services;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GeminiService {

    private final Client client;

    public GeminiService(
            @Value("${gemini.api-key}") String apiKey) {

        this.client = Client.builder()
                .apiKey(apiKey)
                .build();
    }

    public String generateDescription(String title) throws HttpException, IOException {

        String prompt = "Write a short and interesting movie description " +
                "for the movie titled: " + title +
                ". Return only the description.";

        GenerateContentResponse response =
                client.models.generateContent(
                        "gemini-3.8-flash",
                        prompt,
                        null
                );

        return response.text();
    }
}