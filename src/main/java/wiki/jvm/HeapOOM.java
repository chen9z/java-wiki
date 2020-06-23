package wiki.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * vm args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * Created by chen on 2020/6/23.
 */
public class HeapOOM {

    static class ClassObject{

    }

    public static void main(String[] args) {
        List<ClassObject> list = new ArrayList<>();
        for (; ; ) {
            list.add(new ClassObject());
        }
    }
}
