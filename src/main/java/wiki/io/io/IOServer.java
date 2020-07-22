package wiki.io.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by chen on 2020/7/22.
 */
public class IOServer {
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                try {
                    //阻塞方法获取新的连接
                    Socket accept = serverSocket.accept();
                    byte[] data = new byte[1024];
                    int len=0;
                    InputStream in = accept.getInputStream();
                    while ((len = in.read(data)) != -1) {
                        System.out.println(new String(data));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
    }
}
