package wiki.io.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * Created by chen on 2020/7/22.
 */
public class IOClient {

    public static void main(String[] args) {
        new Thread(()->{
            try {
                Socket socket = new Socket("127.0.0.1", 8080);
                while (true) {
                    Thread.sleep(1000);
                    socket.getOutputStream().write((new Date() + " hello world!").getBytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }).start();
    }
}
