package com.example.demo.controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reverse")


/**
 * Create unit tests to make sure your method works with uppercase,
 * lowercase, mixed case, spaces and words with numbers in them
 * - Remove the endpoint mapping from your endpoint
 * - Ensure that your unit tests still pass
 */
public class ReverseController {
        @PostMapping // localhost:8080/reverse
        public String reverseString(@RequestBody String input){
            StringBuilder reverse = new StringBuilder();
            for(int i = 0; i < input.length(); i++){
                reverse.append(input.charAt(input.length() - 1 - i));
            }
            return reverse.toString();
        }
}
