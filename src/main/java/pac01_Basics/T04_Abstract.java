package pac01_Basics;

/**
 * @author TFC
 * @date   2019年6月12日 下午11:18:31
 * @note   abstract关键字; 抽象类
 *
 * 1.类抽象的方法未被实现
 * 2.抽象类用于子类继承
 * 3.为子类提供一个模板，在子类中必须实现
 * 4.抽象类方法须在子类里实现
 *
 */
public abstract class T04_Abstract {

	abstract public void shout();
	
	public static class TestAbstract2 extends T04_Abstract{
		//继承后自动添加的方法
		@Override
		public void shout() {
		}

	}
}
