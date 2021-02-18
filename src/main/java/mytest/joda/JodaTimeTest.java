package mytest.joda;

import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.stream.Collectors;

@Log4j
public class JodaTimeTest {

    private static final String DATETIME_STR = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_STR = "yyyy-MM-dd";

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        log.info(localDate.getChronology());
        log.info(localDate.toDate());

        log.info(localDate.toString(DATE_STR));

        // 列出所有DateTimeZone
        log.info(DateTimeZone.getAvailableIDs());
        // 列出Asia DateTimeZone
        log.info(DateTimeZone.getAvailableIDs().stream().filter(item -> item.indexOf("Asia") > -1 && item.indexOf("Shanghai") > -1).collect(Collectors.toSet()));

        // 将字符串表示的时间转换成另一个时区的时间字符串
        // 1.将字符串按原时区转换成Date对象；
        // 2.将Date对象格式化成目标时区的时间。
        // 世界时钟, https://24timezones.com/map_zh.php#/map

        // 字面时间
        String timeStr = "2017-8-24 11:17:10";
        DateTimeFormatter bjSdf = DateTimeFormat.forPattern(DATETIME_STR);
        bjSdf.withZone(DateTimeZone.forID("Asia/Shanghai"));
        // 将字符串时间按北京时间解析成Date对象
        DateTime fromDateTime = bjSdf.parseDateTime(timeStr);
        // 东京
        DateTimeFormatter tokyoSdf = DateTimeFormat.forPattern(DATETIME_STR);
        // 设置东京时区
        tokyoSdf.withZone(DateTimeZone.forID("Asia/Tokyo"));
        log.info("北京指定时间: " + fromDateTime.toString(DATETIME_STR) + " 对应的东京时间为:" + tokyoSdf.print(fromDateTime.toDateTime(DateTimeZone.forID("Asia/Tokyo"))));

        // 将当前时间解析成东京时间
        // DateTime bjNowDt = new LocalDateTime(DateTime.now()).toDateTime();
        // log.info("北京现在时间: " + bjNowDt.toString(DATETIME_STR) +" 对应的东京时间为:"  + tokyoSdf.print(bjNowDt.toDateTime(DateTimeZone.forID("Asia/Tokyo"))));
        DateTime bjNowDt = LocalDateTime.now().toDateTime();
        log.info("北京现在时间: " + bjNowDt.toString(DATETIME_STR) + " 对应的东京时间为:" + bjNowDt.toDateTime(DateTimeZone.forID("Asia/Tokyo")).toString(DATETIME_STR));

        LocalDateTime localDateTime = new LocalDateTime();
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATETIME_STR);
        dtf.withZone(DateTimeZone.forID("Asia/Shanghai"));
        log.info(localDateTime.toString(dtf));

        // 获取当前默认的时区
        DateTimeZone now = DateTimeZone.getDefault();
        log.info("默认时区 " + now);

        // 都是构造+08:00时区
        DateTimeZone beijing = DateTimeZone.forID("+08:00");
        DateTimeZone shanghai = DateTimeZone.forID("Asia/Shanghai");
        log.info("北京时区 " + beijing);
    }
}
