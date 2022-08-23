package mytest.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindFirstNonNullPropertyTest {
    public static void main(String[] args) {
        List<MCC> testList = new ArrayList<>();
        MCC mcc1 = new MCC("1", "Approved", "");
        MCC mcc2 = new MCC("2", "Denied", "2022-03-12");
        MCC mcc3 = null;
        MCC mcc4 = new MCC("4", "Approved", null);
        MCC mcc5 = new MCC("5", "Approved", "2022-03-14");
        MCC mcc6 = new MCC("6", "Approved", "2022-03-18");

        testList.add(mcc1);
        testList.add(mcc2);
        testList.add(mcc3);
        testList.add(mcc4);
        testList.add(mcc5);
        testList.add(mcc6);

//        System.out.println("captureTime " + testList.stream()
//                .filter(Objects::nonNull)
//                .map(MCC::getCaptureTime)
//                .filter(StringUtils::isNotBlank)
//                .findFirst()
//                .orElse(null));

        String captureTime = testList.stream()
                .filter(Objects::nonNull)
                .filter(sba -> StringUtils.isNotBlank(sba.getCaptureTime()) && "Approved".equalsIgnoreCase(sba.getStatus()))
                .findFirst()
                .map(MCC::getCaptureTime)
                .orElse(null);

        System.out.println("captureTime " + captureTime);
    }

    @Test
    public void testFindFirstNonNullProperty () {
        List<MCC> testList = new ArrayList<>();
        MCC mcc1 = new MCC("1", "Approved", "");
        MCC mcc2 = new MCC("2", "Denied", "2022-03-12");
        MCC mcc3 = null;
        MCC mcc4 = new MCC("4", "Approved", null);
        MCC mcc5 = new MCC("5", "Approved", "2022-03-14");
        MCC mcc6 = new MCC("6", "Approved", "2022-03-18");

        testList.add(mcc1);
        testList.add(mcc2);
        testList.add(mcc3);
        testList.add(mcc4);
        testList.add(mcc5);
        testList.add(mcc6);

        String captureTime = testList.stream()
                .filter(Objects::nonNull)
                .filter(sba -> StringUtils.isNotBlank(sba.getCaptureTime()) && "Approved".equalsIgnoreCase(sba.getStatus()))
                .findFirst()
                .map(MCC::getCaptureTime)
                .orElse(null);
        Assert.assertEquals("2022-03-14", captureTime);
    }
}

@Data
@AllArgsConstructor
class MCC {
    String id;
    String status;
    String captureTime;
}
