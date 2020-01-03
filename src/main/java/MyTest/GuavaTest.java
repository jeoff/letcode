package MyTest;

import com.google.common.escape.Escaper;
import com.google.common.escape.Escapers;
import org.apache.commons.lang3.StringUtils;

public class GuavaTest {


    public static void main(String[] args) {

        //String apWholesalerName = "WS''''Default";
        String apWholesalerName = "WS\\\\Default";
        //String apWholesalerName = null;
        String escapterStr = "";

        Escaper escaper = Escapers.builder()
                .addEscape('\'', "\\'")
                .addEscape('\\', "\\\\")
                .build();
        if (StringUtils.isNotBlank(apWholesalerName)){
            escapterStr = escaper.escape(apWholesalerName);
        }
        System.out.println(escapterStr);
    }
}
