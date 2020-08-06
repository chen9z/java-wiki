package wiki.thread.singleton;

/**
 * 静态内部类单例
 * Created by chen on 2020/8/6.
 */
public class Instance {

    private static class InstanceHolder{
        private static Instance instance=new Instance();

    }

    public static Instance getInstance() {
        return InstanceHolder.instance;
    }
}
