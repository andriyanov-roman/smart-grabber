package smartgrabber.examples.reflect;

import java.lang.reflect.Field;

/**
 * Created by randriyanov on 25.10.15.
 */
public class UserAnalyzer {
    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("Ivan");
        Class clazz = user.getClass();
        Field field = clazz.getDeclaredField("name");
        NameValidation myAnnotation = field.getAnnotation(NameValidation.class);
        if(user.getName().length() != myAnnotation.nameLength()) {
            throw new Exception();
        }
    }
}
