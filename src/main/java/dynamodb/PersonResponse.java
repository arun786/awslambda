package dynamodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PersonResponse {
    private String user_id;
    private String description;
}
