package wiki.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by chen on 2020/7/22.
 */
public class NIOServer {
    public static void main(String[] args) throws Exception{
        Selector serverSelector = Selector.open();
        Selector clientSelector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        new Thread(()->{
            try {
                serverSocketChannel.socket().bind(new InetSocketAddress("127.0.0.1", 8080));
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while (true) {
                    serverSelector.select();//阻塞方法，等待新的连接
                    Set<SelectionKey> selectionKeys = serverSelector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey next = iterator.next();
                        if (next.isAcceptable()) {
                            SocketChannel channel =((ServerSocketChannel) next.channel()).accept();
                            channel.configureBlocking(false);
                            channel.register(clientSelector, SelectionKey.OP_READ);
                            iterator.remove();
                        }
                    }
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }).start();

        new Thread(()->{
            while (true) {
                try {
                    //批量轮询是否哪些连接可读
                    if (clientSelector.select(1) > 0) {//todo 为什么加上这个判断就可以了
                        clientSelector.select();
                        Set<SelectionKey> selectionKeys = clientSelector.selectedKeys();
                        Iterator<SelectionKey> iterator = selectionKeys.iterator();
                        while (iterator.hasNext()) {
                            SelectionKey next = iterator.next();
                            if (next.isReadable()) {
                                SocketChannel channel = (SocketChannel) next.channel();
                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                channel.read(buffer);
                                buffer.flip();
                                System.out.println(Charset.defaultCharset().newDecoder().decode(buffer)
                                        .toString());
                                iterator.remove();
                                next.interestOps(SelectionKey.OP_READ);
                            }
                        }
                    }
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        }).start();
    }
}
