package in.ritesh.aisqlassistant.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class OllamaService {

    private final RestClient restClient;
    private final ObjectMapper objectMapper= new ObjectMapper();
    public OllamaService(){
        this.restClient = RestClient.builder().baseUrl("http://localhost:11434").build();
    }
    public String generateSql(String prompt){
        String requestBody = """
        {
            "model": "gpt-oss:20b-cloud",
                "messages":[
                    {
                        "role":"user",
                        "content":"Convert the following request into SQL. Return ONLY  the SQL query. Do not provide explanations,markdown, comments, or multiple alternatives. Request:%s"
                    }
              ],
              "stream":false
        }
        """.formatted(prompt);
        String response =  restClient.post().uri("/api/chat").body(requestBody).retrieve().body(String.class);

        try{
            JsonNode json = objectMapper.readTree(response);

            return json.get("message").get("content").asText();

        }
        catch (Exception e){
            throw new RuntimeException("Failed to parse Ollama response",e);
        }
    }
}

