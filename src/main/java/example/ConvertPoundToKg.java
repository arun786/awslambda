package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.Person;

public class ConvertPoundToKg implements RequestHandler<Person, String> {
    @Override
    public String handleRequest(Person person, Context context) {
        Double weight = person.getWeight();
        return String.format("The weight of %s is %s", person.getName(), weight * 0.45359237);
    }
}
