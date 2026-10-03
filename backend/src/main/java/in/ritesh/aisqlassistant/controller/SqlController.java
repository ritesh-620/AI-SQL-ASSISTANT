package in.ritesh.aisqlassistant.controller;

import in.ritesh.aisqlassistant.model.SqlRequest;
import in.ritesh.aisqlassistant.Service.OllamaService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/sql")
public class SqlController {

    private final OllamaService ollamaService;

    public SqlController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @PostMapping("/generate")
    public String generateSQL(@RequestBody SqlRequest request) {
        return ollamaService.generateSql(request.getPrompt());
    }
}