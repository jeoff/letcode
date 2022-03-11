package mytest.list;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListJoinTest {

    public static void main(String[] args) {
        List<String> users = new ArrayList<>();
        users.add("Tom");
        System.out.println(StringUtils.join(users, "|"));
        users.add("Jerry");
        System.out.println(StringUtils.join(users, "|"));
    }
}
