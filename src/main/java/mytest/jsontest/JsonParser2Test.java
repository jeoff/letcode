package mytest.jsontest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.util.List;

public class JsonParser2Test {


    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        WxBatchUserInfo test = objectMapper.readValue(WeComStringConstants.batchUserResponse, WxBatchUserInfo.class);
        System.out.println(test);
    }
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class WxBatchUserInfo {
    private String errcode;
    private String errmsg;
    private String next_cursor;
    List<WxExternalContactWrapper> external_contact_list;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class WxExternalContactWrapper {
    private WxExternalContact external_contact;
    private WxFollowInfo follow_info;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class WxExternalContact {
    private String external_userid;
    private String name;
    private String corp_name;
    private String corp_full_name;
}


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class WxFollowInfo {
    private String userid;
    private String remark;
}







