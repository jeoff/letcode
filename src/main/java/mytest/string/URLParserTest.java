package mytest.string;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class URLParserTest {

    public static void main(String[] args) throws MalformedURLException, URISyntaxException {
        String preAuthUrl = "/spa/account-binding?externalId=%1$s&orgId=%2$s&unionId=%3$s";
        String endUrl = "";

        String url ="https://awec-36-d2-app-ap.veevacrmdev.cn/wechat-crmapp";
        String url2 ="https://awec-36-d2-app-ap.veevacrmdev.cn/wechat-crmapp/";

        System.out.println(url.replace("/wechat-crmapp", "") + preAuthUrl);

        endUrl = url2.endsWith("wechat-crmapp/") ? url2.replace("/wechat-crmapp/", "").concat(preAuthUrl) : url2.replace("/wechat-crmapp", "").concat(preAuthUrl);
        System.out.println(endUrl);

        StringBuilder sb = new StringBuilder();
        sb.append(url2.endsWith("wechat-crmapp/") ? url2.replace("/wechat-crmapp/", "") : url2.replace("/wechat-crmapp", ""));
        sb.append(String.format(preAuthUrl, "z1", "z2", "z3"));

        System.out.println(sb.toString());


        URL aURL= new URL(url2);
        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());


        URL newURL = new URL(aURL.getProtocol(), aURL.getHost(), String.format(preAuthUrl, "z1", "z2", "z3"));
        System.out.println(newURL.toString());

        System.out.println(baseUrl(url2));
    }

    public static String baseUrl(String urlStr) throws MalformedURLException {
        URL url = new URL(urlStr);
        return urlStr.replace(url.getFile(), "").replace("#" + url.getRef(), "");
    }
}
