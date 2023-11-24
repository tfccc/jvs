package pac02_Advance;

import lombok.Data;
import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**\
 * @author TFC
 * @date 2019年8月12日 下午2:34:43
 * @note 反射02: 反射读取注解
 *
 * 1.类的所有注解
 * 2.获得类的指定注解
 * 3.获取类属性的注解
 *
 */
public class T06_ReflectionGetAnno {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        Class<?> stu = Student.class;

        //1.类的所有注解
        Annotation[] annos = stu.getAnnotations();
        for (Annotation an : annos) {
            if (an instanceof Data) {
                System.out.println("lombok");
            }
            System.out.println(an);
        }

        //2.获得类的指定注解
        Annotation01 anno01 = stu.getAnnotation(Annotation01.class);
        System.out.println(Arrays.toString(anno01.value()));

        //3.获取类属性的注解
        Field field = stu.getDeclaredField("age");
        Annotation02 anno02 = field.getAnnotation(Annotation02.class);
        System.out.println(anno02.columnName() + "/"
                + anno02.length() + "/" + anno02.type());
    }
}
