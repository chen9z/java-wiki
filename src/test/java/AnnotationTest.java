import org.junit.Test;
import wiki.annotation.Apple;
import wiki.annotation.FruitName;

import java.lang.reflect.Field;
import java.time.Instant;
import java.util.HashMap;

/**
 * Created by chen on 2020/7/17.
 */
public class AnnotationTest {

    @Test
    public void func1() {

        Field[] declaredFields = Apple.class.getDeclaredFields();
        for (Field f : declaredFields) {
            if (f.isAnnotationPresent(FruitName.class)) {
                FruitName annotation = f.getAnnotation(FruitName.class);
                System.out.println(annotation.name());
            }
        }
    }

    @Test
    public void func2() {
        String str = "1341414312.jpg";
        int i = str.lastIndexOf(".");

        System.out.println(Instant.now().toEpochMilli()+str.substring(i));

        System.out.println(Math.random()*100);
    }
}
