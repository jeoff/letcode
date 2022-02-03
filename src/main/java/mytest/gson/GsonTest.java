package mytest.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.extern.log4j.Log4j;

import java.util.LinkedHashMap;

@Log4j
public class GsonTest {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        LinkedHashMap<String, Object> textMap = new LinkedHashMap<>();
        Article article = new Article();
        article.setTitle("cfTitle");
        article.setDescription("cfDescription");
        article.setOther("");
        textMap.put("touser", "@all");

        textMap.put("msgtype", "textcard");
        textMap.put("agentid", "agentid");
        textMap.put("textcard", article);
        String messageBody = gson.toJson(textMap);
        log.info("wechat message body:" + messageBody);
    }
}

@Data
class Article {
    private String title;
    private String description;
    private String other;
}
