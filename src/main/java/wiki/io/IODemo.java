package wiki.io;

import java.io.*;

/**
 * Created by chen on 2020/7/21.
 */
public class IODemo {


    public void writeFile(String name) throws IOException {
        OutputStream outputStream = new FileOutputStream(name);
        StringBuilder builder = new StringBuilder();
        builder.append("this is source.\n").append("这是源文件");
        byte[] bytes = builder.toString().getBytes();
        outputStream.write(bytes);
        outputStream.close();
    }
    public void copyFile(String source, String target) throws IOException {
        InputStream inputStream = new FileInputStream(source);
        OutputStream outputStream = new FileOutputStream(target);
        byte[] b = new byte[1024];
        int len;
        while ((len=inputStream.read(b))>-1) {
            outputStream.write(b,0,len);
        }
        inputStream.close();
        outputStream.close();
    }
}
