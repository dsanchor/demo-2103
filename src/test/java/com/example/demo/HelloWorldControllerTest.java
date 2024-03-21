package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Import the necessary class for the get() method
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content; // Import the necessary class for the content() method
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status; // Import the necessary class for the status() method

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World from Spring Boot!"));
    }

    @Test
    public void testReverse() throws Exception {
        mockMvc.perform(get("/reverse")
                .param("input", "Hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("olleH"));
    }

    @Test
    public void testReverseWithEmptyInput() throws Exception {
        mockMvc.perform(get("/reverse")
                .param("input", ""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Input parameter cannot be null or empty"));
    }

    @Test
    public void testRemoveVowels() throws Exception {
        mockMvc.perform(get("/removeVowels")
                .param("input", "Hello World"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hll Wrld"));
    }

    @Test
    public void testRemoveVowelsWithEmptyInput() throws Exception {
        mockMvc.perform(get("/removeVowels")
                .param("input", ""))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Input parameter cannot be null or empty"));
    }
}