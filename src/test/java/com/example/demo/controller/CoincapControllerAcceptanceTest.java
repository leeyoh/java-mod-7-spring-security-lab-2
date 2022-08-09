package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoincapControllerAcceptanceTest {
    @Autowired
    private MockMvc mockMvc;
    @WithMockUser(username = "fakeuser", authorities = "admin")
    @Test
    void getBitcoinPrice() throws Exception {
        mockMvc.perform(get("/coincap"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @WithMockUser(username = "fakeuser", authorities = "admin")
    @Test
    void getCryptoPrice() throws Exception {
        mockMvc.perform(get("/coincap/ethereum"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}