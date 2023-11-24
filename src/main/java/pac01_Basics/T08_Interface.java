package pac01_Basics;

/**
 * @author TFC
 * @date   2019年6月15日 下午1:11:48
 * @note   接口: 一种公共的规范标准
 *
 * 1.接口类似于抽象类，比抽象类更抽象，不提供任何实现的方法
 * 2.接口主要用于定义一种规范
 * 3.实现(规范)和(具体实现)的分离
 * 4.可实现多个继承
 * 5.默认接口为public(在单独的文本内)或默认(在一个类里面)
 * 6.默认常量public static final 修饰
 * 7.接口方法是 public abstract 修饰
 *
 */
public class T08_Interface implements inter1,inter2{

	@Override	//第一个接口的方法
	public void showDetail() {
		System.out.println("name:"+NAME);
		System.out.println("age:"+AGE);
	}
	@Override	//第二个接口的方法
	public void secondMethod() {
		
	}
	public static void main(String[] args) {

		T08_Interface t=new T08_Interface();
		t.showDetail();
		
	}
}

interface inter1{
	int AGE=20;	//是静态常量
	String NAME="TFC";
	void showDetail();
}

interface inter2{
	void secondMethod();
}