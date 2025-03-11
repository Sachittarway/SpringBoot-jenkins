package com.lovetolearn.SpringBootApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HelloController.class)
class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello from Spring Boot!"));
    }
    
    @Test
    void testHelloEndpoint() throws Exception {
        mockMvc.perform(get("/"))
           .andExpect(status().isOk())
           .andExpect(content().string("Hello from Spring Boot!"));
    }
    
    @Test
    void testAddition() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "add"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 15.0"));
    }

    @Test
    void testSubtraction() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "subtract"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 5.0"));
    }

    @Test
    void testMultiplication() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "multiply"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 50.0"));
    }

    @Test
    void testDivision() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result: 2.0"));
    }

    @Test
    void testDivisionByZero() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "0")
                .param("operation", "divide"))
                .andExpect(status().isOk())
                .andExpect(content().string("Error: Cannot divide by zero!"));
    }

    @Test
    void testInvalidOperation() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("num1", "10")
                .param("num2", "5")
                .param("operation", "modulus"))
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid operation! Use: add, subtract, multiply, or divide."));
    }
}
