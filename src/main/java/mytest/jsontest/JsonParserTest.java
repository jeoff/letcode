package mytest.jsontest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParserTest {

    public static void main(String[] args) throws IOException {
        String jsonStr = "{\"permanent_code\":\"u-3BibvmCTByyJ2yLMCKLIbFbsu8h9ezhOQXgy6qdIM\",\"auth_corp_info\":{\"corpid\":\"ww8737337b606d5b0c\",\"corp_name\":\"Veeva\",\"corp_type\":\"verified\",\"corp_round_logo_url\":\"http://p.qpic.cn/pic_wework/2450458963/4f49ea47d20fcd2f55d720516c3c1100ff1c300049044804/0\",\"corp_square_logo_url\":\"https://p.qlogo.cn/bizmail/HfXup8LiacWtpyXrtnVdKCwlibGq84JXVB82m5E2oyqFLLwanlz9ibA5g/0\",\"corp_user_max\":1000,\"corp_wxqrcode\":\"https://wework.qpic.cn/wwpic/595249_8AFRIB-TQu-MlTP_1641879663/0\",\"corp_full_name\":\"维我软件(上海)有限公司\",\"subject_type\":1,\"verified_end_time\":1648708772,\"corp_scale\":\"101-200人\",\"corp_industry\":\"IT服务\",\"corp_sub_industry\":\"计算机软件/硬件/信息服务\",\"location\":\"\"},\"auth_info\":{\"agent\":[{\"agentid\":1000043,\"name\":\"MetaVeeva\",\"square_logo_url\":\"https://wework.qpic.cn/bizmail/nZF2PeAqHc0hAwpo01XVT5DibW519lCLD6s7VliakNkp9SFchsZpgkRg/0\",\"privilege\":{\"level\":0,\"allow_party\":[],\"allow_user\":[],\"allow_tag\":[],\"extra_party\":[],\"extra_user\":[],\"extra_tag\":[]},\"is_customized_app\":true}]},\"auth_user_info\":{\"userid\":\"chaofeng.zhou@veeva.com\",\"name\":\"周超峰\",\"avatar\":\"http://wework.qpic.cn/bizmail/crJia5QKShk6uRaGouRBibWiaK7ibPRjotHGOICrJV2zaCMq2SnVzzHV2A/0\",\"open_userid\":\"wo9iF-CgAAzi3xqRsxCS1zJlG18lzoug\"}}";
        ObjectMapper objectMapper = new ObjectMapper();

        PermanentCodeInfo test = objectMapper.readValue(jsonStr, PermanentCodeInfo.class);
        System.out.println(test);


        List testList = new ArrayList();
        System.out.println(CollectionUtils.isNotEmpty(testList));
    }
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class AuthInfo {
    List<AgentInfo> agent;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class AgentInfo {
    @JsonProperty("agentid")
    String agentId;
    String name;
    @JsonProperty("is_customized_app")
    Boolean isCustomizedApp;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class CorpInfo {
    @JsonProperty("corpid")
    String corpId;
    @JsonProperty("corp_full_name")
    String corpFullName;
}

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
class PermanentCodeInfo {
    @JsonProperty("permanent_code")
    String permanentCode;
    @JsonProperty("auth_corp_info")
    CorpInfo authCorpInfo;
    @JsonProperty("auth_info")
    AuthInfo authInfo;
}
