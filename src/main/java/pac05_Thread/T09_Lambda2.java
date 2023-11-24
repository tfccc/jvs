package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月15日 上午10:21:01
 * @note   Lambda表达式,带参、带返回值形式的推导、简化
 */
public class T09_Lambda2 {
	public static void main(String[] args) {

		//方法1:使用接口实现类的方法
		Compare com1=new Comparetor();
		System.out.println(com1.compare(5, 8));

		//方法2:使用Lambda表达式实现
		com1=(a,b)-> {
			System.out.println("a-b="+(a-b));
			return a+b;
		};
		System.out.println("a+b="+com1.compare(4, 2));
	}
}

interface Compare{ int compare(int a,int b); }

class Comparetor implements Compare{

	@Override
	public int compare(int a, int b) {
		return (a-b>0 ? a:b);
	}

}