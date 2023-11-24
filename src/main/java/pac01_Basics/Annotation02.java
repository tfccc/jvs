package pac01_Basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author TFC
 * @date   2019��8��10�� ����1:42:06
 * @note   �Զ���ע��02 (src/JavBean/Student.java)
 * 
 * ����:
 *	 1.����ע��
 *	 2.������ʹ��ע��
 *	 3.�ý���������д���
 * 
 */

@Target ({ElementType.FIELD, ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
public @interface Annotation02 {
	String columnName();
	String type();
	int length();
}
