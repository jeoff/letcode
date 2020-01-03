public class StringImmutableDemo {

    public static void main(String[] args) {

       /* String str = "badText1231";
        System.out.println("str: " + str);
        str = StringImmutableDemo.replaceBadWithGood(str);
        System.out.println("str: " + str);
        str = StringImmutableDemo.replaceBadWithGood2(str);
        System.out.println("str: " + str);*/

        for(int a = 0 ; a< 18; a++){
            stopHere:
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 20; c++){
                    System.out.println("a "+a + " ,b "+b +" ,c "+c);
                    if(c==1) break stopHere;
                }
            }
        }


    }


    /**
     * DON"T DO THIS. DOESN'T WORK.
     */
    private static String replaceBadWithGood(String value) {
        if (value == null) {
            return null;
        }
        String temp = value;
        temp.replace("badText","goodText");
        System.out.println("temp: "+ temp);
        return temp;
    }

    /**
     * MUCH SIMPLER, AND WORKS
     */
    private static String replaceBadWithGood2(String value) {
        if (value == null) {
            return null;
        }
        return value.replace("badText", "goodText");
    }
}
