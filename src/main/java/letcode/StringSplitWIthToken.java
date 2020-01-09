package letcode;

import org.apache.log4j.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSplitWIthToken {
    private final Logger logger = Logger.getLogger(StringSplitWIthToken.class);

    public Object[] split(String input, String[] tokens) {
        List<String> stringsList = new ArrayList<String>();

        while(tokens.length>0) {
            int lastIndex = tokens.length;
            List<String> tempList = Arrays.asList(input.split(tokens[lastIndex-1]));
            for(int i=0; i< tempList.size(); i++){
                split(tempList.get(i), Arrays.copyOf(tokens, tokens.length - 1));
            }
        }

        logger.info("test in log4j");

        return stringsList.toArray();
    }

    public static void main(String[] args) {

        StringSplitWIthToken splitToken = new StringSplitWIthToken();

        splitToken.split( "abc,def.ghi", new String[]{"ef", "c"});

    }
}
