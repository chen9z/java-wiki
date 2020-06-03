package alg.test;

import java.util.Stack;

/**
 * 394
 * Created by chen on 2020/5/28.
 */
public class DecodeStringTest {

    /**
     * todo
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<String> ss=new Stack<>();
        Stack<Integer> si=new Stack<>();
        StringBuilder builder=new StringBuilder();
        int i=0;
        Character chr;
        while(i<s.length()){
            chr=s.charAt(i);
            if(Character.isDigit(chr)){
                si.add(getDigit(s,i));
            }else if(chr==']'){
                StringBuilder bd = new StringBuilder("");
                while (!si.isEmpty()) {
                    for (int j = 0; j < si.size(); j++) {
                    }
                }

            }else{
            }
            i++;
        }
        return null;
    }

    public int getDigit(String s,int i){
        StringBuilder builder=new StringBuilder("");
        while(Character.isDigit(s.charAt(i))){
            builder.append(s.charAt(i));
            i++;
        }
        return Integer.parseInt(builder.toString());
    }
}
