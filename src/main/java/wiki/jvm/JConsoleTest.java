package wiki.jvm;

import java.util.ArrayList;
import java.util.List;

public class JConsoleTest {

    static class OOMObject{
        public  byte[] placeHolder=new byte[64*1024];
    }

    public static void main(String[] args) throws Exception{
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new OOMObject());
            Thread.sleep(50);
        }
        System.gc();
    }
}
