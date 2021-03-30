package mytest.beancopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;

@Log4j
public class BeanCopyTest {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        User source = new User("Tom", "asfda34-token", 18);

        User dest = new User();

        BeanUtils.copyProperties(source, dest);

        log.info(dest);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class User {
    String name;
    String token;

    int age;
}
