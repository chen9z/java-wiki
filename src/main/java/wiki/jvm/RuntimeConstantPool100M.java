package wiki.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args:-Xmx6m -Xms6m
 * Created by chen on 2020/6/23.
 */
public class RuntimeConstantPool100M {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i=0;
        while (true) {
            list.add(String.valueOf(++i).intern());
        }
    }
}
