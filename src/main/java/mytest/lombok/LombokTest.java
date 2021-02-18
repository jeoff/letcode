package mytest.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Log4j
public class LombokTest {

    public static void main(String[] args) {
        User user = new User("test", "phD", "male", false);
        log.info(user.toString());
    }
}

@Data
@ToString
@AllArgsConstructor
class User {
    String userName;
    String title;
    String sex;
    boolean boolVal;
}
