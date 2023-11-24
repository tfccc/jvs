package pac01_Basics;


/**
 * @author TFC
 * @date   2019年6月13日 下午7:36:40
 * @note   包装类的使用
 */
@SuppressWarnings("all")
public class T10_WrapperClass {

	public static void main(String[] args) {
		//将数据转为包装类对象(3种)
		Integer a=new Integer(3);
		//推荐方法
		Integer b=Integer.valueOf(3);
		//自动装箱(相当于Integer b=Integer.valueOf(3))
		Integer c=3;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(Integer.MAX_VALUE);

		// 对于-128到127之间的数，会进行缓存. 超过-128~127的会自动new对象
		Integer x = 1000;
		Integer y = 1000;
		System.out.println(x == y);

	}


}
