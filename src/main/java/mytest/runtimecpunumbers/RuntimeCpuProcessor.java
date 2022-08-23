package mytest.runtimecpunumbers;

public class RuntimeCpuProcessor {
    public static final int SIXTEEN = 16;
    public static final int BATCH_LIMIT_SIZE = Runtime.getRuntime().availableProcessors() * 2 > SIXTEEN ? SIXTEEN : Runtime.getRuntime().availableProcessors() * 2 ;

    public static void main(String[] args) {
        System.out.println(BATCH_LIMIT_SIZE);
    }
}
