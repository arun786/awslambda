package dynamodb;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SaveToDynamoDb implements RequestHandler<PersonRequest, PersonResponse> {

    private DynamoDB dynamoDB;
    private String DYNAMO_DB_TABLE = "users";

    @Override
    public PersonResponse handleRequest(PersonRequest personRequest, Context context) {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
        this.dynamoDB = new DynamoDB(client);

        Item item = new Item().withPrimaryKey("user_id", personRequest.getUser_id())
                .withNumber("age", personRequest.getAge())
                .withString("first_name", personRequest.getFirst_name())
                .withString("last_name", personRequest.getLast_name());

        PutItemOutcome putItemOutcome = this.dynamoDB.getTable(DYNAMO_DB_TABLE).putItem(item);

        return new PersonResponse(personRequest.getUser_id(), personRequest.getFirst_name() + " has been inserted in user DynamoDB table");
    }
}
