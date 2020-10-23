package mytest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calender {

    public static void main(String[] args) {
        /*Calendar 的 getInstance 方法返回一个 Calendar 对象，其日历字段已由当前日期和时间初始化*/
        Calendar cal = Calendar.getInstance();
        /*获取一周七天的值*/
        for(int a = 0 ; a< 7; a++){
            /*获取当前日历的日期的星期数（1:星期天）*/
            int week_index = cal.get(Calendar.DAY_OF_WEEK);
            Date date=cal.getTime();
            /*日期格式化 yyyy-MM-dd M必须大写*/
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);

            System.out.println(week_index+","+dateString);

            /*将日历日期推后1天*/
            cal.add(Calendar.DATE,1);
        }
    }


}
