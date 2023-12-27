package dev.marco.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * The goal of this class is to test the controller using a MockMvc object without embedded server
 */
@SpringBootTest
@AutoConfigureMockMvc // we mock the http request and we don't need a server
public class HelloControllerMockMvcTest {

    @Autowired
    private MockMvc mockMvc; // injected with @AutoConfigureMockMvc

    @Test
    public void shouldReturnOurText() throws Exception {
        this.mockMvc
                .perform(get("/message")) // perform a request that can be chained
                .andDo(print()) // we log the result
                .andExpect(content().string(containsString("marco.dev"))); // we check that the Body of the answer contains our expectation
    }

}
