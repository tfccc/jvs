package pac01_Basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * @author TFC
 * @date   2019年8月10日 下午12:56:44
 * @note   自定义注解01
 */
@Target (value = {ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
public @interface Annotation01{
	/*String name()  default "tfc" ;
	int age() default 20;
	int []arr() default {1,2,3,4,5};*/
	String []value() default "default value";
	
}
