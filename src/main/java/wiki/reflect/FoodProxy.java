package wiki.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by chen on 2020/7/8.
 */
public class FoodProxy implements InvocationHandler {
    private Object proxy;

    public Object getInstance(Object target) {
        this.proxy=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{Food.class}, this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        System.out.println("方法调用前");
        int num = (int) args[0];
        args[0]=++num;
        result = method.invoke(this.proxy, args);
        System.out.println("方法调用后");
        return result;
    }
}
