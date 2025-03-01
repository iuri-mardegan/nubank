package com.nubank;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nubank.service.FinancialOperationsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FinancialOperations {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.nubank");
		context.refresh();

		FinancialOperationsService service = context.getBean(FinancialOperationsService.class);

		ObjectMapper objectMapper = new ObjectMapper();

		if (args.length > 0) {
			// Read from file
			String filePath = args[0];
			try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
				String line;
				while ((line = br.readLine()) != null) {
					JsonNode operations = objectMapper.readTree(line);
					List<ObjectNode> taxes = service.processOperations(operations);
					System.out.println(objectMapper.writeValueAsString(taxes));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			// Read from stdin
			try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
				String line;
				while ((line = br.readLine()) != null) {
					JsonNode operations = objectMapper.readTree(line);
					List<ObjectNode> taxes = service.processOperations(operations);
					System.out.println(objectMapper.writeValueAsString(taxes));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		context.close();
	}
}