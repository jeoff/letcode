package mytest.enumtest;

import org.apache.commons.lang3.EnumUtils;

import javax.annotation.Nullable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnumContainsTest {
    public static void main(String[] args) {
        String trueValue = "ALERT_VERIFICATION";
        String falseValue = "CFZ";
        String fzzzValue = WeChatAlertType.ALERT_SEND_ACCEPT.toString();

        System.out.println(trueValue + " " + EnumUtils.isValidEnum(WeChatAlertType.class, trueValue));
        System.out.println(falseValue + " " + EnumUtils.isValidEnum(WeChatAlertType.class, falseValue));
        System.out.println(fzzzValue + " " + EnumUtils.isValidEnum(WeChatAlertType.class, fzzzValue));

        System.out.println(SalesforceObject.Account);

        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssMs")));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddhhmmssMs")).length());
    }
}

enum WeChatAlertType {

    ALERT_VERIFICATION_SUBSCRIBE("医生认证并关注提醒","您的客户{0}已成功通过微信认证并关注服务号{1}，可以开始推送消息。\n点击详情查看 >>"),
    ALERT_VERIFICATION("医生认证提醒","您的客户{0}已成功通过微信认证，但未有关注服务号{1}，请提醒客户关注服务号，然后才可以推送消息。"),
    ALERT_SEND_ACCEPT("{0}刚刚把你添加为好友，点击下方链接完成医生绑定","{0} 你好\n你的微信好友已经添加成功"),
    ALERT_SEND_REJECT("{0}已拒绝服务条款",""),
    ALERT_SEND_AUTO_BIND("{0}刚刚把你添加为好友，并已完成自动绑定","{0}，你好<br/>你的微信好友已添加成功<br/><br/><div class=\"gray\">医生姓名：{1}</div>");
    String title;
    String content;
    WeChatAlertType(String title, String content)
    {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }


    public String getContent() {
        return content;
    }

}

enum SalesforceObject {
    Account();

    private SalesforceObject() {
    }

    public boolean is(String stringValue) {
        return this.toString().equals(stringValue);
    }

    public boolean isEqualIgnoreCase(String stringValue) {
        return this.toString().equalsIgnoreCase(stringValue);
    }

    @Nullable
    public static SalesforceObject fromString(@Nullable String stringValue) {
        SalesforceObject obj = null;
        if (stringValue != null) {
            try {
                obj = valueOf(stringValue);
            } catch (IllegalArgumentException var3) {
                obj = null;
            }
        }

        return obj;
    }
}
