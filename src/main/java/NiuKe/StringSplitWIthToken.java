package NiuKe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitWIthToken {

    public static String[] split(String input, String[] tokens) {
        List<String> stringsList = new ArrayList<String>();

        for(int i=0; i<tokens.length; i++){

        }

        while(tokens.length>0) {
            int lastIndex = tokens.length;
            List<String> tempList = Arrays.asList(input.split(tokens[lastIndex-1]));
            for(int i=0; i< tempList.size(); i++){
                split(tempList.get(i), Arrays.copyOf(tokens, tokens.length - 1));
            }

        }

        return (String[]) stringsList.toArray();
    }

    public static void main(String[] args) {

        System.out.println(StringSplitWIthToken.split( "abc,def.ghi", new String[]{"ef", "c"}));

    }
}
