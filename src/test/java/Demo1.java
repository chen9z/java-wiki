import alg.Practice;
import alg.reflect.Student;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by chen on 2020/5/15.
 */
public class Demo1 {

    @Test
    public void func1() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> object = Class.forName("alg.reflect.Student");
        Constructor<?> constructor = object.getConstructor(String.class);
        constructor.newInstance("小王");
        System.out.println(object);
    }

    @Test
    public void func2() throws Exception{
        Class<String> stringClass = String.class;
        Constructor<String> constructor = stringClass.getConstructor(String.class);
        String s = constructor.newInstance("1234");
        System.out.println(s);
        List<List<Integer>> list = new LinkedList<>();
        Queue<Integer> queue=new LinkedList<>();
    }

    @Test
    public void func3() throws Exception{
        Class<Student> studentClass = Student.class;
//        Constructor<Student> constructor = studentClass.getConstructor(String.class);

//        System.out.println(Arrays.toString(studentClass.getMethods()));
//        System.out.println(Arrays.toString(studentClass.getDeclaredMethods()));
//        System.out.println(Arrays.toString(studentClass.getDeclaredFields()));
        Student student = studentClass.getDeclaredConstructor(String.class).newInstance("小明");
        Method hi = studentClass.getDeclaredMethod("hi", String.class);
        hi.setAccessible(true);

        hi.invoke(student, "卡卡罗特");
    }

    @Test
    public void func4() {
        Practice practice = new Practice();

        System.out.println(practice.lengthOfLongestSubstring("abba"));
    }
}
