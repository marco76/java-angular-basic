package dev.marco.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * The goal of this class is to test the controller using a MockMvc object without embedded server
 *
 * We didn't implement the version with the RestTemplate because spring doesn't like GET requests with body.
 * You can find more details about this issue in this post: https://marco.dev/spring-boot-test-get-body
 */
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
public class FeatureControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc; // injected with @AutoConfigureMockMvc

    @Test
    public void shouldReturnOurText() throws Exception {
        this.mockMvc
                .perform(get("/feature")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"valueA\": 5, \"valueB\": 7}"))
                        .andDo(print()) // we log the result
                        .andExpect(content().string(("{\"result\":12}")));
    }

}
