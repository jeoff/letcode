package mytest.parentchild.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Father {
    public Father() {
        System.out.println("Father");
    }

    String name;
    String gender;
    String email;
}
