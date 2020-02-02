package letcode;

import org.apache.log4j.Logger;

/**
 * Occurrences of substring in a string
 */
public class CountOccurences {

    public static void main(String[] args) {
        String str = "helloslkhellodjladfjhello";
        String findStr = "hello";

        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1) {
            lastIndex = str.indexOf(findStr, lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex = lastIndex + findStr.length();
            }
        }

        Logger.getLogger(CountOccurences.class).info(count);
    }
}
