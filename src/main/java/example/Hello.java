package example;

import com.amazonaws.services.lambda.runtime.Context;

public class Hello {
    //To print Hello World - int value when the lambda function is invoked
    public String myHandler(int input, Context context) {
        context.getLogger().log("Input: " + input);
        return "Hello World - " + input;
    }
}
