package example;

import com.amazonaws.services.lambda.runtime.Context;

import java.util.HashMap;
import java.util.Map;

public class CheckFor {

    public String checkForLengthOfString(String name, Context context) {
        return "Length of the " + name + " = " + name.length();
    }

    public Map<String, String> returnAMap(String key, String value, Context context) {
        Map<String, String> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

}
