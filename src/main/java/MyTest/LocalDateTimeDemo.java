package mytest;

import org.apache.log4j.Logger;

import java.time.*;


public class LocalDateTimeDemo {

    private static final Logger logger = Logger.getLogger(LocalDateTimeDemo.class);

    public static void main(String[] args) {

        LocalDateTimeDemo dateTimeDemo = new LocalDateTimeDemo();

        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime dt = LocalDateTime.now();

        logger.info(ld.toString());
        logger.info(lt.toString());
        logger.info(dt.toString());

        LocalDateTime firstDay = LocalDate.now().withDayOfMonth(1).atStartOfDay();
        logger.info(firstDay);

        //Print default zoneId
        logger.info("System default zoneId: " + ZoneId.systemDefault());

        //Print NewYork time
        LocalDateTime ldt = LocalDateTime.now();

        ZonedDateTime dft = ldt.atZone(ZoneId.systemDefault());

        //convert zoned date time to specific local time
        ZonedDateTime nyt = dateTimeDemo.convertTargetZoneID(dft, ZoneId.of("America/New_York"));

        logger.info(ldt);
        logger.info(dft);
        logger.info(nyt);
        logger.info(nyt.toLocalDateTime());

        ZonedDateTime departureAtBeijing = LocalDateTime.of(2020, 1, 13, 17, 00).atZone(ZoneId.systemDefault());
        ZonedDateTime arrivedAtNewYork = dateTimeDemo.getNYDateTime(departureAtBeijing, ZoneId.of("America/New_York"), 13, 50);
        logger.info("Arrive at NewYork datetime: " + arrivedAtNewYork.toLocalDateTime());

        logger.info(Instant.now().getEpochSecond());

    }

    /**
    *Practice, 某航线从北京飞到纽约需要13小时50分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
     */
    private ZonedDateTime getNYDateTime(ZonedDateTime startLocaleTime, ZoneId targetZone, int hours, int minutes) {
        return startLocaleTime.plusHours(hours).plusMinutes(minutes).withZoneSameInstant(targetZone);
    }

    /**
     * 转换指定时区时间
     */
    private ZonedDateTime convertTargetZoneID(ZonedDateTime datetime, ZoneId targetZoneId) {
        return datetime.withZoneSameInstant(targetZoneId);
    }

}

