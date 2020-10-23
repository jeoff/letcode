package mytest;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class JodaDateTimeTest {
    private static final Logger LOG = Logger.getLogger(JodaDateTimeTest.class);

    public static void main(String[] args) {
        String dateStr1 = "2020-12";
        String[] strs = dateStr1.split("-");
        LocalDateTime dateTimeTest = new LocalDateTime(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]), 1, 0, 0, 0, 000);
        LOG.info("dateTimeTest " + dateTimeTest+"Z");


        // Creates an instance of DateTime.
        DateTime dateTime = DateTime.now(DateTimeZone.UTC);

        // Get the last date of the month using the dayOfMonth property
        // and get the maximum value from it.
        DateTime startDate = dateTime.withDayOfMonth(1).minusMonths(3);
        LOG.info("startDate, " + startDate.toString("yyyy-MM-dd")+"T00:00:00.000Z");
        LOG.info("startDate, " + startDate.toString("yyyy-MM-dd'T'HH:mm"));
        DateTime lastDate = dateTime.dayOfMonth().withMaximumValue();
        String lastDateTime = lastDate.toLocalDate().toDateTimeAtStartOfDay(DateTimeZone.UTC).toString("yyyy-MM-dd\'T\'HH:mm:ss.SSS\'Z\'");;
        LOG.info("lastDateTime, " + lastDateTime);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        DateTime date1 = new LocalDate("2019-9-19").toDateTimeAtStartOfDay();
        DateTime date2 = date1.plusDays(1);

        System.out.println(date1);
        System.out.println(date2);

        System.out.println(validateDate("2020-12-12"));


        LocalDate start = new LocalDate();
        LocalDate end = new LocalDate().minusDays(1);
        LOG.info("days between " + Days.daysBetween(start, end).getDays());

        DateTime utcDateTime = new DateTime(DateTimeZone.UTC);
        DateTime utcEndDateTime = utcDateTime.plusHours(25);
        Period period = new Period(utcDateTime, utcEndDateTime);
        LOG.info("period " + period.getMonths());
        LOG.info("utcDateTime " + utcDateTime);
        LOG.info("period  " + period.getDays());


        //DateTime utc1 = new DateTime("2020-09-27T16:00:00.000+08:00").withZone(DateTimeZone.forID("Asia/Shanghai"));
        DateTime utc1 = new DateTime("2020-09-27T16:00:00.000+08:00").withZone(DateTimeZone.UTC);
        LOG.info("utc1 " + utc1);
        DateTime utc2 = utc1.plusHours(24);
        LOG.info("utc2 " + utc2);
        DateTime utc3 = utc2.withZone(DateTimeZone.UTC);
        LOG.info("utc3 " + utc3);
        DateTime utc4 = utc3.withZone(DateTimeZone.forID("Asia/Shanghai"));
        LOG.info("utc4 " + utc4);
    }


    public static boolean validateDate(String dateString){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateString);
            return true;
        } catch (ParseException ex) {
            LOG.error("Parse date error, " , ex);
            return false;
        }
    }
}
