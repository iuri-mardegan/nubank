package com.nubank.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;

@Service
public class JsonStdinService {

    public void processJsonInput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder jsonInput = new StringBuilder();

        while (scanner.hasNextLine()) {
            jsonInput.append(scanner.nextLine());
        }

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonInput.toString());
            System.out.println("Received JSON: " + jsonNode.toString());
            // Process the JSON as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}