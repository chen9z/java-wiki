package wiki.jvm;

/**
 * vm args:-xss128k
 * Created by chen on 2020/6/23.
 */
public class JavaVmStackSOF {

    private  int stackLength = 0;

    protected  void increase() {
        stackLength++;
        increase();
    }

    public static void main(String[] args) {
        JavaVmStackSOF javaVmStackSOF = new JavaVmStackSOF();
        javaVmStackSOF.increase();
        try {

        } catch (Error e) {
            System.out.println(javaVmStackSOF.stackLength);
        }

    }
}
