import org.junit.Test;
import wiki.annotation.Apple;
import wiki.annotation.FruitName;

import java.lang.reflect.Field;

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
}
