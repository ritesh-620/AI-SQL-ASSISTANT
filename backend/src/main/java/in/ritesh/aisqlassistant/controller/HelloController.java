package in.ritesh.aisqlassistant.controller;

import in.ritesh.aisqlassistant.Service.OllamaService;
import in.ritesh.aisqlassistant.model.SqlRequest;
import org.springframework.web.bind.annotation.*;
import in.ritesh.aisqlassistant.model.User;
import in.ritesh.aisqlassistant.repository.UserRepository;

import java.util.List;


@RestController
public class HelloController {
    private final UserRepository userRepository;

    public HelloController(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

}