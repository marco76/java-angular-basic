package dev.marco.example.springboot.hello;


import dev.marco.example.api.controller.HelloOpenApi;
import dev.marco.example.api.model.Greeting;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllerApiImpl implements HelloOpenApi {
    @Override
    public ResponseEntity<Greeting> getGreeting() {
        Greeting greeting = new Greeting();
        greeting.message("Hello from Spring Boot");
        return ResponseEntity.ok(greeting);
    }

    @Override
    public ResponseEntity<Greeting> getPersonalGreeting(String name) {
        Greeting greeting = new Greeting();
        greeting.message("Hello " + name + ", enjoy Spring Boot");
        return ResponseEntity.ok(greeting);
    }
}
