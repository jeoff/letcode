package mytest.joda;

import lombok.extern.log4j.Log4j;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

@Log4j
public class JodaTimeTest {

    private static final String DATETIME_STR = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_STR = "yyyy-MM-dd";

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        log.info(localDate.getChronology());
        log.info(localDate.toDate());

        log.info(localDate.toString(DATE_STR));


        LocalDateTime localDateTime = new LocalDateTime();
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATETIME_STR);
        dtf.withZone(DateTimeZone.forID("Asia/Shanghai"));
        log.info(localDateTime.toString(dtf));
    }
}
