package com.nubank;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinancialOperationsTest {

    @Test
    void main_withScenario1() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso1.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output1.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario1_2() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso1-2.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output1-2.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }

    @Test
    void main_withScenario2() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso2.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output2.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario3() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso3.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output3.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario4() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso4.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output4.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario5() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso5.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output5.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario6() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso6.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output6.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario7() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso7.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output7.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }


    @Test
    void main_withScenario8() throws Exception {
        // Prepare input file path
        String inputFilePath = "src/test/cenarios/input/caso8.json";
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedTaxes = objectMapper.readTree(Files.readAllBytes(Paths.get("src/test/cenarios/output/output8.json")));

        // Parse the actual output
        JsonNode actualTaxes = objectMapper.readTree(outputStream.toString());

        // Compare the results
        assertEquals(expectedTaxes, actualTaxes);
    }
}