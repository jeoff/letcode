package mytest;

import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;

@Log4j
public class NullObjectTest {

    public static void main(String[] args) {
        Object optType = null;
        String optTypeStr = (String) optType;
        log.info(optTypeStr);

        log.info(StringUtils.isNotBlank(optTypeStr));

        String strA = "a", strB = "b";

        if(StringUtils.isNoneEmpty(strA, strB)) {
            log.info(strA);
            log.info(strB);
        }

    }
}
