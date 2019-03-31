package dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class GetItemFromDynamoDb implements RequestHandler<String, PersonRequest> {

    private DynamoDB dynamoDB;
    private String DYNAMO_DB_TABLE = "users";

    @Override
    public PersonRequest handleRequest(String primary_key, Context context) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        this.dynamoDB = new DynamoDB(client);
        Table table = dynamoDB.getTable(DYNAMO_DB_TABLE);
        Item user_id = table.getItem("user_id", primary_key);
        String jsonString = user_id.toJSON();

        ObjectMapper objectMapper = new ObjectMapper();
        PersonRequest personRequest = null;
        try {
            personRequest = objectMapper.readValue(jsonString, new TypeReference<PersonRequest>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personRequest;
    }
}
