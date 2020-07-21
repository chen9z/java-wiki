package wiki.io;

import java.io.IOException;

/**
 * Created by chen on 2020/7/21.
 */
public class IOTest {

    public static void main(String[] args) throws IOException {
//        IODemo ioDemo=new IODemo();
//        ioDemo.writeFile("./source.txt");
//        ioDemo.copyFile("./source.txt", "./target.txt");

        NIODemo nioDemo = new NIODemo();
        nioDemo.writeFile("./nio_source.txt");
        nioDemo.copyFile("./nio_source.txt", "./nio_target.txt");
    }

}
