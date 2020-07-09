package wiki.reflect;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by chen on 2020/7/8.
 */
public class ProxyTest {
    public static void main(String[] args) {
//        FoodProxy foodProxy = new FoodProxy();
//        Apple apple = new Apple();
//        Food instance = (Food) foodProxy.getInstance(apple);
//        instance.eatMore(3);
//        dynamicProxy();
        cgProxy();
    }

    public static void dynamicProxy() {
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                System.out.println("代理前");
                System.out.println("代理后");
                return proxy;
            }
        };
        Food food = (Food) Proxy.newProxyInstance(handler.getClass().getClassLoader(), new Class[]{Food.class}, handler);
        food.eat();
    }

    public static void cgProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> null);
        Student student = (Student) enhancer.create();
        student.hello();
    }
}
