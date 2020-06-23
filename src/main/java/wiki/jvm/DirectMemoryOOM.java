package wiki.jvm;

/**
 * VM Args: -Xmx20m -XX:MaxDirectMemorySize=10m
 * Created by chen on 2020/6/23.
 */
public class DirectMemoryOOM {

    private static final long _1MB=1024*1024;

//    public static void main(String[] args) throws Exception {
//        Field declaredField = Unsafe.class.getDeclaredFields()[0];
//        declaredField.setAccessible(true);
//        Unsafe unsafe = (Unsafe) declaredField.get(null);
//        while (true) {
//            unsafe.allocateMemory(_1MB);
//        }
//    }
}
