package wiki.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * Created by chen on 2020/7/22.
 */
public class NIOClient {

    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 8888));
            new Thread(()->{

            }).start();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
