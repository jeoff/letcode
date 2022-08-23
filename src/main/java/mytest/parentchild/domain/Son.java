package mytest.parentchild.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Son extends Father {
    public Son() {
        System.out.println("Son");
    }

    String childProperty;
}
