package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.util.StringUtils;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String helloWorld() {
        System.out.println("Entering helloWorld method");
        String result = "Hello World from Spring Boot!";
        System.out.println("Exiting helloWorld method with result: " + result);
        return result;
    }

    @GetMapping("/reverse")
    public ResponseEntity<String> reverse(@RequestParam String input) {
        System.out.println("Entering reverse method with input: " + input);
        if (StringUtils.isEmpty(input)) {
            System.out.println("Input parameter is null or empty");
            return ResponseEntity.badRequest().body("Input parameter cannot be null or empty");
        }
        String result = new StringBuilder(input).reverse().toString();
        System.out.println("Exiting reverse method with result: " + result);
        return ResponseEntity.ok(result);
    }

    // borrar vocales de un string
    @GetMapping("/removeVowels")
    public ResponseEntity<String> removeVowels(@RequestParam String input) {
        System.out.println("Entering removeVowels method with input: " + input);
        if (StringUtils.isEmpty(input)) {
            System.out.println("Input parameter is null or empty");
            return ResponseEntity.badRequest().body("Input parameter cannot be null or empty");
        }
        String result = input.replaceAll("[aeiouAEIOU]", "");
        System.out.println("Exiting removeVowels method with result: " + result);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/isPalindrome")
    public ResponseEntity<String> isPalindrome(@RequestParam String input) {
        System.out.println("Entering isPalindrome method with input: " + input);
        if (StringUtils.isEmpty(input)) {
            System.out.println("Input parameter is null or empty");
            return ResponseEntity.badRequest().body("Input parameter cannot be null or empty");
        }
        String reverse = new StringBuilder(input).reverse().toString();
        String result = input.equalsIgnoreCase(reverse) ? "Yes" : "No";
        System.out.println("Exiting isPalindrome method with result: " + result);
        return ResponseEntity.ok(result);
    }

}