package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.ModelRequestAge;
import model.ModelResponseAge;

public class Calculate implements RequestHandler<ModelRequestAge, ModelResponseAge> {

    @Override
    public ModelResponseAge handleRequest(ModelRequestAge modelRequestAge, Context context) {
        String name = modelRequestAge.getName();
        int age = modelRequestAge.getAge();
        String description = name + " is eligible for driving ";

        ModelResponseAge modelResponseAge = new ModelResponseAge();
        modelResponseAge.setName(name);
        modelResponseAge.setAge(age);

        if (age > 18) {
            modelResponseAge.setIsEligibleForDriving(true);
        } else {
            description = name + " is not eligible for driving";
            modelResponseAge.setIsEligibleForDriving(false);
        }

        modelResponseAge.setDescription(description);
        context.getLogger().log(modelResponseAge.toString());
        return modelResponseAge;
    }
}
