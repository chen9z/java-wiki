package wiki.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by chen on 2020/7/8.
 */
public class ReflectTest {
    public static void main(String[] args) throws Exception{
//        System.out.println(Student.class);
//        System.out.println(Class.forName("wiki.reflect.Student"));
//        System.out.println(new Student().getClass());
//        reflect();
        invokeMethod();
    }

    public static void reflect() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clz = Class.forName("wiki.reflect.Student");
        Constructor<?> constructor = clz.getConstructor();
        Student student = (Student) constructor.newInstance();
        System.out.println(student);

        Method getClass = clz.getMethod("getClass");
        Arrays.stream(clz.getDeclaredConstructors()).forEach(System.out::println);
        Arrays.stream(clz.getDeclaredFields()).forEach(System.out::println);
        Arrays.stream(clz.getMethods()).forEach(System.out::println);
        Arrays.stream(clz.getDeclaredMethods()).forEach(System.out::println);
        System.out.println(clz.getSuperclass());

    }

    public static void invokeMethod() throws Exception{
        Class<?> clz = Class.forName("wiki.reflect.Student");
        System.out.println("isDefault:" + clz.getMethod("hello").isDefault());
        Object o = clz.getConstructor().newInstance();
        Method hello = clz.getDeclaredMethod("hello");
        System.out.println(hello.getName());
        System.out.println(hello.getReturnType().getName());
        System.out.println(hello.getModifiers());
        Arrays.stream(hello.getParameterTypes()).forEach(n -> System.out.println(n.getTypeName()));
        hello.invoke(o);
    }
}
