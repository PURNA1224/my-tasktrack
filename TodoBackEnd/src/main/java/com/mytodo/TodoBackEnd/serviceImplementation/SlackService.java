package com.mytodo.TodoBackEnd.serviceImplementation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class SlackService {
	
	@Value("${slack.webhook.url}")
	private String SLACK_WEBHOOK_URL;

	 public String sendToSlack(String summary) {
	        try {
	            String payload = "{\"text\": \"" + summary.replace("\"", "\\\"") + "\"}";

	            String response = WebClient.create()
	                    .post()
	                    .uri(SLACK_WEBHOOK_URL)
	                    .header("Content-Type", "application/json")
	                    .bodyValue(payload)
	                    .retrieve()
	                    .bodyToMono(String.class)
	                    .block(); // wait for response

	            return "✅ Slack message sent: " + response;

	        } catch (WebClientResponseException ex) {
	            return "❌ Slack API Error (" + ex.getStatusCode() + "): " + ex.getResponseBodyAsString();
	        } catch (Exception ex) {
	            return "❌ Failed to send to Slack: " + ex.getMessage();
	        }
	    }
}
