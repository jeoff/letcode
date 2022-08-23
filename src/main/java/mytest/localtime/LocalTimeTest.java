package mytest.localtime;


import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class LocalTimeTest {
    public static void main(String[] args) {
        DateTime localTime = new DateTime("2022-04-13T12:50:00.000Z", DateTimeZone.UTC);
        System.out.println(localTime);

        int callBackDateLimit = 2;
        DateTime compareTime = DateTime.now(DateTimeZone.UTC).withTimeAtStartOfDay().minusDays(callBackDateLimit);
        System.out.println(compareTime);

        System.out.println(localTime.isBefore(compareTime));
    }
}
