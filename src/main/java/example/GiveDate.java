package example;

import com.amazonaws.services.lambda.runtime.Context;

import java.time.LocalDate;

public class GiveDate {
    public LocalDate localDate(Context context) {
        return LocalDate.now();
    }
}
