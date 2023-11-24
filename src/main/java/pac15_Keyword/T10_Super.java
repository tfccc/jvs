package pac15_Keyword;

/**
 * @author TFC
 * @date   2019年6月13日 下午6:23:37
 * @note   super关键字测试
 */
public class T10_Super {

	class Father{
		public int age;
		void showAge() {
			age=40;
			System.out.println("父亲的年龄:"+age);
		}
	}
	
	class Son extends Father{
		private int age;
		void showAge() {
			//调用父类对象的方法(super.showage()相当于直接用父类的方法)
			super.showAge();
			age=18;
			System.out.println("儿子的年龄:"+age);
			//super.age调用父类成员变量
			System.out.println("通过super访问父亲的年龄:"+super.age);
		}
	}
	
	public static void main(String[] args) {
		//内部类调用，没有外部类作为实例将无法访问内部类
		T10_Super tSuper=new T10_Super();
		Father father=tSuper.new Father();
		father.showAge();
		
		T10_Super tSuper2=new T10_Super();
		Son son=tSuper2.new Son();
		son.showAge();
	}
}
