package alg;

/**
 * Created by chen on 2019/8/22.
 */
public class Demo {

    public static void main(String[] args) {

        SingleLink<String> singleLink = new SingleLink<String>(new String[]{"1", "2", "2","3", "4","5"});
//        System.out.println(singleLink.getLinkValue(singleLink.insertLink(new String[]{"1", "2", "3", "4"})));
//        System.out.println(singleLink.isCircleString(new String[]{"1", "2", "3", "4","5","4","3","2","1"}));
        singleLink.deleteNode("3");
        singleLink.printAll();
    }
}
