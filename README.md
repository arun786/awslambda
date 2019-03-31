# awslambda


## Steps to Create a Lambda Function in aws which accesses DynamoDB Table

    Step 1 : Create a Lambda Function in aws.
    Step 2 : Create a Java class to save Items in DynamoDB Table
    Step 3 : Upload the jar file(fat jar) in aws Lambda Function.
    Step 4 : Create DynamoDb table with name as users
    Step 5 : Test Lambda function from the console or use an API Gateway to call the Lambda Function

### Save Item to DynamoDB Table

Name of DynamoDB Table :- users

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
    
    
#### PersonRequest Model

    package dynamodb;
    
    import lombok.Getter;
    import lombok.Setter;
    
    @Getter
    @Setter
    public class PersonRequest {
        private String user_id;
        private String first_name;
        private Integer age;
        private String last_name;
    }

#### PersonResponse Model

    package dynamodb;
    
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.Setter;
    
    @Getter
    @Setter
    @AllArgsConstructor
    public class PersonResponse {
        private String user_id;
        private String description;
    }

