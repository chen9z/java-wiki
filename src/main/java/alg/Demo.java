package alg;

import java.util.Arrays;

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

        String s = "ss";
    }

    public int minimumLengthEncoding(String[] words) {
        int len=words.length;
        String [] revWords=new String[len];
        for(int i=0;i<len;i++){
            revWords[i]=new StringBuilder(words[i]).reverse().toString();
        }
        Arrays.sort(revWords);
        int res=0;
        for(int i=0;i<len-1;i++){
            if(!revWords[i+1].startsWith(revWords[i])){
                res+=revWords[i].length()+1;
            }
        }
        return res;
    }
}
