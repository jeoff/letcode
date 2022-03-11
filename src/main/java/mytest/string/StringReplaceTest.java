package mytest.string;

public class StringReplaceTest {

    public static void main(String[] args) {
        //String temp = "系统已为您生成{0}条智能建议，并自动提交{1}条拜访报告，请及时点击查看";
        //String temp = "系统已为您生成条智能建议，并自动提交{2}条拜访报告，请及时点击查看";
        String temp = "";

        int suggestionCount = 0;
        int autoCallCount = 8;

        System.out.println(temp.replace("{0}", String.valueOf(suggestionCount)).replace("{1}", String.valueOf(autoCallCount)));
    }
}
