package pac02_Advance;

import lombok.Data;
import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

/**\
 * @author TFC
 * @date 2019��8��12�� ����2:34:43
 * @note ����02: �����ȡע��
 *
 * 1.�������ע��
 * 2.������ָ��ע��
 * 3.��ȡ�����Ե�ע��
 *
 */
public class T06_ReflectionGetAnno {

    public static void main(String[] args) throws NoSuchFieldException, SecurityException {
        Class<?> stu = Student.class;

        //1.�������ע��
        Annotation[] annos = stu.getAnnotations();
        for (Annotation an : annos) {
            if (an instanceof Data) {
                System.out.println("lombok");
            }
            System.out.println(an);
        }

        //2.������ָ��ע��
        Annotation01 anno01 = stu.getAnnotation(Annotation01.class);
        System.out.println(Arrays.toString(anno01.value()));

        //3.��ȡ�����Ե�ע��
        Field field = stu.getDeclaredField("age");
        Annotation02 anno02 = field.getAnnotation(Annotation02.class);
        System.out.println(anno02.columnName() + "/"
                + anno02.length() + "/" + anno02.type());
    }
}
