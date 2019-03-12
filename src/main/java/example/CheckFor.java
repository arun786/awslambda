package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.RequestClass;
import model.ResponseClass;

import java.util.HashMap;
import java.util.Map;

public class CheckFor implements RequestHandler<RequestClass, ResponseClass> {

    public String checkForLengthOfString(String name, Context context) {
        return "Length of the " + name + " = " + name.length();
    }

    @Override
    public ResponseClass handleRequest(RequestClass requestClass, Context context) {
        Map<String,String> map = new HashMap<>();
        map.put(requestClass.getFirstName(), requestClass.getLastName());
        return new ResponseClass(map);
    }
}
