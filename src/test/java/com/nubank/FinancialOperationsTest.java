package com.nubank;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FinancialOperationsTest {

    @Test
    void main_withScenario1() throws Exception {
        runTest("src/test/cenarios/input/caso1.json", "src/test/cenarios/output/output1.json");
    }

    @Test
    void main_withScenario1_2() throws Exception {
        runTest("src/test/cenarios/input/caso1-2.json", "src/test/cenarios/output/output1-2.json");
    }

    @Test
    void main_withScenario2() throws Exception {
        runTest("src/test/cenarios/input/caso2.json", "src/test/cenarios/output/output2.json");
    }

    @Test
    void main_withScenario3() throws Exception {
        runTest("src/test/cenarios/input/caso3.json", "src/test/cenarios/output/output3.json");
    }

    @Test
    void main_withScenario4() throws Exception {
        runTest("src/test/cenarios/input/caso4.json", "src/test/cenarios/output/output4.json");
    }

    @Test
    void main_withScenario5() throws Exception {
        runTest("src/test/cenarios/input/caso5.json", "src/test/cenarios/output/output5.json");
    }

    @Test
    void main_withScenario6() throws Exception {
        runTest("src/test/cenarios/input/caso6.json", "src/test/cenarios/output/output6.json");
    }

    @Test
    void main_withScenario7() throws Exception {
        runTest("src/test/cenarios/input/caso7.json", "src/test/cenarios/output/output7.json");
    }

    @Test
    void main_withScenario8() throws Exception {
        runTest("src/test/cenarios/input/caso8.json", "src/test/cenarios/output/output8.json");
    }

    private void runTest(String inputFilePath, String outputFilePath) throws Exception {
        String[] args = {inputFilePath};

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method
        FinancialOperations.main(args);

        // Read the expected output
        String expectedString = readerTestUtil(outputFilePath);

        // Compare the results
        assertEquals(expectedString, outputStream.toString());
    }

    private String readerTestUtil(String filePath) {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuilder returnString = new StringBuilder();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                JsonNode jsonNode = objectMapper.readTree(line);
                returnString.append(jsonNode.toString());
                returnString.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnString.toString();
    }
}