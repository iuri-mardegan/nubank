# Serviço de Operações Financeiras

## Visão Geral

A classe `FinancialOperationsService` é um serviço que processa operações financeiras e calcula impostos com base nas operações fornecidas. O principal método de interesse nesta classe é o `processOperations`, que recebe um `JsonNode` contendo uma lista de operações e retorna uma lista de `ObjectNode` representando os impostos calculados para cada operação.

## Explicação do Método

### Inicialização

O método começa inicializando várias variáveis: `taxes` para armazenar os resultados, `weightedAverage` para acompanhar o custo médio das ações compradas, `totalQuantity` para rastrear o número total de ações e `accumulatedLoss` para armazenar quaisquer perdas acumuladas que podem ser usadas para compensar lucros futuros.

```java
List<ObjectNode> taxes = new ArrayList<>();
double weightedAverage = 0.0;
int totalQuantity = 0;
double accumulatedLoss = 0.0;
```

### Iterando Sobre as Operações

O método então itera sobre cada operação no `JsonNode` fornecido. Para cada operação, ele extrai o tipo (`buy` ou `sell`), o custo unitário e a quantidade.

```java
String type = operation.get("operation").asText();
double unitCost = operation.get("unit-cost").asDouble();
int quantity = operation.get("quantity").asInt();
```

### Tratando Operações de Compra

Se o tipo de operação for `buy`, o método atualiza o `weightedAverage` e o `totalQuantity` para refletir a nova compra. O `weightedAverage` é recalculado para incluir as novas ações compradas ao custo unitário especificado.

```java
if (type.equals("buy")) {
    weightedAverage = ((totalQuantity * weightedAverage) + (quantity * unitCost)) / (totalQuantity + quantity);
    totalQuantity += quantity;
}
```

### Tratando Operações de Venda

Se o tipo de operação for `sell`, o método calcula o valor total da venda e o lucro (ou prejuízo) da venda. Se houver lucro, ele verifica se há perdas acumuladas para compensar o lucro. Se o valor total da venda exceder 20000, um imposto de 20% é aplicado ao lucro. Se houver prejuízo, ele é adicionado ao `accumulatedLoss`.

```java
else if (type.equals("sell")) {
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
```

### Criando Nós de Imposto

Finalmente, para cada operação, um `ObjectNode` é criado para armazenar o imposto calculado, que é então adicionado à lista `taxes`. O método retorna a lista de `ObjectNode` contendo as informações de imposto para cada operação.

```java
ObjectNode taxNode = new ObjectMapper().createObjectNode();
taxNode.put("tax", tax);
taxes.add(taxNode);
```

## Execução da Aplicação

Para executar a aplicação, você precisa criar um JAR que inclua todas as dependências:

Construa o JAR com o comando:

```sh
./gradlew clean build
```

Para executar a aplicação, use o comando:

```sh
java -jar build/libs/nubank-0.0.1-SNAPSHOT.jar < src/test/cenarios/input/caso1.json
```

Com essas instruções, a aplicação estará pronta para processar operações financeiras e calcular os impostos correspondentes.
```