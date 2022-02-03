package mytest.streamobjectconvert;

import lombok.Data;

@Data
public class OriginalBean {
    private String originStrA;
    private String originStrB = "addressB";
    private int count;
}
