package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelResponseAge {
    private String name;
    private int age;
    private boolean isIsEligibleForDriving;
    private String description;
}
