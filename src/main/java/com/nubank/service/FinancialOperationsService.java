package com.nubank.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.ArrayList;
import java.util.List;

public class FinancialOperationsService {

    public List<ObjectNode> processOperations(JsonNode operations) {
        List<ObjectNode> taxes = new ArrayList<>();
        double weightedAverage = 0.0;
        int totalQuantity = 0;
        double accumulatedLoss = 0.0;

        for (JsonNode operation : operations) {
            String type = operation.get("operation").asText();
            double unitCost = operation.get("unit-cost").asDouble();
            int quantity = operation.get("quantity").asInt();
            double tax = 0.0;

            if (type.equals("buy")) {
                weightedAverage = ((totalQuantity * weightedAverage) + (quantity * unitCost)) / (totalQuantity + quantity);
                totalQuantity += quantity;
            } else if (type.equals("sell")) {
                double totalValue = unitCost * quantity;
                double profit = (unitCost - weightedAverage) * quantity;

                if (profit > 0) {
                    if (accumulatedLoss > 0) {
                        if (accumulatedLoss >= profit) {
                            accumulatedLoss -= profit;
                            profit = 0;
                        } else {
                            profit -= accumulatedLoss;
                            accumulatedLoss = 0;
                        }
                    }
                    if (totalValue > 20000) {
                        tax = profit * 0.20;
                    }
                } else {
                    accumulatedLoss += Math.abs(profit);
                }
                totalQuantity -= quantity;
            }

            ObjectNode taxNode = new ObjectMapper().createObjectNode();
            taxNode.put("tax", tax);
            taxes.add(taxNode);
        }

        return taxes;
    }
}