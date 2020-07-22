package wiki.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by chen on 2020/7/21.
 */
public class NIODemo {

    public void writeFile(String name){
        FileChannel fileChannel=null;
        try {
//            fileChannel=new FileOutputStream(name).getChannel();
            RandomAccessFile file = new RandomAccessFile(name, "rw");
            fileChannel=file.getChannel();
            StringBuilder builder = new StringBuilder();
            builder.append("this is nio source.\n").append("这是个nio的源文件");
            ByteBuffer buffer = ByteBuffer.wrap(builder.toString().getBytes());
            fileChannel.write(buffer);
            buffer.clear();
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void copyFile(String source, String target) {
        FileChannel inChannel = null;
        FileChannel outChannel=null;
        try {
            inChannel=new FileInputStream(source).getChannel();
            outChannel=new FileOutputStream(target).getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer) != -1) {
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * 使用buffer解析网络请求数据流
     * @param channel
     * @throws IOException
     */
    public void readHttpBuffer(SocketChannel channel) throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = new ByteBuffer[]{header, body};
        channel.read(bufferArray);
    }
}
