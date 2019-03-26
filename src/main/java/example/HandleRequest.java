package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.HelloInput;
import model.HelloOutput;

public class HandleRequest implements RequestHandler<HelloInput, HelloOutput> {
    @Override
    public HelloOutput handleRequest(HelloInput helloInput, Context context) {
        HelloOutput helloOutput = new HelloOutput();

        helloOutput.setFunctionName(context.getFunctionName());
        helloOutput.setName(helloInput.getName());
        helloOutput.setMemoryLimit(context.getMemoryLimitInMB());
        context.getLogger().log(helloInput.getName() + " said hello");
        return helloOutput;
    }
}
