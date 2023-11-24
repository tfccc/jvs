package bean;

import java.io.Serializable;

import lombok.ToString;
import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;

/**
 * @author TFC
 * @date   2019年7月11日 下午5:59:38
 * @note   bean(调用使用、注解测试)
 */
@ToString
@Annotation01("anno_student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Annotation02(columnName = "name", length = 10, type = "String")
	private String name;
	@Annotation02(columnName = "age", length = 5, type = "int")
	private int age;
	
	public Student() {	
	}
	
	public Student(String name,int age) {
		this.age=age;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
