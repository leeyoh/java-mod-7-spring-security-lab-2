package com.example.demo.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseControllerUnitTest {
    ReverseController reverseController;
    @BeforeEach
    void setUp(){
        this.reverseController = new ReverseController();
    }


    @Test
    void reverseString() {
        assertEquals(this.reverseController.reverseString("FDSA"),"ASDF",
                "Test Uppercase");
        assertEquals(this.reverseController.reverseString("fdsa"),"asdf",
                "Test Lowercase");
        assertEquals(this.reverseController.reverseString("f d s a"),"a s d f",
                "Test Spaces");
        assertEquals(this.reverseController.reverseString("1234"),"4321",
                "Test Numbers");
    }
}