package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.DynamoDBFields;


public class GetLogsInCloudWatch implements RequestHandler<DynamoDBFields, String> {


    @Override
    public String handleRequest(DynamoDBFields dynamoDBFields, Context context) {

        String name = dynamoDBFields.getAge() + dynamoDBFields.getFirst_name() + dynamoDBFields.getLast_name() + dynamoDBFields.getUser_id();
        context.getLogger().log("This is the name : " + name);
        return name;

    }
}
