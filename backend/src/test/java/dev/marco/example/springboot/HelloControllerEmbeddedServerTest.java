package dev.marco.example.springboot;

import dev.marco.example.springboot.hello.HelloController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * The goal of this class is to show how the Embedded Server is used to test the REST service
 */

// SpringBootTest launch an instance of our application for tests purposes
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerEmbeddedServerTest {

    @Autowired
    private HelloController helloController;

    // inject the runtime port, it requires the webEnvironment
    @LocalServerPort
    private int port;

    // we use TestRestTemplate, it's an alternative to RestTemplate specific for tests
    // to use this template a webEnvironment is mandatory
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void index() {
        // we test that our controller is not null
        Assertions.assertThat(helloController).isNotNull();
    }

    @Test
    void indexResultTest() {
        Assertions.assertThat(restTemplate.getForObject("http://localhost:" + port + "/message", String.class)).contains("from Spring Boot");
    }
}