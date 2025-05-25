package com.mytodo.TodoBackEnd.serviceImplementation;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mytodo.TodoBackEnd.pojo.SummarizeRequest;

@Service
public class TodoSummarizeService {
	
	private final WebClient webClient;
	
	@Value("${gemini.api.url}")
	private String geminiApiUrl;
	@Value("${gemini.api.key}")
	private String geminiApiKey;

	public TodoSummarizeService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}
	
	public String generateSummary(SummarizeRequest summarizeRequest) {
		String prompt = buildPrompt(summarizeRequest);
		
		Map<String, Object> requestBody = Map.of(
				"contents", new Object[] {
						Map.of("parts", new Object[] {
								Map.of("text", prompt)
						})
				}
		); 
		
		String response = webClient.post()
				.uri(geminiApiUrl + geminiApiKey)
				.header("Content-Type", "application/json")
				.bodyValue(requestBody)
				.retrieve()
				.bodyToMono(String.class)
				.block();
		return extractResponseContent(response);
	}

	private String extractResponseContent(String response) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode rootNode = mapper.readTree(response);
			return rootNode.path("candidates")
					.get(0)
					.path("content")
					.path("parts")
					.get(0)
					.path("text")
					.asText();
		}
		catch(Exception e) {
			return "Error processing request: " + e.getMessage();
		}
	}

	private String buildPrompt(SummarizeRequest summarizeRequest) {
		StringBuilder prompt = new StringBuilder();
		prompt.append("Generate a summary of all pending to-dos listed below using a ");
		if(summarizeRequest.getTone() != null && !summarizeRequest.getTone().isEmpty()) {
			prompt.append("Use a ").append(summarizeRequest.getTone()).append(" tone.");
		}
		prompt.append("\nThe incomplete to-dos are ").append(summarizeRequest.getIncompleteTodos());
		prompt.append("Note: Only provide the summary, as it will be used in my application.");
		return prompt.toString();
	}
}
