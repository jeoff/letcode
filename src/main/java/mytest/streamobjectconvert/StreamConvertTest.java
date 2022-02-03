package mytest.streamobjectconvert;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class StreamConvertTest {
    public static void main(String[] args) {
        OriginalBean org = new OriginalBean();
//        OriginalBean org = null;
        DestBean dest = new DestBean();

//        Optional.ofNullable(org).forEach(x -> {
//            dest.setName(x.getOriginStrA());
//            dest.setAddress(x.getOriginStrB());
//            //return "";
//        });

        Optional.ofNullable(org).ifPresent( o -> {
            dest.setName(o.getOriginStrA());
            dest.setAddress(o.getOriginStrB());
            }
        );

//        Optional.ofNullable(org).map(o -> dest[0] = new DestBean(StringUtils.isNotBlank(o.getOriginStrA()) ? o.getOriginStrA(): "", StringUtils.isNotBlank(o.getOriginStrB()) ? o.getOriginStrB(): ""))
//                .orElse(new DestBean("", ""));

        System.out.println(dest.toString());


    }
}
