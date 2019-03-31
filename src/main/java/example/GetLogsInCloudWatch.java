package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dynamodb.PersonRequest;


public class GetLogsInCloudWatch implements RequestHandler<PersonRequest, String> {


    @Override
    public String handleRequest(PersonRequest personRequest, Context context) {

        String name = personRequest.getAge() + personRequest.getFirst_name() + personRequest.getLast_name() + personRequest.getUser_id();
        context.getLogger().log("This is the name : " + name);
        return name;

    }
}
