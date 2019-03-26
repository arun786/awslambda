package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamoDBFields {
    private String user_id;
    private String first_name;
    private Integer age;
    private String last_name;
}
